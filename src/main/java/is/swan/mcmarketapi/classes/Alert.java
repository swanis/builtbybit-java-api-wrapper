package is.swan.mcmarketapi.classes;

public class Alert {

    private final int caused_member_id;
    private final String content_type;
    private final int content_id;
    private final String alert_type;
    private final long alert_date;

    public Alert(int caused_member_id, String content_type, int content_id, String alert_type, long alert_date) {
        this.caused_member_id = caused_member_id;
        this.content_type = content_type;
        this.content_id = content_id;
        this.alert_type = alert_type;
        this.alert_date = alert_date;
    }

    public int getCausedMemberId() {
        return caused_member_id;
    }

    public String getContentType() {
        return content_type;
    }

    public int getContentId() {
        return content_id;
    }

    public String getAlertType() {
        return alert_type;
    }

    public long getAlertDate() {
        return alert_date;
    }
}
