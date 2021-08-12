package is.swan.mcmarketapi.request.requests.resource;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import is.swan.mcmarketapi.classes.Resource;
import is.swan.mcmarketapi.request.Request;
import is.swan.mcmarketapi.request.sorting.SortOptions;
import is.swan.mcmarketapi.utils.SortUtil;

public class ListOwnedResourcesRequest implements Request<Resource[]> {

    private final SortOptions sortOptions;

    public ListOwnedResourcesRequest(SortOptions sortOptions) {
        this.sortOptions = sortOptions;
    }

    @Override
    public String getURL() {
        return "https://api.mc-market.org/v1/resources/owned" + SortUtil.optionsToString(sortOptions);
    }

    @Override
    public Method getMethod() {
        return Method.GET;
    }

    @Override
    public Resource[] handleJson(String json) {
        Gson gson = new Gson();
        JsonElement element = gson.fromJson(json, JsonElement.class);
        String resourcesJson = element.getAsJsonObject().get("data").getAsJsonArray().toString();
        Resource[] resources = gson.fromJson(resourcesJson, Resource[].class);

        return resources;
    }
}
