package is.swan.mcmarketapi.request.requests.resource.license;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import is.swan.mcmarketapi.classes.License;
import is.swan.mcmarketapi.request.Request;

public class RetrieveResourceLicenseRequest implements Request<License> {

    private final int resourceId, licenseId;

    public RetrieveResourceLicenseRequest(int resourceId, int licenseId) {
        this.resourceId = resourceId;
        this.licenseId = licenseId;
    }

    @Override
    public String getURL() {
        return "https://api.mc-market.org/v1/resources/" + resourceId + "/licenses/" + licenseId;
    }

    @Override
    public Method getMethod() {
        return Method.GET;
    }

    @Override
    public License handleJson(String json) {
        Gson gson = new Gson();
        JsonElement element = gson.fromJson(json, JsonElement.class);
        String resourceLicenseJson = element.getAsJsonObject().get("data").getAsJsonObject().toString();
        License resourceLicense = gson.fromJson(resourceLicenseJson, License.class);

        return resourceLicense;
    }
}
