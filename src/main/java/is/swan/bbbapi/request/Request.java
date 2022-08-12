package is.swan.bbbapi.request;

import com.google.gson.Gson;

public interface Request<V> {

    String BASE_URL = "https://api.builtbybit.com/v1";
    Gson GSON = new Gson();

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
