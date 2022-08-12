package is.swan.bbbapi.request.requests.conversation;

import com.google.gson.JsonElement;
import is.swan.bbbapi.classes.Conversation;
import is.swan.bbbapi.request.Request;
import is.swan.bbbapi.request.sorting.SortOptions;
import is.swan.bbbapi.utils.SortUtil;

public class ListUnreadConversationsRequest implements Request<Conversation[]> {

    private final SortOptions sortOptions;

    public ListUnreadConversationsRequest(SortOptions sortOptions) {
        this.sortOptions = sortOptions;
    }

    @Override
    public String getURL() {
        return BASE_URL + "/conversations" + SortUtil.optionsToString(sortOptions);
    }

    @Override
    public Method getMethod() {
        return Method.GET;
    }

    @Override
    public Conversation[] handleJson(String json) {
        JsonElement element = GSON.fromJson(json, JsonElement.class);
        String conversationsJson = element.getAsJsonObject().get("data").getAsJsonArray().toString();
        Conversation[] conversations = GSON.fromJson(conversationsJson, Conversation[].class);

        return conversations;
    }
}
