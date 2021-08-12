package is.swan.mcmarketapi.classes;

public class ResourcePurchase {

    private final int purchase_id, purchaser_id, license_id;
    private final boolean renewal;
    private final String status;
    private final double price;
    private final String currency;
    private final long purchase_date, validation_date;

    public ResourcePurchase(int purchase_id, int purchaser_id, int license_id, boolean renewal, String status, double price, String currency, long purchase_date, long validation_date) {
        this.purchase_id = purchase_id;
        this.purchaser_id = purchaser_id;
        this.license_id = license_id;
        this.renewal = renewal;
        this.status = status;
        this.price = price;
        this.currency = currency;
        this.purchase_date = purchase_date;
        this.validation_date = validation_date;
    }

    public int getPurchaseId() {
        return purchase_id;
    }

    public int getPurchaserId() {
        return purchaser_id;
    }

    public int getLicenseId() {
        return license_id;
    }

    public boolean isRenewal() {
        return renewal;
    }

    public String getStatus() {
        return status;
    }

    public String getCurrency() {
        return currency;
    }

    public long getPurchaseDate() {
        return purchase_date;
    }

    public long getValidationDate() {
        return validation_date;
    }
}
