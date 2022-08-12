package is.swan.bbbapi.classes;

public class Resource {

    private final int resource_id, author_id;
    private final String title, tag_line, description;
    private final long release_date, last_update_date;
    private final boolean moderated;
    private final String category_title;
    private final int current_version_id, discussion_thread_id;
    private final double price;
    private final String currency;
    private final int download_count, review_count;
    private final double review_average;

    public Resource(int resource_id, int author_id, String title, String tag_line, String description, long release_date, long last_update_date, boolean moderated, String category_title, int current_version_id, int discussion_thread_id, double price, String currency, int download_count, int review_count, double review_average) {
        this.resource_id = resource_id;
        this.author_id = author_id;
        this.title = title;
        this.tag_line = tag_line;
        this.description = description;
        this.release_date = release_date;
        this.last_update_date = last_update_date;
        this.moderated = moderated;
        this.category_title = category_title;
        this.current_version_id = current_version_id;
        this.discussion_thread_id = discussion_thread_id;
        this.price = price;
        this.currency = currency;
        this.download_count = download_count;
        this.review_count = review_count;
        this.review_average = review_average;
    }

    public int getResourceId() {
        return resource_id;
    }

    public int getAuthorId() {
        return author_id;
    }

    public String getTitle() {
        return title;
    }

    public String getTagLine() {
        return tag_line;
    }

    public String getDescription() {
        return description;
    }

    public long getReleaseDate() {
        return release_date;
    }

    public long getLastUpdateDate() {
        return last_update_date;
    }

    public boolean isModerated() {
        return moderated;
    }

    public String getCategoryTitle() {
        return category_title;
    }

    public int getCurrentVersionId() {
        return current_version_id;
    }

    public int getDiscussionThreadId() {
        return discussion_thread_id;
    }

    public double getPrice() {
        return price;
    }

    public String getCurrency() {
        return currency;
    }

    public int getDownloadCount() {
        return download_count;
    }

    public int getReviewCount() {
        return review_count;
    }

    public double getReviewAverage() {
        return review_average;
    }
}
