package is.swan.mcmarketapi.request.requests.resource.license;

import com.google.gson.JsonElement;
import is.swan.mcmarketapi.request.Request;

import java.util.HashMap;

public class IssueResourceLicenseRequest implements Request<Integer> {

    private final int resourceId, purchaserId;
    private final boolean permanent, active;
    private final long startDate, endDate;

    public IssueResourceLicenseRequest(int resourceId, boolean permanent, boolean active, int purchaserId, long startDate, long endDate) {
        this.resourceId = resourceId;
        this.purchaserId = purchaserId;
        this.permanent = permanent;
        this.active = active;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    @Override
    public String getURL() {
        return "https://api.mc-market.org/v1/resources/" + resourceId + "/licenses";
    }

    @Override
    public Method getMethod() {
        return Method.POST;
    }

    @Override
    public String getBody() {
        HashMap<String, Object> parameters = new HashMap<>();

        parameters.put("purchaser_id", purchaserId);
        parameters.put("permanent", permanent);
        parameters.put("active", active);
        parameters.put("start_date", startDate);
        parameters.put("end_date", endDate);

        return gson.toJson(parameters);
    }

    @Override
    public Integer handleJson(String json) {
        JsonElement element = gson.fromJson(json, JsonElement.class);
        int id = element.getAsJsonObject().get("data").getAsInt();

        return id;
    }
}
