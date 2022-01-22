package is.swan.mcmarketapi.request;

import com.google.gson.Gson;

public interface Request<V> {

    Gson gson = new Gson();

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
