package is.swan.mcmarketapi.classes;

public class Version {

    private final int version_id, update_id;
    private final String name;
    private final long release_date;
    private final int download_count;

    public Version(int version_id, int update_id, String name, long release_date, int download_count) {
        this.version_id = version_id;
        this.update_id = update_id;
        this.name = name;
        this.release_date = release_date;
        this.download_count = download_count;
    }

    public int getVersionId() {
        return version_id;
    }

    public int getUpdateId() {
        return update_id;
    }

    public String getName() {
        return name;
    }

    public long getReleaseDate() {
        return release_date;
    }

    public int getDownloadCount() {
        return download_count;
    }
}
