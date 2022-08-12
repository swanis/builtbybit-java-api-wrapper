package is.swan.bbbapi.request.requests.resource.review;

import is.swan.bbbapi.request.Request;

import java.util.HashMap;

public class RespondToResourceReviewRequest implements Request<Void> {

    private final int resourceId, reviewId;
    private final String response;

    public RespondToResourceReviewRequest(int resourceId, int reviewId, String response) {
        this.resourceId = resourceId;
        this.reviewId = reviewId;
        this.response = response;
    }

    @Override
    public String getURL() {
        return BASE_URL + "/resources/" + resourceId + "/reviews/" + reviewId;
    }

    @Override
    public Method getMethod() {
        return Method.PATCH;
    }

    @Override
    public String getBody() {
        HashMap<String, String> parameters = new HashMap<>();

        parameters.put("response", response);

        return GSON.toJson(parameters);
    }
}
