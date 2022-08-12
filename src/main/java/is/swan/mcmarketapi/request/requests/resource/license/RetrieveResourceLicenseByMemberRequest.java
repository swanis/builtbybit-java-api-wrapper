package is.swan.mcmarketapi.request.requests.resource.license;

import com.google.gson.JsonElement;
import is.swan.mcmarketapi.classes.License;
import is.swan.mcmarketapi.request.Request;

public class RetrieveResourceLicenseByMemberRequest implements Request<License> {

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
        return BASE_URL + "/resources/" + resourceId + "/licenses/members/" + memberId + "?nonce=" + nonce + "&timestamp=" + timestamp;
    }

    @Override
    public Method getMethod() {
        return Method.GET;
    }

    @Override
    public License handleJson(String json) {
        JsonElement element = GSON.fromJson(json, JsonElement.class);
        String resourceLicenseJson = element.getAsJsonObject().get("data").getAsJsonObject().toString();
        License resourceLicense = GSON.fromJson(resourceLicenseJson, License.class);

        return resourceLicense;
    }
}
