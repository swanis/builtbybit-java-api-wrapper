package is.swan.bbbapi.request.requests.resource;

import com.google.gson.JsonElement;
import is.swan.bbbapi.classes.Resource;
import is.swan.bbbapi.request.Request;

public class RetrieveResourceRequest implements Request<Resource> {

    private final int resourceId;

    public RetrieveResourceRequest(int resourceId) {
        this.resourceId = resourceId;
    }

    @Override
    public String getURL() {
        return BASE_URL + "/resources/" + resourceId;
    }

    @Override
    public Method getMethod() {
        return Method.GET;
    }

    @Override
    public Resource handleJson(String json) {
        JsonElement element = GSON.fromJson(json, JsonElement.class);
        String detailedResourceJson = element.getAsJsonObject().get("data").getAsJsonObject().toString();
        Resource detailedResource = GSON.fromJson(detailedResourceJson, Resource.class);

        return detailedResource;
    }
}
