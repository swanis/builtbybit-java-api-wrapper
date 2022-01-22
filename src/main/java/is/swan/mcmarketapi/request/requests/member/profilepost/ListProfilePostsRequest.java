package is.swan.mcmarketapi.request.requests.member.profilepost;

import com.google.gson.JsonElement;
import is.swan.mcmarketapi.classes.ProfilePost;
import is.swan.mcmarketapi.request.Request;
import is.swan.mcmarketapi.request.sorting.SortOptions;
import is.swan.mcmarketapi.utils.SortUtil;

public class ListProfilePostsRequest implements Request<ProfilePost[]> {

    private final SortOptions sortOptions;

    public ListProfilePostsRequest(SortOptions sortOptions) {
        this.sortOptions = sortOptions;
    }

    @Override
    public String getURL() {
        return "https://api.mc-market.org/v1/members/self/profile-posts" + SortUtil.optionsToString(sortOptions);
    }

    @Override
    public Method getMethod() {
        return Method.GET;
    }

    @Override
    public ProfilePost[] handleJson(String json) {
        JsonElement element = gson.fromJson(json, JsonElement.class);
        String profilePostsJson = element.getAsJsonObject().get("data").getAsJsonArray().toString();
        ProfilePost[] profilePosts = gson.fromJson(profilePostsJson, ProfilePost[].class);

        return profilePosts;
    }
}
