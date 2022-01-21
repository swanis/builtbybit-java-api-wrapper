package is.swan.mcmarketapi.request.requests.resource.update;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import is.swan.mcmarketapi.classes.Update;
import is.swan.mcmarketapi.request.Request;

public class RetrieveLatestResourceUpdateRequest implements Request<Update> {

    private final int resourceId;

    public RetrieveLatestResourceUpdateRequest(int resourceId) {
        this.resourceId = resourceId;
    }

    @Override
    public String getURL() {
        return "https://api.mc-market.org/v1/resources/" + resourceId + "/updates/latest";
    }

    @Override
    public Method getMethod() {
        return Method.GET;
    }

    @Override
    public Update handleJson(String json) {
        Gson gson = new Gson();
        JsonElement element = gson.fromJson(json, JsonElement.class);
        String resourceUpdateJson = element.getAsJsonObject().get("data").getAsJsonObject().toString();
        Update resourceUpdate = gson.fromJson(resourceUpdateJson, Update.class);

        return resourceUpdate;
    }
}
