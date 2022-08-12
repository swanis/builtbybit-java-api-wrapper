package is.swan.bbbapi.request.requests.thread;

import com.google.gson.JsonElement;
import is.swan.bbbapi.classes.BasicThread;
import is.swan.bbbapi.request.Request;
import is.swan.bbbapi.request.sorting.SortOptions;
import is.swan.bbbapi.utils.SortUtil;

public class ListThreadsRequest implements Request<BasicThread[]> {

    private final SortOptions sortOptions;

    public ListThreadsRequest(SortOptions sortOptions) {
        this.sortOptions = sortOptions;
    }

    @Override
    public String getURL() {
        return BASE_URL + "/threads" + SortUtil.optionsToString(sortOptions);
    }

    @Override
    public Method getMethod() {
        return Method.GET;
    }

    @Override
    public BasicThread[] handleJson(String json) {
        JsonElement element = GSON.fromJson(json, JsonElement.class);
        String threadsJson = element.getAsJsonObject().get("data").getAsJsonArray().toString();
        BasicThread[] threads = GSON.fromJson(threadsJson, BasicThread[].class);

        return threads;
    }
}
