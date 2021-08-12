package is.swan.mcmarketapi.request.requests.resource.version;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import is.swan.mcmarketapi.classes.ResourceVersion;
import is.swan.mcmarketapi.request.Request;

public class RetrieveLatestResourceVersionRequest implements Request<ResourceVersion> {

    private final int resourceId;

    public RetrieveLatestResourceVersionRequest(int resourceId) {
        this.resourceId = resourceId;
    }

    @Override
    public String getURL() {
        return "https://api.mc-market.org/v1/resources/" + resourceId + "/versions/latest";
    }

    @Override
    public Method getMethod() {
        return Method.GET;
    }

    @Override
    public ResourceVersion handleJson(String json) {
        Gson gson = new Gson();
        JsonElement element = gson.fromJson(json, JsonElement.class);
        String resourceVersionJson = element.getAsJsonObject().get("data").getAsJsonObject().toString();
        ResourceVersion resourceVersion = gson.fromJson(resourceVersionJson, ResourceVersion.class);

        return resourceVersion;
    }
}
