package is.swan.mcmarketapi.request.sorting;

public class SortOptions {

    private final String sortableField;
    private final Order order;
    private final int page;

    public SortOptions(String sortableField, Order order, int page) {
        this.sortableField = sortableField;
        this.order = order;
        this.page = page;
    }

    public String getSortableField() {
        return sortableField;
    }

    public Order getOrder() {
        return order;
    }

    public int getPage() {
        return page;
    }
}
