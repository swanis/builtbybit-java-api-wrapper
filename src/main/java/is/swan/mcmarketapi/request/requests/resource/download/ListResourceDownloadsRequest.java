package is.swan.mcmarketapi.request.requests.resource.download;

import com.google.gson.JsonElement;
import is.swan.mcmarketapi.classes.Download;
import is.swan.mcmarketapi.request.Request;
import is.swan.mcmarketapi.request.sorting.SortOptions;
import is.swan.mcmarketapi.utils.SortUtil;

public class ListResourceDownloadsRequest implements Request<Download[]> {

    private final int resourceId;
    private final SortOptions sortOptions;

    public ListResourceDownloadsRequest(int resourceId, SortOptions sortOptions) {
        this.resourceId = resourceId;
        this.sortOptions = sortOptions;
    }

    @Override
    public String getURL() {
        return "https://api.mc-market.org/v1/resources/" + resourceId + "/downloads" + SortUtil.optionsToString(sortOptions);
    }

    @Override
    public Method getMethod() {
        return Method.GET;
    }

    @Override
    public Download[] handleJson(String json) {
        JsonElement element = gson.fromJson(json, JsonElement.class);
        String resourceDownloadsJson = element.getAsJsonObject().get("data").getAsJsonArray().toString();
        Download[] resourceDownloads = gson.fromJson(resourceDownloadsJson, Download[].class);

        return resourceDownloads;
    }
}
