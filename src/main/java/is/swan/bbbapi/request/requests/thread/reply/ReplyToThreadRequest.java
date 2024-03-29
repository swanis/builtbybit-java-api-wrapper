package is.swan.bbbapi.request.requests.thread.reply;

import com.google.gson.JsonElement;
import is.swan.bbbapi.request.Request;

import java.util.HashMap;

public class ReplyToThreadRequest implements Request<Integer> {

    private final int threadId;
    private final String message;

    public ReplyToThreadRequest(int threadId, String message) {
        this.threadId = threadId;
        this.message = message;
    }

    @Override
    public String getURL() {
        return BASE_URL + "/threads/" + threadId + "/replies";
    }

    @Override
    public Method getMethod() {
        return Method.POST;
    }

    @Override
    public String getBody() {
        HashMap<String, String> parameters = new HashMap<>();

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
