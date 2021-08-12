package is.swan.mcmarketapi.request.requests.resource;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import is.swan.mcmarketapi.classes.DetailedResource;
import is.swan.mcmarketapi.request.Request;

public class RetrieveResourceRequest implements Request<DetailedResource> {

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
    public DetailedResource handleJson(String json) {
        Gson gson = new Gson();
        JsonElement element = gson.fromJson(json, JsonElement.class);
        String detailedResourceJson = element.getAsJsonObject().get("data").getAsJsonObject().toString();
        DetailedResource detailedResource = gson.fromJson(detailedResourceJson, DetailedResource.class);

        return detailedResource;
    }
}
