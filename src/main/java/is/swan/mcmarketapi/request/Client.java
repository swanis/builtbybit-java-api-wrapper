package is.swan.mcmarketapi.request;

import is.swan.mcmarketapi.Token;
import is.swan.mcmarketapi.request.Request.Method;
import is.swan.mcmarketapi.utils.HTTPUtil;

public class Client {

    private final Token token;
    private final Throttler throttler;

    public Client(Token token) {
        this.token = token;
        this.throttler = new Throttler();
    }

    public <V> Response<V> send(Request<V> request) {
        Response<V> response = getResponse(request);

        if (response.isRatelimited() || response.getError() != null) {
            return response;
        }

        response.setValue(request.handleJson(response.getJson()));

        return response;
    }

    public <V> Response<V> sendOrWait(Request<V> request) {
        long stallFor;
        while ((stallFor = this.throttler.stallFor(request.getMethod())) > 0) {
            try {
                Thread.sleep(stallFor);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        Response<V> response = getResponse(request);

        if (response.isRatelimited()) {
            if (request.getMethod() == Method.GET) {
                throttler.setRead(response.getMillisecondsToWait());
            } else {
                throttler.setWrite(response.getMillisecondsToWait());
            }

            return sendOrWait(request);
        }

        if (request.getMethod() == Method.GET) {
            throttler.resetRead();
        } else {
            throttler.resetWrite();
        }

        if (response.getError() != null) {
            return response;
        }

        response.setValue(request.handleJson(response.getJson()));

        return response;
    }

    private <V> Response<V> getResponse(Request<V> request) {
        return switch (request.getMethod()) {
            case GET -> HTTPUtil.get(request.getURL(), token);
            case POST -> HTTPUtil.post(request.getURL(), request.getBody(), token);
            case DELETE -> HTTPUtil.delete(request.getURL(), token);
            case PATCH -> HTTPUtil.patch(request.getURL(), request.getBody(), token);
        };
    }
}
