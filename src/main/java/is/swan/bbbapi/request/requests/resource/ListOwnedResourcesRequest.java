package is.swan.bbbapi.request.requests.resource;

import com.google.gson.JsonElement;
import is.swan.bbbapi.classes.BasicResource;
import is.swan.bbbapi.request.Request;
import is.swan.bbbapi.request.sorting.SortOptions;
import is.swan.bbbapi.utils.SortUtil;

public class ListOwnedResourcesRequest implements Request<BasicResource[]> {

    private final SortOptions sortOptions;

    public ListOwnedResourcesRequest(SortOptions sortOptions) {
        this.sortOptions = sortOptions;
    }

    @Override
    public String getURL() {
        return BASE_URL + "/resources/owned" + SortUtil.optionsToString(sortOptions);
    }

    @Override
    public Method getMethod() {
        return Method.GET;
    }

    @Override
    public BasicResource[] handleJson(String json) {
        JsonElement element = GSON.fromJson(json, JsonElement.class);
        String resourcesJson = element.getAsJsonObject().get("data").getAsJsonArray().toString();
        BasicResource[] resources = GSON.fromJson(resourcesJson, BasicResource[].class);

        return resources;
    }
}
