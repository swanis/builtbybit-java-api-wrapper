package is.swan.mcmarketapi.request.requests.resource.version;

import com.google.gson.JsonElement;
import is.swan.mcmarketapi.classes.Version;
import is.swan.mcmarketapi.request.Request;
import is.swan.mcmarketapi.request.sorting.SortOptions;
import is.swan.mcmarketapi.utils.SortUtil;

public class ListResourceVersionsRequest implements Request<Version[]> {

    private final int resourceId;
    private final SortOptions sortOptions;

    public ListResourceVersionsRequest(int resourceId, SortOptions sortOptions) {
        this.resourceId = resourceId;
        this.sortOptions = sortOptions;
    }

    @Override
    public String getURL() {
        return BASE_URL + "/resources/" + resourceId + "/versions" + SortUtil.optionsToString(sortOptions);
    }

    @Override
    public Method getMethod() {
        return Method.GET;
    }

    @Override
    public Version[] handleJson(String json) {
        JsonElement element = GSON.fromJson(json, JsonElement.class);
        String resourceVersionsJson = element.getAsJsonObject().get("data").getAsJsonArray().toString();
        Version[] resourceVersions = GSON.fromJson(resourceVersionsJson, Version[].class);

        return resourceVersions;
    }
}
