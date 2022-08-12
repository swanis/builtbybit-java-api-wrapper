package is.swan.bbbapi.request.requests.member;

import com.google.gson.JsonElement;
import is.swan.bbbapi.classes.Member;
import is.swan.bbbapi.request.Request;

public class RetrieveMemberByDiscordIDRequest implements Request<Member> {

    private final long discordId;

    public RetrieveMemberByDiscordIDRequest(long discordId) {
        this.discordId = discordId;
    }

    @Override
    public String getURL() {
        return BASE_URL + "/members/discords/" + discordId;
    }

    @Override
    public Method getMethod() {
        return Method.GET;
    }

    @Override
    public Member handleJson(String json) {
        JsonElement element = GSON.fromJson(json, JsonElement.class);
        String memberJson = element.getAsJsonObject().get("data").getAsJsonObject().toString();
        Member member = GSON.fromJson(memberJson, Member.class);

        return member;
    }
}
