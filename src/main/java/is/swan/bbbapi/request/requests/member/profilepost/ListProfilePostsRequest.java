package is.swan.bbbapi.request.requests.member.profilepost;

import com.google.gson.JsonElement;
import is.swan.bbbapi.classes.ProfilePost;
import is.swan.bbbapi.request.Request;
import is.swan.bbbapi.request.sorting.SortOptions;
import is.swan.bbbapi.utils.SortUtil;

public class ListProfilePostsRequest implements Request<ProfilePost[]> {

    private final SortOptions sortOptions;

    public ListProfilePostsRequest(SortOptions sortOptions) {
        this.sortOptions = sortOptions;
    }

    @Override
    public String getURL() {
        return BASE_URL + "/members/self/profile-posts" + SortUtil.optionsToString(sortOptions);
    }

    @Override
    public Method getMethod() {
        return Method.GET;
    }

    @Override
    public ProfilePost[] handleJson(String json) {
        JsonElement element = GSON.fromJson(json, JsonElement.class);
        String profilePostsJson = element.getAsJsonObject().get("data").getAsJsonArray().toString();
        ProfilePost[] profilePosts = GSON.fromJson(profilePostsJson, ProfilePost[].class);

        return profilePosts;
    }
}
