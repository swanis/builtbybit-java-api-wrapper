package is.swan.mcmarketapi.request.requests.resource;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import is.swan.mcmarketapi.classes.Resource;
import is.swan.mcmarketapi.request.Request;

public class RetrieveResourceRequest implements Request<Resource> {

    private final int resourceId;

    public RetrieveResourceRequest(int resourceId) {
        this.resourceId = resourceId;
    }

    @Override
    public String getURL() {
        return "https://api.mc-market.org/v1/resources/" + resourceId;
    }

    @Override
    public Method getMethod() {
        return Method.GET;
    }

    @Override
    public Resource handleJson(String json) {
        Gson gson = new Gson();
        JsonElement element = gson.fromJson(json, JsonElement.class);
        String detailedResourceJson = element.getAsJsonObject().get("data").getAsJsonObject().toString();
        Resource detailedResource = gson.fromJson(detailedResourceJson, Resource.class);

        return detailedResource;
    }
}
