package is.swan.bbbapi.request.requests.resource.purchase;

import com.google.gson.JsonElement;
import is.swan.bbbapi.classes.Purchase;
import is.swan.bbbapi.request.Request;

public class RetrieveResourcePurchaseRequest implements Request<Purchase> {

    private final int resourceId, purchaseId;

    public RetrieveResourcePurchaseRequest(int resourceId, int purchaseId) {
        this.resourceId = resourceId;
        this.purchaseId = purchaseId;
    }

    @Override
    public String getURL() {
        return BASE_URL + "/resources/" + resourceId + "/purchases/" + purchaseId;
    }

    @Override
    public Method getMethod() {
        return Method.GET;
    }

    @Override
    public Purchase handleJson(String json) {
        JsonElement element = GSON.fromJson(json, JsonElement.class);
        String resourcePurchaseJson = element.getAsJsonObject().get("data").getAsJsonObject().toString();
        Purchase resourcePurchase = GSON.fromJson(resourcePurchaseJson, Purchase.class);

        return resourcePurchase;
    }
}
