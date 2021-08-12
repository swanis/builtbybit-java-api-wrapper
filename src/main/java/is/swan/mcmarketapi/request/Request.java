package is.swan.mcmarketapi.request;

public interface Request<V> {

    String getURL();
    Method getMethod();

    default V handleJson(String json) {
        return null;
    }

    default String getBody() {
        return null;
    }

    enum Method {
        GET,
        POST,
        DELETE,
        PATCH
    }
}
