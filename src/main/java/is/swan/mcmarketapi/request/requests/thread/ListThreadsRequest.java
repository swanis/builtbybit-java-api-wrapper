package is.swan.mcmarketapi.request.requests.thread;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import is.swan.mcmarketapi.classes.Thread;
import is.swan.mcmarketapi.request.Request;
import is.swan.mcmarketapi.request.sorting.SortOptions;
import is.swan.mcmarketapi.utils.SortUtil;

public class ListThreadsRequest implements Request<Thread[]> {

    private final SortOptions sortOptions;

    public ListThreadsRequest(SortOptions sortOptions) {
        this.sortOptions = sortOptions;
    }

    @Override
    public String getURL() {
        return "https://api.mc-market.org/v1/threads" + SortUtil.optionsToString(sortOptions);
    }

    @Override
    public Method getMethod() {
        return Method.GET;
    }

    @Override
    public Thread[] handleJson(String json) {
        Gson gson = new Gson();
        JsonElement element = gson.fromJson(json, JsonElement.class);
        String threadsJson = element.getAsJsonObject().get("data").getAsJsonArray().toString();
        Thread[] threads = gson.fromJson(threadsJson, Thread[].class);

        return threads;
    }
}
