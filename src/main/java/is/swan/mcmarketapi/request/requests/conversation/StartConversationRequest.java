package is.swan.mcmarketapi.request.requests.conversation;

import com.google.gson.Gson;
import is.swan.mcmarketapi.request.Request;

import java.util.HashMap;

public class StartConversationRequest implements Request<Void> {

    private final int recipientId;
    private final String title, message;

    public StartConversationRequest(int recipientId, String title, String message) {
        this.recipientId = recipientId;
        this.title = title;
        this.message = message;
    }

    @Override
    public String getURL() {
        return "https://api.mc-market.org/v1/conversations";
    }

    @Override
    public Method getMethod() {
        return Method.POST;
    }

    @Override
    public String getBody() {
        Gson gson = new Gson();
        HashMap<String, Object> parameters = new HashMap<>();

        parameters.put("recipient_id", recipientId);
        parameters.put("title", title);
        parameters.put("message", message);

        return gson.toJson(parameters);
    }
}
