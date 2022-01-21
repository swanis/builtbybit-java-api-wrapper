package is.swan.mcmarketapi.request.requests.resource.license;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import is.swan.mcmarketapi.request.Request;

import java.util.HashMap;

public class IssueResourceLicenseRequest implements Request<Integer> {

    private final int resourceId, purchaserId;
    private final long startDate, endDate;
    private final boolean active;
    private final String siteUrl;

    public IssueResourceLicenseRequest(int resourceId, int purchaserId, long startDate, long endDate, boolean active, String siteUrl) {
        this.resourceId = resourceId;
        this.purchaserId = purchaserId;
        this.startDate = startDate;
        this.endDate = endDate;
        this.active = active;
        this.siteUrl = siteUrl;
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
        Gson gson = new Gson();
        HashMap<String, Object> parameters = new HashMap<>();

        parameters.put("purchaser_id", purchaserId);
        parameters.put("start_date", startDate);
        parameters.put("end_date", endDate);
        parameters.put("active", active);
        parameters.put("site_url", siteUrl);

        return gson.toJson(parameters);
    }

    @Override
    public Integer handleJson(String json) {
        Gson gson = new Gson();
        JsonElement element = gson.fromJson(json, JsonElement.class);
        int id = element.getAsJsonObject().get("data").getAsInt();

        return id;
    }
}
