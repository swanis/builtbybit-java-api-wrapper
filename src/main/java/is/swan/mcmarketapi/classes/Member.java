package is.swan.mcmarketapi.classes;

public class Member {

    private final int member_id;
    private final String username;
    private final long join_date, last_activity_date;
    private final boolean banned, suspended, restricted, disabled, premium, supreme, ultimate;
    private final long discord_id;
    private final int post_count, resource_count, purchase_count, feedback_positive, feedback_neutral, feedback_negative;

    public Member(int member_id, String username, long join_date, long last_activity_date, boolean banned, boolean suspended, boolean restricted, boolean disabled, boolean premium, boolean supreme, boolean ultimate, long discord_id, int post_count, int resource_count, int purchase_count, int feedback_positive, int feedback_neutral, int feedback_negative) {
        this.member_id = member_id;
        this.username = username;
        this.join_date = join_date;
        this.last_activity_date = last_activity_date;
        this.banned = banned;
        this.suspended = suspended;
        this.restricted = restricted;
        this.disabled = disabled;
        this.premium = premium;
        this.supreme = supreme;
        this.ultimate = ultimate;
        this.discord_id = discord_id;
        this.post_count = post_count;
        this.resource_count = resource_count;
        this.purchase_count = purchase_count;
        this.feedback_positive = feedback_positive;
        this.feedback_neutral = feedback_neutral;
        this.feedback_negative = feedback_negative;
    }

    public int getMemberId() {
        return member_id;
    }

    public String getUsername() {
        return username;
    }

    public long getJoinDate() {
        return join_date;
    }

    public long getLastActivityDate() {
        return last_activity_date;
    }

    public boolean isBanned() {
        return banned;
    }

    public boolean isSuspended() {
        return suspended;
    }

    public boolean isRestricted() {
        return restricted;
    }

    public boolean isDisabled() {
        return disabled;
    }

    public boolean isPremium() {
        return premium;
    }

    public boolean isSupreme() {
        return supreme;
    }

    public boolean isUltimate() {
        return ultimate;
    }

    public long getDiscordId() {
        return discord_id;
    }

    public int getPostCount() {
        return post_count;
    }

    public int getResourceCount() {
        return resource_count;
    }

    public int getPurchaseCount() {
        return purchase_count;
    }

    public int getFeedbackPositive() {
        return feedback_positive;
    }

    public int getFeedbackNeutral() {
        return feedback_neutral;
    }

    public int getFeedbackNegative() {
        return feedback_negative;
    }
}
