package is.swan.bbbapi.request.requests.resource.review;

import com.google.gson.JsonElement;
import is.swan.bbbapi.classes.Review;
import is.swan.bbbapi.request.Request;
import is.swan.bbbapi.request.sorting.SortOptions;
import is.swan.bbbapi.utils.SortUtil;

public class ListResourceReviewsRequest implements Request<Review[]> {

    private final int resourceId;
    private final SortOptions sortOptions;

    public ListResourceReviewsRequest(int resourceId, SortOptions sortOptions) {
        this.resourceId = resourceId;
        this.sortOptions = sortOptions;
    }

    @Override
    public String getURL() {
        return BASE_URL + "/resources/" + resourceId + "/reviews" + SortUtil.optionsToString(sortOptions);
    }

    @Override
    public Method getMethod() {
        return Method.GET;
    }

    @Override
    public Review[] handleJson(String json) {
        JsonElement element = GSON.fromJson(json, JsonElement.class);
        String resourceReviewsJson = element.getAsJsonObject().get("data").getAsJsonArray().toString();
        Review[] resourceReviews = GSON.fromJson(resourceReviewsJson, Review[].class);

        return resourceReviews;
    }
}
