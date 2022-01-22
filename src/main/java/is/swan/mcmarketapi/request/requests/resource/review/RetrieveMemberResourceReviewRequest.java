package is.swan.mcmarketapi.request.requests.resource.review;

import com.google.gson.JsonElement;
import is.swan.mcmarketapi.classes.Review;
import is.swan.mcmarketapi.request.Request;

public class RetrieveMemberResourceReviewRequest implements Request<Review> {

    private final int resourceId, memberId;

    public RetrieveMemberResourceReviewRequest(int resourceId, int memberId) {
        this.resourceId = resourceId;
        this.memberId = memberId;
    }

    @Override
    public String getURL() {
        return "https://api.mc-market.org/v1/resources/" + resourceId + "/reviews/members/" + memberId;
    }

    @Override
    public Method getMethod() {
        return Method.GET;
    }

    @Override
    public Review handleJson(String json) {
        JsonElement element = gson.fromJson(json, JsonElement.class);
        String resourceReviewJson = element.getAsJsonObject().get("data").getAsJsonObject().toString();
        Review resourceReview = gson.fromJson(resourceReviewJson, Review.class);

        return resourceReview;
    }
}
