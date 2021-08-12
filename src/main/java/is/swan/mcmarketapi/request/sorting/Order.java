package is.swan.mcmarketapi.request.sorting;

public enum Order {

    ASCENDING("asc"),
    DESCENDING("desc");

    private final String displayName;

    Order(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }
}
