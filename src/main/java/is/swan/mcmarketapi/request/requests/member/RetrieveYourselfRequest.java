package is.swan.mcmarketapi.request.requests.member;

import com.google.gson.JsonElement;
import is.swan.mcmarketapi.classes.Member;
import is.swan.mcmarketapi.request.Request;

public class RetrieveYourselfRequest implements Request<Member> {

    @Override
    public String getURL() {
        return BASE_URL + "/members/self";
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
