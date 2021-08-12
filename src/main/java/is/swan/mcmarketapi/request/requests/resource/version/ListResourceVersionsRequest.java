package is.swan.mcmarketapi.request.requests.resource.version;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import is.swan.mcmarketapi.classes.ResourceVersion;
import is.swan.mcmarketapi.request.Request;
import is.swan.mcmarketapi.request.sorting.SortOptions;
import is.swan.mcmarketapi.utils.SortUtil;

public class ListResourceVersionsRequest implements Request<ResourceVersion[]> {

    private final int resourceId;
    private final SortOptions sortOptions;

    public ListResourceVersionsRequest(int resourceId, SortOptions sortOptions) {
        this.resourceId = resourceId;
        this.sortOptions = sortOptions;
    }

    @Override
    public String getURL() {
        return "https://api.mc-market.org/v1/resources/" + resourceId + "/versions" + SortUtil.optionsToString(sortOptions);
    }

    @Override
    public Method getMethod() {
        return Method.GET;
    }

    @Override
    public ResourceVersion[] handleJson(String json) {
        Gson gson = new Gson();
        JsonElement element = gson.fromJson(json, JsonElement.class);
        String resourceVersionsJson = element.getAsJsonObject().get("data").getAsJsonArray().toString();
        ResourceVersion[] resourceVersions = gson.fromJson(resourceVersionsJson, ResourceVersion[].class);

        return resourceVersions;
    }
}
