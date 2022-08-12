package is.swan.bbbapi.request.requests.resource.download;

import com.google.gson.JsonElement;
import is.swan.bbbapi.classes.Download;
import is.swan.bbbapi.request.Request;
import is.swan.bbbapi.request.sorting.SortOptions;
import is.swan.bbbapi.utils.SortUtil;

public class ListResourceDownloadsByMemberRequest implements Request<Download[]> {

    private final int resourceId, memberId;
    private final SortOptions sortOptions;

    public ListResourceDownloadsByMemberRequest(int resourceId, int memberId, SortOptions sortOptions) {
        this.resourceId = resourceId;
        this.memberId = memberId;
        this.sortOptions = sortOptions;
    }

    @Override
    public String getURL() {
        return BASE_URL + "/resources/" + resourceId + "/downloads/members/" + memberId + SortUtil.optionsToString(sortOptions);
    }

    @Override
    public Method getMethod() {
        return Method.GET;
    }

    @Override
    public Download[] handleJson(String json) {
        JsonElement element = GSON.fromJson(json, JsonElement.class);
        String resourceDownloadsJson = element.getAsJsonObject().get("data").getAsJsonArray().toString();
        Download[] resourceDownloads = GSON.fromJson(resourceDownloadsJson, Download[].class);

        return resourceDownloads;
    }
}
