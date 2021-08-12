package is.swan.mcmarketapi.classes;

public class ResourceDownload {

    private final int resource_id, version_id, downloader_id;
    private final long download_date;

    public ResourceDownload(int resource_id, int version_id, int downloader_id, long download_date) {
        this.resource_id = resource_id;
        this.version_id = version_id;
        this.downloader_id = downloader_id;
        this.download_date = download_date;
    }

    public int getResourceId() {
        return resource_id;
    }

    public int getVersionId() {
        return version_id;
    }

    public int getDownloaderId() {
        return downloader_id;
    }

    public long getDownloadDate() {
        return download_date;
    }
}
