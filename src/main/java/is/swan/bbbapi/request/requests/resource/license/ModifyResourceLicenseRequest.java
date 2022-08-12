package is.swan.bbbapi.request.requests.resource.license;

import is.swan.bbbapi.request.Request;

import java.util.HashMap;

public class ModifyResourceLicenseRequest implements Request<Void> {

    private final int resourceId, licenseId;
    private final boolean permanent, active;
    private final long startDate, endDate;

    public ModifyResourceLicenseRequest(int resourceId, int licenseId, boolean permanent, boolean active, long startDate, long endDate) {
        this.resourceId = resourceId;
        this.licenseId = licenseId;
        this.permanent = permanent;
        this.active = active;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    @Override
    public String getURL() {
        return BASE_URL + "/resources/" + resourceId + "/licenses/" + licenseId;
    }

    @Override
    public Method getMethod() {
        return Method.PATCH;
    }

    @Override
    public String getBody() {
        HashMap<String, Object> parameters = new HashMap<>();

        parameters.put("permanent", permanent);
        parameters.put("active", active);
        parameters.put("start_date", startDate);
        parameters.put("end_date", endDate);

        return GSON.toJson(parameters);
    }
}
