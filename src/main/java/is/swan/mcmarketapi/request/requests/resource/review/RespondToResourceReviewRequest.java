package is.swan.mcmarketapi.request.requests.resource.review;

import com.google.gson.Gson;
import is.swan.mcmarketapi.request.Request;

import java.util.HashMap;

public class RespondToResourceReviewRequest implements Request<Void> {

    private final int resourceId, reviewId;
    private final String message;

    public RespondToResourceReviewRequest(int resourceId, int reviewId, String message) {
        this.resourceId = resourceId;
        this.reviewId = reviewId;
        this.message = message;
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
        Gson gson = new Gson();
        HashMap<String, String> parameters = new HashMap<>();

        parameters.put("message", message);

        return gson.toJson(parameters);
    }
}
