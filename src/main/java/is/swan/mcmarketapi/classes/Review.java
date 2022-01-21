package is.swan.mcmarketapi.classes;

public class Review {

    private final int review_id, resource_id, version_id;
    private final String version_name;
    private final int reviewer_id;
    private final long review_date;
    private final boolean deleted;
    private final int rating;
    private final String message, author_response;

    public Review(int review_id, int resource_id, int version_id, String version_name, int reviewer_id, long review_date, boolean deleted, int rating, String message, String author_response) {
        this.review_id = review_id;
        this.resource_id = resource_id;
        this.version_id = version_id;
        this.version_name = version_name;
        this.reviewer_id = reviewer_id;
        this.review_date = review_date;
        this.deleted = deleted;
        this.rating = rating;
        this.message = message;
        this.author_response = author_response;
    }

    public int getReviewId() {
        return review_id;
    }

    public int getResourceId() {
        return resource_id;
    }

    public int getVersionId() {
        return version_id;
    }

    public String getVersionName() {
        return version_name;
    }

    public int getReviewerDd() {
        return reviewer_id;
    }

    public long getReviewDate() {
        return review_date;
    }

    public boolean isDeleted() {
        return deleted;
    }

    public int getRating() {
        return rating;
    }

    public String getMessage() {
        return message;
    }

    public String getAuthorResponse() {
        return author_response;
    }
}
