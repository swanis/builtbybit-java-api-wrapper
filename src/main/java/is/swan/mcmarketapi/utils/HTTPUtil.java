package is.swan.mcmarketapi.utils;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import is.swan.mcmarketapi.request.Error;
import is.swan.mcmarketapi.request.Response;
import is.swan.mcmarketapi.Token;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class HTTPUtil {

    private static final HttpClient CLIENT = HttpClient.newHttpClient();
    private static final Gson GSON = new Gson();

    public static Response<String> get(String url, Token token) {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .header("Authorization", token.toString())
                .build();

        try {
            HttpResponse<String> httpResponse = CLIENT.send(request, HttpResponse.BodyHandlers.ofString());

            return getResponse(httpResponse);
        } catch (IOException | InterruptedException e) {
            return new Response<>("").setError(new Error(e.getClass().getName(), e.getMessage()));
        }
    }

    public static Response<String> post(String url, String body, Token token) {
        HttpRequest request = HttpRequest.newBuilder()
                .POST(HttpRequest.BodyPublishers.ofString(body))
                .uri(URI.create(url))
                .header("Authorization", token.toString())
                .header("Content-Type", "application/json")
                .build();

        try {
            HttpResponse<String> httpResponse = CLIENT.send(request, HttpResponse.BodyHandlers.ofString());

            return getResponse(httpResponse);
        } catch (IOException | InterruptedException e) {
            return new Response<>("").setError(new Error(e.getClass().getName(), e.getMessage()));
        }
    }

    public static Response<String> delete(String url, Token token) {
        HttpRequest request = HttpRequest.newBuilder()
                .DELETE()
                .uri(URI.create(url))
                .header("Authorization", token.toString())
                .build();

        try {
            HttpResponse<String> httpResponse = CLIENT.send(request, HttpResponse.BodyHandlers.ofString());

            return getResponse(httpResponse);
        } catch (IOException | InterruptedException e) {
            return new Response<>("").setError(new Error(e.getClass().getName(), e.getMessage()));
        }
    }

    public static Response<String> patch(String url, String body, Token token) {
        HttpRequest request = HttpRequest.newBuilder()
                .method("PATCH", HttpRequest.BodyPublishers.ofString(body))
                .uri(URI.create(url))
                .header("Authorization", token.toString())
                .header("Content-Type", "application/json")
                .build();

        try {
            HttpResponse<String> httpResponse = CLIENT.send(request, HttpResponse.BodyHandlers.ofString());

            return getResponse(httpResponse);
        } catch (IOException | InterruptedException e) {
            return new Response<>("").setError(new Error(e.getClass().getName(), e.getMessage()));
        }
    }

    private static Response<String> getResponse(HttpResponse<String> httpResponse) {
        Response<String> response = new Response<>(httpResponse.body());

        if (httpResponse.headers().firstValue("Retry-After").isPresent()) {
            response.setRatelimited(true);
            response.setMillisecondsToWait(Integer.parseInt(httpResponse.headers().firstValue("Retry-After").get()));
        } else {
            JsonElement element = GSON.fromJson(httpResponse.body(), JsonElement.class);
            String result = element.getAsJsonObject().get("result").getAsString();

            if (result.equals("error")) {
                String errorJson = element.getAsJsonObject().get("error").getAsJsonObject().toString();
                Error error = GSON.fromJson(errorJson, Error.class);

                response.setError(error);
            }
        }

        return response;
    }
}