package is.swan.mcmarketapi.request.requests.conversation.reply;

import com.google.gson.Gson;
import is.swan.mcmarketapi.request.Request;

import java.util.HashMap;

public class ReplyToUnreadConversationRequest implements Request<Void> {

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
}
