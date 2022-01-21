package is.swan.mcmarketapi.request.requests.resource.version;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import is.swan.mcmarketapi.classes.Version;
import is.swan.mcmarketapi.request.Request;

public class RetrieveResourceVersionRequest implements Request<Version> {

    private final int resourceId, versionId;

    public RetrieveResourceVersionRequest(int resourceId, int versionId) {
        this.resourceId = resourceId;
        this.versionId = versionId;
    }

    @Override
    public String getURL() {
        return "https://api.mc-market.org/v1/resources/" + resourceId + "/versions/" + versionId;
    }

    @Override
    public Method getMethod() {
        return Method.GET;
    }

    @Override
    public Version handleJson(String json) {
        Gson gson = new Gson();
        JsonElement element = gson.fromJson(json, JsonElement.class);
        String resourceVersionJson = element.getAsJsonObject().get("data").getAsJsonObject().toString();
        Version resourceVersion = gson.fromJson(resourceVersionJson, Version.class);

        return resourceVersion;
    }
}
