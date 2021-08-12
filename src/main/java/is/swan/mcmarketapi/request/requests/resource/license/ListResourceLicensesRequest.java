package is.swan.mcmarketapi.request.requests.resource.license;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import is.swan.mcmarketapi.classes.ResourceLicense;
import is.swan.mcmarketapi.request.Request;
import is.swan.mcmarketapi.request.sorting.SortOptions;
import is.swan.mcmarketapi.utils.SortUtil;

public class ListResourceLicensesRequest implements Request<ResourceLicense[]> {

    private final int resourceId;
    private final SortOptions sortOptions;

    public ListResourceLicensesRequest(int resourceId, SortOptions sortOptions) {
        this.resourceId = resourceId;
        this.sortOptions = sortOptions;
    }

    @Override
    public String getURL() {
        return "https://api.mc-market.org/v1/resources/" + resourceId + "/licenses" + SortUtil.optionsToString(sortOptions);
    }

    @Override
    public Method getMethod() {
        return Method.GET;
    }

    @Override
    public ResourceLicense[] handleJson(String json) {
        Gson gson = new Gson();
        JsonElement element = gson.fromJson(json, JsonElement.class);
        String resourceLicensesJson = element.getAsJsonObject().get("data").getAsJsonArray().toString();
        ResourceLicense[] resourceLicenses = gson.fromJson(resourceLicensesJson, ResourceLicense[].class);

        return resourceLicenses;
    }
}
