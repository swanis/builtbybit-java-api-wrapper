package is.swan.bbbapi.classes;

public class Update {

    private final int update_id;
    private final String title, message;
    private final long update_date;
    private final int like_count;

    public Update(int update_id, String title, String message, long update_date, int like_count) {
        this.update_id = update_id;
        this.title = title;
        this.message = message;
        this.update_date = update_date;
        this.like_count = like_count;
    }

    public int getUpdateId() {
        return update_id;
    }

    public String getTitle() {
        return title;
    }

    public String getMessage() {
        return message;
    }

    public long getUpdateDate() {
        return update_date;
    }

    public int getLikeCount() {
        return like_count;
    }
}
