package is.swan.bbbapi.classes;

public class ProfilePost {

    private final int profile_post_id, author_id;
    private final long post_date;
    private final String message;

    public ProfilePost(int profile_post_id, int author_id, long post_date, String message) {
        this.profile_post_id = profile_post_id;
        this.author_id = author_id;
        this.post_date = post_date;
        this.message = message;
    }

    public int getProfilePostId() {
        return profile_post_id;
    }

    public int getAuthorId() {
        return author_id;
    }

    public long getPostDate() {
        return post_date;
    }

    public String getMessage() {
        return message;
    }
}
