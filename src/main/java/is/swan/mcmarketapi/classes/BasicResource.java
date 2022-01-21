package is.swan.mcmarketapi.classes;

public class BasicResource {

    private final int resource_id, author_id;
    private final String title, tag_line;
    private final double price;
    private final String currency;

    public BasicResource(int resource_id, int author_id, String title, String tag_line, double price, String currency) {
        this.resource_id = resource_id;
        this.author_id = author_id;
        this.title = title;
        this.tag_line = tag_line;
        this.price = price;
        this.currency = currency;
    }

    public int getResourceId() {
        return resource_id;
    }

    public int getAuthorId() {
        return author_id;
    }

    public String getTitle() {
        return title;
    }

    public String getTagLine() {
        return tag_line;
    }

    public double getPrice() {
        return price;
    }

    public String getCurrency() {
        return currency;
    }
}
