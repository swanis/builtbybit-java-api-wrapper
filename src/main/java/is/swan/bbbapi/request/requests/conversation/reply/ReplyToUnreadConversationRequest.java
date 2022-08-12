package is.swan.bbbapi.request.requests.conversation.reply;

import com.google.gson.JsonElement;
import is.swan.bbbapi.request.Request;

import java.util.HashMap;

public class ReplyToUnreadConversationRequest implements Request<Integer> {

    private final int conversationId;
    private final String message;

    public ReplyToUnreadConversationRequest(int conversationId, String message) {
        this.conversationId = conversationId;
        this.message = message;
    }

    @Override
    public String getURL() {
        return BASE_URL + "/conversations/" + conversationId + "/replies";
    }

    @Override
    public Method getMethod() {
        return Method.POST;
    }

    @Override
    public String getBody() {
        HashMap<String, Object> parameters = new HashMap<>();

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
