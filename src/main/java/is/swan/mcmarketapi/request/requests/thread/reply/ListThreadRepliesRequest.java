package is.swan.mcmarketapi.request.requests.thread.reply;

import com.google.gson.JsonElement;
import is.swan.mcmarketapi.classes.Reply;
import is.swan.mcmarketapi.request.Request;
import is.swan.mcmarketapi.request.sorting.SortOptions;
import is.swan.mcmarketapi.utils.SortUtil;

public class ListThreadRepliesRequest implements Request<Reply[]> {

    private final int threadId;
    private final SortOptions sortOptions;

    public ListThreadRepliesRequest(int threadId, SortOptions sortOptions) {
        this.threadId = threadId;
        this.sortOptions = sortOptions;
    }

    @Override
    public String getURL() {
        return BASE_URL + "/threads/" + threadId + "/replies" + SortUtil.optionsToString(sortOptions);
    }

    @Override
    public Method getMethod() {
        return Method.GET;
    }

    @Override
    public Reply[] handleJson(String json) {
        JsonElement element = GSON.fromJson(json, JsonElement.class);
        String threadRepliesJson = element.getAsJsonObject().get("data").getAsJsonArray().toString();
        Reply[] threadReplies = GSON.fromJson(threadRepliesJson, Reply[].class);

        return threadReplies;
    }
}
