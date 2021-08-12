package is.swan.mcmarketapi.request.requests.resource.update;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import is.swan.mcmarketapi.classes.ResourceUpdate;
import is.swan.mcmarketapi.request.Request;

public class RetrieveResourceUpdateRequest implements Request<ResourceUpdate> {

    private final int resourceId, updateId;

    public RetrieveResourceUpdateRequest(int resourceId, int updateId) {
        this.resourceId = resourceId;
        this.updateId = updateId;
    }

    @Override
    public String getURL() {
        return "https://api.mc-market.org/v1/resources/" + resourceId + "/updates/" + updateId;
    }

    @Override
    public Method getMethod() {
        return Method.GET;
    }

    @Override
    public ResourceUpdate handleJson(String json) {
        Gson gson = new Gson();
        JsonElement element = gson.fromJson(json, JsonElement.class);
        String resourceUpdateJson = element.getAsJsonObject().get("data").getAsJsonObject().toString();
        ResourceUpdate resourceUpdate = gson.fromJson(resourceUpdateJson, ResourceUpdate.class);

        return resourceUpdate;
    }
}
