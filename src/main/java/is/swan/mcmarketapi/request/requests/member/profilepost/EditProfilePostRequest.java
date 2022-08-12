package is.swan.mcmarketapi.request.requests.member.profilepost;

import is.swan.mcmarketapi.request.Request;

import java.util.HashMap;

public class EditProfilePostRequest implements Request<Void> {

    private final int profilePostId;
    private final String message;

    public EditProfilePostRequest(int profilePostId, String message) {
        this.profilePostId = profilePostId;
        this.message = message;
    }

    @Override
    public String getURL() {
        return BASE_URL + "/members/self/profile-posts/" + profilePostId;
    }

    @Override
    public Method getMethod() {
        return Method.PATCH;
    }

    @Override
    public String getBody() {
        HashMap<String, String> parameters = new HashMap<>();

        parameters.put("message", message);

        return GSON.toJson(parameters);
    }
}
