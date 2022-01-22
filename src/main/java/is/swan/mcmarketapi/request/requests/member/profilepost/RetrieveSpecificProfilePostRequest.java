package is.swan.mcmarketapi.request.requests.member.profilepost;

import com.google.gson.JsonElement;
import is.swan.mcmarketapi.classes.ProfilePost;
import is.swan.mcmarketapi.request.Request;

public class RetrieveSpecificProfilePostRequest implements Request<ProfilePost> {

    private final int profilePostId;

    public RetrieveSpecificProfilePostRequest(int profilePostId) {
        this.profilePostId = profilePostId;
    }

    @Override
    public String getURL() {
        return "https://api.mc-market.org/v1/members/self/profile-posts/" + profilePostId;
    }

    @Override
    public Method getMethod() {
        return Method.GET;
    }

    @Override
    public ProfilePost handleJson(String json) {
        JsonElement element = gson.fromJson(json, JsonElement.class);
        String profilePostJson = element.getAsJsonObject().get("data").getAsJsonObject().toString();
        ProfilePost profilePost = gson.fromJson(profilePostJson, ProfilePost.class);

        return profilePost;
    }
}
