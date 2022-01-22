package is.swan.mcmarketapi.request.requests.member;

import com.google.gson.JsonElement;
import is.swan.mcmarketapi.classes.Member;
import is.swan.mcmarketapi.request.Request;

public class RetrieveMemberByUsernameRequest implements Request<Member> {

    private final String username;

    public RetrieveMemberByUsernameRequest(String username) {
        this.username = username;
    }

    @Override
    public String getURL() {
        return "https://api.mc-market.org/v1/members/usernames/" + username;
    }

    @Override
    public Method getMethod() {
        return Method.GET;
    }

    @Override
    public Member handleJson(String json) {
        JsonElement element = gson.fromJson(json, JsonElement.class);
        String memberJson = element.getAsJsonObject().get("data").getAsJsonObject().toString();
        Member member = gson.fromJson(memberJson, Member.class);

        return member;
    }
}
