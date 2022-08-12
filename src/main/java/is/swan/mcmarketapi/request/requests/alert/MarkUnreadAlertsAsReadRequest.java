package is.swan.mcmarketapi.request.requests.alert;

import is.swan.mcmarketapi.request.Request;

import java.util.HashMap;

public class MarkUnreadAlertsAsReadRequest implements Request<Void> {

    private final boolean read;

    public MarkUnreadAlertsAsReadRequest(boolean read) {
        this.read = read;
    }

    @Override
    public String getURL() {
        return BASE_URL + "/alerts";
    }

    @Override
    public Method getMethod() {
        return Method.PATCH;
    }

    @Override
    public String getBody() {
        HashMap<String, Boolean> parameters = new HashMap<>();

        parameters.put("read", read);

        return GSON.toJson(parameters);
    }
}
