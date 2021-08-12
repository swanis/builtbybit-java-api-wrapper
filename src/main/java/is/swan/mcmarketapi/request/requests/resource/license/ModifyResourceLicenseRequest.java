package is.swan.mcmarketapi.request.requests.resource.license;

import com.google.gson.Gson;
import is.swan.mcmarketapi.request.Request;

import java.util.HashMap;

public class ModifyResourceLicenseRequest implements Request<Void> {

    private final int resourceId, licenseId;
    private final long startDate, endDate;
    private final boolean active;

    public ModifyResourceLicenseRequest(int resourceId, int licenseId, long startDate, long endDate, boolean active) {
        this.resourceId = resourceId;
        this.licenseId = licenseId;
        this.startDate = startDate;
        this.endDate = endDate;
        this.active = active;
    }

    @Override
    public String getURL() {
        return "https://api.mc-market.org/v1/resources/" + resourceId + "/licenses/" + licenseId;
    }

    @Override
    public Method getMethod() {
        return Method.PATCH;
    }

    @Override
    public String getBody() {
        Gson gson = new Gson();
        HashMap<String, Object> parameters = new HashMap<>();

        parameters.put("start_date", startDate);
        parameters.put("end_date", endDate);
        parameters.put("active", active);

        return gson.toJson(parameters);
    }
}
