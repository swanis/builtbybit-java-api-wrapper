package is.swan.mcmarketapi.request.requests.alert;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import is.swan.mcmarketapi.classes.Alert;
import is.swan.mcmarketapi.request.Request;
import is.swan.mcmarketapi.request.sorting.SortOptions;
import is.swan.mcmarketapi.utils.SortUtil;

public class ListUnreadAlertsRequest implements Request<Alert[]> {

    private final SortOptions sortOptions;

    public ListUnreadAlertsRequest(SortOptions sortOptions) {
        this.sortOptions = sortOptions;
    }

    @Override
    public String getURL() {
        return "https://api.mc-market.org/v1/alerts" + SortUtil.optionsToString(sortOptions);
    }

    @Override
    public Method getMethod() {
        return Method.GET;
    }

    @Override
    public Alert[] handleJson(String json) {
        Gson gson = new Gson();
        JsonElement element = gson.fromJson(json, JsonElement.class);
        String alertsJson = element.getAsJsonObject().get("data").getAsJsonArray().toString();
        Alert[] alerts = gson.fromJson(alertsJson, Alert[].class);

        return alerts;
    }
}
