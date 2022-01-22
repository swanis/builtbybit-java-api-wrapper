package is.swan.mcmarketapi.request.requests.member;

import com.google.gson.JsonElement;
import is.swan.mcmarketapi.classes.Member;
import is.swan.mcmarketapi.request.Request;

public class RetrieveMemberByIDRequest implements Request<Member> {

    private final int memberId;

    public RetrieveMemberByIDRequest(int memberId) {
        this.memberId = memberId;
    }

    @Override
    public String getURL() {
        return "https://api.mc-market.org/v1/members/" + memberId;
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
