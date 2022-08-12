package is.swan.mcmarketapi.request.requests.resource.purchase;

import com.google.gson.JsonElement;
import is.swan.mcmarketapi.classes.Purchase;
import is.swan.mcmarketapi.request.Request;
import is.swan.mcmarketapi.request.sorting.SortOptions;
import is.swan.mcmarketapi.utils.SortUtil;

public class ListResourcePurchasesRequest implements Request<Purchase[]> {

    private final int resourceId;
    private final SortOptions sortOptions;

    public ListResourcePurchasesRequest(int resourceId, SortOptions sortOptions) {
        this.resourceId = resourceId;
        this.sortOptions = sortOptions;
    }

    @Override
    public String getURL() {
        return BASE_URL + "/resources/" + resourceId + "/purchases" + SortUtil.optionsToString(sortOptions);
    }

    @Override
    public Method getMethod() {
        return Method.GET;
    }

    @Override
    public Purchase[] handleJson(String json) {
        JsonElement element = GSON.fromJson(json, JsonElement.class);
        String resourcePurchasesJson = element.getAsJsonObject().get("data").getAsJsonArray().toString();
        Purchase[] resourcePurchases = GSON.fromJson(resourcePurchasesJson, Purchase[].class);

        return resourcePurchases;
    }
}
