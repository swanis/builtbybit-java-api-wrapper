package is.swan.mcmarketapi.request.requests.thread.reply;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import is.swan.mcmarketapi.classes.ThreadReply;
import is.swan.mcmarketapi.request.Request;
import is.swan.mcmarketapi.request.sorting.SortOptions;
import is.swan.mcmarketapi.utils.SortUtil;

public class ListThreadRepliesRequest implements Request<ThreadReply[]> {

    private final int threadId;
    private final SortOptions sortOptions;

    public ListThreadRepliesRequest(int threadId, SortOptions sortOptions) {
        this.threadId = threadId;
        this.sortOptions = sortOptions;
    }

    @Override
    public String getURL() {
        return "https://api.mc-market.org/v1/threads/" + threadId + "/replies" + SortUtil.optionsToString(sortOptions);
    }

    @Override
    public Method getMethod() {
        return Method.GET;
    }

    @Override
    public ThreadReply[] handleJson(String json) {
        Gson gson = new Gson();
        JsonElement element = gson.fromJson(json, JsonElement.class);
        String threadRepliesJson = element.getAsJsonObject().get("data").getAsJsonArray().toString();
        ThreadReply[] threadReplies = gson.fromJson(threadRepliesJson, ThreadReply[].class);

        return threadReplies;
    }
}
