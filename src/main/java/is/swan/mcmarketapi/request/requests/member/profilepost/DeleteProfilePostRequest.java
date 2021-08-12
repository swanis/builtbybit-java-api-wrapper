package is.swan.mcmarketapi.request.requests.member.profilepost;

import is.swan.mcmarketapi.request.Request;

public class DeleteProfilePostRequest implements Request<Void> {

    private final int profilePostId;

    public DeleteProfilePostRequest(int profilePostId) {
        this.profilePostId = profilePostId;
    }

    @Override
    public String getURL() {
        return "https://api.mc-market.org/v1/members/self/profile-posts/" + profilePostId;
    }

    @Override
    public Method getMethod() {
        return Method.DELETE;
    }
}
