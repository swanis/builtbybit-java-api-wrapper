package is.swan.mcmarketapi.request.requests;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import is.swan.mcmarketapi.request.Request;

public class HealthRequest implements Request<String> {

    @Override
    public String getURL() {
        return "https://api.mc-market.org/v1/health";
    }

    @Override
    public Method getMethod() {
        return Method.GET;
    }

    @Override
    public String handleJson(String json) {
        Gson gson = new Gson();
        JsonElement element = gson.fromJson(json, JsonElement.class);
        JsonObject jsonObject = element.getAsJsonObject();

        return jsonObject.get("data").getAsString();
    }
}
