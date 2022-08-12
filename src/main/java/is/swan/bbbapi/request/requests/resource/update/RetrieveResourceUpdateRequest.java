package is.swan.bbbapi.request.requests.resource.update;

import com.google.gson.JsonElement;
import is.swan.bbbapi.classes.Update;
import is.swan.bbbapi.request.Request;

public class RetrieveResourceUpdateRequest implements Request<Update> {

    private final int resourceId, updateId;

    public RetrieveResourceUpdateRequest(int resourceId, int updateId) {
        this.resourceId = resourceId;
        this.updateId = updateId;
    }

    @Override
    public String getURL() {
        return BASE_URL + "/resources/" + resourceId + "/updates/" + updateId;
    }

    @Override
    public Method getMethod() {
        return Method.GET;
    }

    @Override
    public Update handleJson(String json) {
        JsonElement element = GSON.fromJson(json, JsonElement.class);
        String resourceUpdateJson = element.getAsJsonObject().get("data").getAsJsonObject().toString();
        Update resourceUpdate = GSON.fromJson(resourceUpdateJson, Update.class);

        return resourceUpdate;
    }
}
