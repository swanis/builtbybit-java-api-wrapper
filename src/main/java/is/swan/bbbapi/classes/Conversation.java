package is.swan.bbbapi.classes;

public class Conversation {

    private final int conversation_id;
    private final String title;
    private final long creation_date;
    private final int creator_id;
    private final long last_message_id, last_read_date;
    private final boolean open;
    private final int reply_count;
    private final int[] recipient_ids;

    public Conversation(int conversation_id, String title, long creation_date, int creator_id, long last_message_id, long last_read_date, boolean open, int reply_count, int[] recipient_ids) {
        this.conversation_id = conversation_id;
        this.title = title;
        this.creation_date = creation_date;
        this.creator_id = creator_id;
        this.last_message_id = last_message_id;
        this.last_read_date = last_read_date;
        this.open = open;
        this.reply_count = reply_count;
        this.recipient_ids = recipient_ids;
    }

    public int getConversationId() {
        return conversation_id;
    }

    public String getTitle() {
        return title;
    }

    public long getCreationDate() {
        return creation_date;
    }

    public int getCreatorId() {
        return creator_id;
    }

    public long getLastMessageId() {
        return last_message_id;
    }

    public long getLastReadDate() {
        return last_read_date;
    }

    public boolean isOpen() {
        return open;
    }

    public int getReplyCount() {
        return reply_count;
    }

    public int[] getRecipientIds() {
        return recipient_ids;
    }
}
