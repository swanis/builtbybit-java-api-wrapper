package is.swan.mcmarketapi.request.requests.resource.license;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import is.swan.mcmarketapi.classes.ResourceLicense;
import is.swan.mcmarketapi.request.Request;

public class RetrieveResourceLicenseByMemberRequest implements Request<ResourceLicense> {

    private final int resourceId, memberId, nonce;
    private final long timestamp;

    public RetrieveResourceLicenseByMemberRequest(int resourceId, int memberId, int nonce, long timestamp) {
        this.resourceId = resourceId;
        this.memberId = memberId;
        this.nonce = nonce;
        this.timestamp = timestamp;
    }

    @Override
    public String getURL() {
        return "https://api.mc-market.org/v1/resources/" + resourceId + "/licenses/member/" + memberId + "?nonce=" + nonce + "&timestamp=" + timestamp;
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
