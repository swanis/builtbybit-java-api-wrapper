package is.swan.mcmarketapi.request.requests.conversation.reply;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import is.swan.mcmarketapi.classes.Conversation;
import is.swan.mcmarketapi.classes.ConversationReply;
import is.swan.mcmarketapi.request.Request;
import is.swan.mcmarketapi.request.sorting.SortOptions;
import is.swan.mcmarketapi.utils.SortUtil;

public class ListUnreadConversationRepliesRequest implements Request<ConversationReply[]> {

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
    public ConversationReply[] handleJson(String json) {
        Gson gson = new Gson();
        JsonElement element = gson.fromJson(json, JsonElement.class);
        String conversationRepliesJson = element.getAsJsonObject().get("data").getAsJsonArray().toString();
        ConversationReply[] conversationReplies = gson.fromJson(conversationRepliesJson, ConversationReply[].class);

        return conversationReplies;
    }
}
