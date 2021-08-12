package is.swan.mcmarketapi.request.requests.resource.download;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import is.swan.mcmarketapi.classes.ResourceDownload;
import is.swan.mcmarketapi.request.Request;
import is.swan.mcmarketapi.request.sorting.SortOptions;
import is.swan.mcmarketapi.utils.SortUtil;

public class ListResourceDownloadsByMemberRequest implements Request<ResourceDownload[]> {

    private final int resourceId, memberId;
    private final SortOptions sortOptions;

    public ListResourceDownloadsByMemberRequest(int resourceId, int memberId, SortOptions sortOptions) {
        this.resourceId = resourceId;
        this.memberId = memberId;
        this.sortOptions = sortOptions;
    }

    @Override
    public String getURL() {
        return "https://api.mc-market.org/v1/resources/" + resourceId + "/downloads/members/" + memberId + SortUtil.optionsToString(sortOptions);
    }

    @Override
    public Method getMethod() {
        return Method.GET;
    }

    @Override
    public ResourceDownload[] handleJson(String json) {
        Gson gson = new Gson();
        JsonElement element = gson.fromJson(json, JsonElement.class);
        String resourceDownloadsJson = element.getAsJsonObject().get("data").getAsJsonArray().toString();
        ResourceDownload[] resourceDownloads = gson.fromJson(resourceDownloadsJson, ResourceDownload[].class);

        return resourceDownloads;
    }
}
