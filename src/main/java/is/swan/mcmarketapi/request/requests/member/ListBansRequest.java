package is.swan.mcmarketapi.request.requests.member;

import com.google.gson.JsonElement;
import is.swan.mcmarketapi.classes.Ban;
import is.swan.mcmarketapi.request.Request;

public class ListBansRequest implements Request<Ban[]> {

    @Override
    public String getURL() {
        return BASE_URL + "/members/bans";
    }

    @Override
    public Method getMethod() {
        return Method.GET;
    }

    @Override
    public Ban[] handleJson(String json) {
        JsonElement element = GSON.fromJson(json, JsonElement.class);
        String bansJson = element.getAsJsonObject().get("data").getAsJsonArray().toString();
        Ban[] bans = GSON.fromJson(bansJson, Ban[].class);

        return bans;
    }
}
