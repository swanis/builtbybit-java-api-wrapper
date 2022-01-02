package is.swan.mcmarketapi.classes;

public class ConversationReply {

    private final int message_id;
    private final long message_date;
    private final int author_id;
    private final String message;

    public ConversationReply(int message_id, long message_date, int author_id, String message) {
        this.message_id = message_id;
        this.message_date = message_date;
        this.author_id = author_id;
        this.message = message;
    }

    public int getMessageId() {
        return message_id;
    }

    public long getMessageDate() {
        return message_date;
    }

    public int getAuthorId() {
        return author_id;
    }

    public String getMessage() {
        return message;
    }
}
