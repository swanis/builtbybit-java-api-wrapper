package is.swan.mcmarketapi.request.requests.resource;

import com.google.gson.JsonElement;
import is.swan.mcmarketapi.classes.BasicResource;
import is.swan.mcmarketapi.request.Request;
import is.swan.mcmarketapi.request.sorting.SortOptions;
import is.swan.mcmarketapi.utils.SortUtil;

public class ListResourcesByAuthorRequest implements Request<BasicResource[]> {

    private final int userId;
    private final SortOptions sortOptions;

    public ListResourcesByAuthorRequest(int userId, SortOptions sortOptions) {
        this.userId = userId;
        this.sortOptions = sortOptions;
    }

    @Override
    public String getURL() {
        return BASE_URL + "/resources/authors/" + userId + SortUtil.optionsToString(sortOptions);
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
