package is.swan.bbbapi.request.requests.resource.license;

import com.google.gson.JsonElement;
import is.swan.bbbapi.classes.License;
import is.swan.bbbapi.request.Request;

public class RetrieveResourceLicenseRequest implements Request<License> {

    private final int resourceId, licenseId;

    public RetrieveResourceLicenseRequest(int resourceId, int licenseId) {
        this.resourceId = resourceId;
        this.licenseId = licenseId;
    }

    @Override
    public String getURL() {
        return BASE_URL + "/resources/" + resourceId + "/licenses/" + licenseId;
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
