package is.swan.mcmarketapi.request.requests.resource.update;

import com.google.gson.JsonElement;
import is.swan.mcmarketapi.classes.Update;
import is.swan.mcmarketapi.request.Request;
import is.swan.mcmarketapi.request.sorting.SortOptions;
import is.swan.mcmarketapi.utils.SortUtil;

public class ListResourceUpdatesRequest implements Request<Update[]> {

    private final int resourceId;
    private final SortOptions sortOptions;

    public ListResourceUpdatesRequest(int resourceId, SortOptions sortOptions) {
        this.resourceId = resourceId;
        this.sortOptions = sortOptions;
    }

    @Override
    public String getURL() {
        return BASE_URL + "/resources/" + resourceId + "/updates" + SortUtil.optionsToString(sortOptions);
    }

    @Override
    public Method getMethod() {
        return Method.GET;
    }

    @Override
    public Update[] handleJson(String json) {
        JsonElement element = GSON.fromJson(json, JsonElement.class);
        String resourceUpdatesJson = element.getAsJsonObject().get("data").getAsJsonArray().toString();
        Update[] resourceUpdates = GSON.fromJson(resourceUpdatesJson, Update[].class);

        return resourceUpdates;
    }
}
