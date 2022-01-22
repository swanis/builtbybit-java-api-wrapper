package is.swan.mcmarketapi.request.requests.thread;

import com.google.gson.JsonElement;
import is.swan.mcmarketapi.classes.BasicThread;
import is.swan.mcmarketapi.request.Request;
import is.swan.mcmarketapi.request.sorting.SortOptions;
import is.swan.mcmarketapi.utils.SortUtil;

public class ListThreadsRequest implements Request<BasicThread[]> {

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
    public BasicThread[] handleJson(String json) {
        JsonElement element = gson.fromJson(json, JsonElement.class);
        String threadsJson = element.getAsJsonObject().get("data").getAsJsonArray().toString();
        BasicThread[] threads = gson.fromJson(threadsJson, BasicThread[].class);

        return threads;
    }
}
