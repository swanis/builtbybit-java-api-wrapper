package is.swan.mcmarketapi.request.requests.resource.review;

import com.google.gson.JsonElement;
import is.swan.mcmarketapi.classes.Review;
import is.swan.mcmarketapi.request.Request;
import is.swan.mcmarketapi.request.sorting.SortOptions;
import is.swan.mcmarketapi.utils.SortUtil;

public class ListResourceReviewsRequest implements Request<Review[]> {

    private final int resourceId;
    private final SortOptions sortOptions;

    public ListResourceReviewsRequest(int resourceId, SortOptions sortOptions) {
        this.resourceId = resourceId;
        this.sortOptions = sortOptions;
    }

    @Override
    public String getURL() {
        return "https://api.mc-market.org/v1/resources/" + resourceId + "/reviews" + SortUtil.optionsToString(sortOptions);
    }

    @Override
    public Method getMethod() {
        return Method.GET;
    }

    @Override
    public Review[] handleJson(String json) {
        JsonElement element = gson.fromJson(json, JsonElement.class);
        String resourceReviewsJson = element.getAsJsonObject().get("data").getAsJsonArray().toString();
        Review[] resourceReviews = gson.fromJson(resourceReviewsJson, Review[].class);

        return resourceReviews;
    }
}
