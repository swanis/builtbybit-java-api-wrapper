package is.swan.mcmarketapi.classes;

public class License {

    private final int license_id, purchaser_id;
    private final boolean validated, active;
    private final long start_date, end_date, previous_end_date;

    public License(int license_id, int purchaser_id, boolean validated, boolean active, long start_date, long end_date, long previous_end_date) {
        this.license_id = license_id;
        this.purchaser_id = purchaser_id;
        this.validated = validated;
        this.active = active;
        this.start_date = start_date;
        this.end_date = end_date;
        this.previous_end_date = previous_end_date;
    }

    public int getLicenseId() {
        return license_id;
    }

    public int getPurchaserId() {
        return purchaser_id;
    }

    public boolean isValidated() {
        return validated;
    }

    public boolean isActive() {
        return active;
    }

    public long getStartDate() {
        return start_date;
    }

    public long getEndDate() {
        return end_date;
    }

    public long getPreviousEndDate() {
        return previous_end_date;
    }
}
