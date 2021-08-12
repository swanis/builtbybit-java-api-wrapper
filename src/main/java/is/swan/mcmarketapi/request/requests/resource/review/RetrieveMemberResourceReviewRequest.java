package is.swan.mcmarketapi.request.requests.resource.review;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import is.swan.mcmarketapi.classes.ResourceReview;
import is.swan.mcmarketapi.request.Request;

public class RetrieveMemberResourceReviewRequest implements Request<ResourceReview> {

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
    public ResourceReview handleJson(String json) {
        Gson gson = new Gson();
        JsonElement element = gson.fromJson(json, JsonElement.class);
        String resourceReviewJson = element.getAsJsonObject().get("data").getAsJsonObject().toString();
        ResourceReview resourceReview = gson.fromJson(resourceReviewJson, ResourceReview.class);

        return resourceReview;
    }
}
