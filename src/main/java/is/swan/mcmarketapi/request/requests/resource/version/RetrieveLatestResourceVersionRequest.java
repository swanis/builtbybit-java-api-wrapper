package is.swan.mcmarketapi.request.requests.resource.version;

import com.google.gson.JsonElement;
import is.swan.mcmarketapi.classes.Version;
import is.swan.mcmarketapi.request.Request;

public class RetrieveLatestResourceVersionRequest implements Request<Version> {

    private final int resourceId;

    public RetrieveLatestResourceVersionRequest(int resourceId) {
        this.resourceId = resourceId;
    }

    @Override
    public String getURL() {
        return BASE_URL + "/resources/" + resourceId + "/versions/latest";
    }

    @Override
    public Method getMethod() {
        return Method.GET;
    }

    @Override
    public Version handleJson(String json) {
        JsonElement element = GSON.fromJson(json, JsonElement.class);
        String resourceVersionJson = element.getAsJsonObject().get("data").getAsJsonObject().toString();
        Version resourceVersion = GSON.fromJson(resourceVersionJson, Version.class);

        return resourceVersion;
    }
}
