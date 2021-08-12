package is.swan.mcmarketapi.request.requests.resource.license;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import is.swan.mcmarketapi.classes.ResourceLicense;
import is.swan.mcmarketapi.request.Request;

public class ValidateResourceLicenseRequest implements Request<ResourceLicense> {

    private final int resourceId, purchaserId;

    public ValidateResourceLicenseRequest(int resourceId, int purchaserId) {
        this.resourceId = resourceId;
        this.purchaserId = purchaserId;
    }

    @Override
    public String getURL() {
        return "https://api.mc-market.org/v1/resources/" + resourceId + "/licenses/validate/" + purchaserId;
    }

    @Override
    public Method getMethod() {
        return Method.GET;
    }

    @Override
    public ResourceLicense handleJson(String json) {
        Gson gson = new Gson();
        JsonElement element = gson.fromJson(json, JsonElement.class);
        String resourceLicenseJson = element.getAsJsonObject().get("data").getAsJsonObject().toString();
        ResourceLicense resourceLicense = gson.fromJson(resourceLicenseJson, ResourceLicense.class);

        return resourceLicense;
    }
}
