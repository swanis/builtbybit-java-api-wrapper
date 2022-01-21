package is.swan.mcmarketapi.classes;

public class Reply {

    private final int reply_id, author_id;
    private final long post_date;
    private final String message;

    public Reply(int reply_id, int author_id, long post_date, String message) {
        this.reply_id = reply_id;
        this.author_id = author_id;
        this.post_date = post_date;
        this.message = message;
    }

    public int getReplyId() {
        return reply_id;
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
