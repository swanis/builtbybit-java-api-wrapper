package is.swan.bbbapi.request.requests.member.profilepost;

import com.google.gson.JsonElement;
import is.swan.bbbapi.classes.ProfilePost;
import is.swan.bbbapi.request.Request;

public class RetrieveSpecificProfilePostRequest implements Request<ProfilePost> {

    private final int profilePostId;

    public RetrieveSpecificProfilePostRequest(int profilePostId) {
        this.profilePostId = profilePostId;
    }

    @Override
    public String getURL() {
        return BASE_URL + "/members/self/profile-posts/" + profilePostId;
    }

    @Override
    public Method getMethod() {
        return Method.GET;
    }

    @Override
    public ProfilePost handleJson(String json) {
        JsonElement element = GSON.fromJson(json, JsonElement.class);
        String profilePostJson = element.getAsJsonObject().get("data").getAsJsonObject().toString();
        ProfilePost profilePost = GSON.fromJson(profilePostJson, ProfilePost.class);

        return profilePost;
    }
}
