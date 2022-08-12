package is.swan.bbbapi.classes;

public class Thread {

    private final int thread_id;
    private final String forum_name, title;
    private final int reply_count, view_count;
    private final long post_date;
    private final boolean thread_open;
    private final long last_post_date;

    public Thread(int thread_id, String forum_name, String title, int reply_count, int view_count, long post_date, boolean thread_open, long last_post_date) {
        this.thread_id = thread_id;
        this.forum_name = forum_name;
        this.title = title;
        this.reply_count = reply_count;
        this.view_count = view_count;
        this.post_date = post_date;
        this.thread_open = thread_open;
        this.last_post_date = last_post_date;
    }

    public int getThreadId() {
        return thread_id;
    }

    public String getForumName() {
        return forum_name;
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

    public long getPostDate() {
        return post_date;
    }

    public boolean isThreadOpen() {
        return thread_open;
    }

    public long getLastPostDate() {
        return last_post_date;
    }
}
