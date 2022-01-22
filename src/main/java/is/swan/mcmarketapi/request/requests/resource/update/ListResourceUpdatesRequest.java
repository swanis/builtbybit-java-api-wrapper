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
        return "https://api.mc-market.org/v1/resources/" + resourceId + "/updates" + SortUtil.optionsToString(sortOptions);
    }

    @Override
    public Method getMethod() {
        return Method.GET;
    }

    @Override
    public Update[] handleJson(String json) {
        JsonElement element = gson.fromJson(json, JsonElement.class);
        String resourceUpdatesJson = element.getAsJsonObject().get("data").getAsJsonArray().toString();
        Update[] resourceUpdates = gson.fromJson(resourceUpdatesJson, Update[].class);

        return resourceUpdates;
    }
}
