package is.swan.bbbapi.request.requests.member.profilepost;

import is.swan.bbbapi.request.Request;

public class DeleteProfilePostRequest implements Request<Void> {

    private final int profilePostId;

    public DeleteProfilePostRequest(int profilePostId) {
        this.profilePostId = profilePostId;
    }

    @Override
    public String getURL() {
        return BASE_URL + "/members/self/profile-posts/" + profilePostId;
    }

    @Override
    public Method getMethod() {
        return Method.DELETE;
    }
}
