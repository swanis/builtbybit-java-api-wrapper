package is.swan.mcmarketapi.classes;

public class BasicThread {

    private final int thread_id;
    private final String title;
    private final int reply_count, view_count;
    private final long creation_date, last_message_date;

    public BasicThread(int thread_id, String title, int reply_count, int view_count, long creation_date, long last_message_date) {
        this.thread_id = thread_id;
        this.title = title;
        this.reply_count = reply_count;
        this.view_count = view_count;
        this.creation_date = creation_date;
        this.last_message_date = last_message_date;
    }

    public int getThreadId() {
        return thread_id;
    }

    public String getTitle() {
        return title;
    }

    public int getReplyCount() {
        return reply_count;
    }

    public int getViewCount() {
        return view_count;
    }

    public long getCreationDate() {
        return creation_date;
    }

    public long getLastMessageDate() {
        return last_message_date;
    }
}
