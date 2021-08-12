package is.swan.mcmarketapi.request.requests.conversation;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import is.swan.mcmarketapi.classes.Conversation;
import is.swan.mcmarketapi.request.Request;
import is.swan.mcmarketapi.request.sorting.SortOptions;
import is.swan.mcmarketapi.utils.SortUtil;

public class ListUnreadConversationsRequest implements Request<Conversation[]> {

    private final SortOptions sortOptions;

    public ListUnreadConversationsRequest(SortOptions sortOptions) {
        this.sortOptions = sortOptions;
    }

    @Override
    public String getURL() {
        return "https://api.mc-market.org/v1/conversations" + SortUtil.optionsToString(sortOptions);
    }

    @Override
    public Method getMethod() {
        return Method.GET;
    }

    @Override
    public Conversation[] handleJson(String json) {
        Gson gson = new Gson();
        JsonElement element = gson.fromJson(json, JsonElement.class);
        String conversationsJson = element.getAsJsonObject().get("data").getAsJsonArray().toString();
        Conversation[] conversations = gson.fromJson(conversationsJson, Conversation[].class);

        return conversations;
    }
}
