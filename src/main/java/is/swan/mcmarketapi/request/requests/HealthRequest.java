package is.swan.mcmarketapi.request.requests;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import is.swan.mcmarketapi.request.Request;

public class HealthRequest implements Request<String> {

    @Override
    public String getURL() {
        return BASE_URL + "/health";
    }

    @Override
    public Method getMethod() {
        return Method.GET;
    }

    @Override
    public String handleJson(String json) {
        JsonElement element = GSON.fromJson(json, JsonElement.class);
        JsonObject jsonObject = element.getAsJsonObject();

        return jsonObject.get("data").getAsString();
    }
}
