package is.swan.mcmarketapi.request;

import is.swan.mcmarketapi.Token;
import is.swan.mcmarketapi.utils.HTTPUtil;

public class Client {

    private final Token token;

    public Client(Token token) {
        this.token = token;
    }

    public Response send(Request request) {
        Response response = getResponse(request);

        if (response.isRatelimited() || response.getError() != null) {
            return response;
        }

        response.setValue(request.handleJson((String) response.getValue()));

        return response;
    }

    public Response sendOrWait(Request request) {
        Response response = getResponse(request);

        while (response.isRatelimited()) {
            try {
                Thread.sleep(response.getMillisecondsToWait());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            response = getResponse(request);
        }

        if (response.getError() != null) {
            return response;
        }

        response.setValue(request.handleJson((String) response.getValue()));

        return response;
    }

    private Response getResponse(Request request) {
        Response response = null;

        if (request.getMethod() == Request.Method.GET) {
            response = HTTPUtil.get(request.getURL(), token);
        } else if (request.getMethod() == Request.Method.POST) {
            response = HTTPUtil.post(request.getURL(), request.getBody(), token);
        } else if (request.getMethod() == Request.Method.DELETE) {
            response = HTTPUtil.delete(request.getURL(), token);
        } else if (request.getMethod() == Request.Method.PATCH) {
            response = HTTPUtil.patch(request.getURL(), request.getBody(), token);
        }

        return response;
    }
}
