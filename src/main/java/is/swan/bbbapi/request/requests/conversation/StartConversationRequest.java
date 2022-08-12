package is.swan.bbbapi.request.requests.conversation;

import com.google.gson.JsonElement;
import is.swan.bbbapi.request.Request;

import java.util.HashMap;

public class StartConversationRequest implements Request<Integer> {

    private final int[] recipientIds;
    private final String title, message;

    public StartConversationRequest(int[] recipientIds, String title, String message) {
        this.recipientIds = recipientIds;
        this.title = title;
        this.message = message;
    }

    @Override
    public String getURL() {
        return BASE_URL + "/conversations";
    }

    @Override
    public Method getMethod() {
        return Method.POST;
    }

    @Override
    public String getBody() {
        HashMap<String, Object> parameters = new HashMap<>();

        parameters.put("recipient_ids", recipientIds);
        parameters.put("title", title);
        parameters.put("message", message);

        return GSON.toJson(parameters);
    }

    @Override
    public Integer handleJson(String json) {
        JsonElement element = GSON.fromJson(json, JsonElement.class);
        int id = element.getAsJsonObject().get("data").getAsInt();

        return id;
    }
}
