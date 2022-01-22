package is.swan.mcmarketapi.request.requests.conversation.reply;

import com.google.gson.JsonElement;
import is.swan.mcmarketapi.classes.Reply;
import is.swan.mcmarketapi.request.Request;
import is.swan.mcmarketapi.request.sorting.SortOptions;
import is.swan.mcmarketapi.utils.SortUtil;

public class ListUnreadConversationRepliesRequest implements Request<Reply[]> {

    private final int conversationId;
    private final SortOptions sortOptions;

    public ListUnreadConversationRepliesRequest(int conversationId, SortOptions sortOptions) {
        this.conversationId = conversationId;
        this.sortOptions = sortOptions;
    }

    @Override
    public String getURL() {
        return "https://api.mc-market.org/v1/conversations/" + conversationId + "/replies" + SortUtil.optionsToString(sortOptions);
    }

    @Override
    public Method getMethod() {
        return Method.GET;
    }

    @Override
    public Reply[] handleJson(String json) {
        JsonElement element = gson.fromJson(json, JsonElement.class);
        String conversationRepliesJson = element.getAsJsonObject().get("data").getAsJsonArray().toString();
        Reply[] conversationReplies = gson.fromJson(conversationRepliesJson, Reply[].class);

        return conversationReplies;
    }
}
