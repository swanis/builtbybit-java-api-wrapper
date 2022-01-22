package is.swan.mcmarketapi.request.requests.resource.review;

import is.swan.mcmarketapi.request.Request;

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
        return "https://api.mc-market.org/v1/resources/" + resourceId + "/reviews/" + reviewId;
    }

    @Override
    public Method getMethod() {
        return Method.PATCH;
    }

    @Override
    public String getBody() {
        HashMap<String, String> parameters = new HashMap<>();

        parameters.put("response", response);

        return gson.toJson(parameters);
    }
}
