package is.swan.mcmarketapi.request.requests.conversation.reply;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import is.swan.mcmarketapi.request.Request;

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
        return "https://api.mc-market.org/v1/conversations/" + conversationId + "/replies";
    }

    @Override
    public Method getMethod() {
        return Method.POST;
    }

    @Override
    public String getBody() {
        Gson gson = new Gson();
        HashMap<String, Object> parameters = new HashMap<>();

        parameters.put("message", message);

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
