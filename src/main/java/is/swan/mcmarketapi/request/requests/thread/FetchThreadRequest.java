package is.swan.mcmarketapi.request.requests.thread;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import is.swan.mcmarketapi.classes.DetailedThread;
import is.swan.mcmarketapi.request.Request;

public class FetchThreadRequest implements Request<DetailedThread> {

    private final int threadId;

    public FetchThreadRequest(int threadId) {
        this.threadId = threadId;
    }

    @Override
    public String getURL() {
        return "https://api.mc-market.org/v1/threads/" + threadId;
    }

    @Override
    public Method getMethod() {
        return Method.GET;
    }

    @Override
    public DetailedThread handleJson(String json) {
        Gson gson = new Gson();
        JsonElement element = gson.fromJson(json, JsonElement.class);
        String detailedThreadJson = element.getAsJsonObject().get("data").getAsJsonObject().toString();
        DetailedThread detailedThread = gson.fromJson(detailedThreadJson, DetailedThread.class);

        return detailedThread;
    }
}
