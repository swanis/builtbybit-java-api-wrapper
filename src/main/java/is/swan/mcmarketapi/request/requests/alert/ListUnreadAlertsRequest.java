package is.swan.mcmarketapi.request.requests.alert;

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
        return BASE_URL + "/alerts" + SortUtil.optionsToString(sortOptions);
    }

    @Override
    public Method getMethod() {
        return Method.GET;
    }

    @Override
    public Alert[] handleJson(String json) {
        JsonElement element = GSON.fromJson(json, JsonElement.class);
        String alertsJson = element.getAsJsonObject().get("data").getAsJsonArray().toString();
        Alert[] alerts = GSON.fromJson(alertsJson, Alert[].class);

        return alerts;
    }
}
