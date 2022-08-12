package is.swan.mcmarketapi.request.requests.resource.license;

import com.google.gson.JsonElement;
import is.swan.mcmarketapi.classes.License;
import is.swan.mcmarketapi.request.Request;
import is.swan.mcmarketapi.request.sorting.SortOptions;
import is.swan.mcmarketapi.utils.SortUtil;

public class ListResourceLicensesRequest implements Request<License[]> {

    private final int resourceId;
    private final SortOptions sortOptions;

    public ListResourceLicensesRequest(int resourceId, SortOptions sortOptions) {
        this.resourceId = resourceId;
        this.sortOptions = sortOptions;
    }

    @Override
    public String getURL() {
        return BASE_URL + "/resources/" + resourceId + "/licenses" + SortUtil.optionsToString(sortOptions);
    }

    @Override
    public Method getMethod() {
        return Method.GET;
    }

    @Override
    public License[] handleJson(String json) {
        JsonElement element = GSON.fromJson(json, JsonElement.class);
        String resourceLicensesJson = element.getAsJsonObject().get("data").getAsJsonArray().toString();
        License[] resourceLicenses = GSON.fromJson(resourceLicensesJson, License[].class);

        return resourceLicenses;
    }
}
