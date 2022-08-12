package is.swan.bbbapi.request.requests.thread;

import com.google.gson.JsonElement;
import is.swan.bbbapi.classes.Thread;
import is.swan.bbbapi.request.Request;

public class FetchThreadRequest implements Request<Thread> {

    private final int threadId;

    public FetchThreadRequest(int threadId) {
        this.threadId = threadId;
    }

    @Override
    public String getURL() {
        return BASE_URL + "/threads/" + threadId;
    }

    @Override
    public Method getMethod() {
        return Method.GET;
    }

    @Override
    public Thread handleJson(String json) {
        JsonElement element = GSON.fromJson(json, JsonElement.class);
        String detailedThreadJson = element.getAsJsonObject().get("data").getAsJsonObject().toString();
        Thread detailedThread = GSON.fromJson(detailedThreadJson, Thread.class);

        return detailedThread;
    }
}
