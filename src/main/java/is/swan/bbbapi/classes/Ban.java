package is.swan.bbbapi.classes;

public class Ban {

    private final int member_id, banned_by_id;
    private final long ban_date;
    private final String reason;

    public Ban(int member_id, int banned_by_id, long ban_date, String reason) {
        this.member_id = member_id;
        this.banned_by_id = banned_by_id;
        this.ban_date = ban_date;
        this.reason = reason;
    }

    public int getMemberId() {
        return member_id;
    }

    public int getBannedById() {
        return banned_by_id;
    }

    public long getBanDate() {
        return ban_date;
    }

    public String getReason() {
        return reason;
    }
}
