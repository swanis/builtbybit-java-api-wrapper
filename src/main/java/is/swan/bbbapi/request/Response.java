package is.swan.bbbapi.request;

public class Response<V> {

    private final String json;

    private V value;
    private boolean ratelimited;
    private int millisecondsToWait;
    private Error error;

    public Response(String json) {
        this.json = json;
    }

    public String getJson() {
        return json;
    }

    public V getValue() {
        return value;
    }

    public void setValue(V value) {
        this.value = value;
    }

    public boolean isRatelimited() {
        return ratelimited;
    }

    public void setRatelimited(boolean ratelimited) {
        this.ratelimited = ratelimited;
    }

    public int getMillisecondsToWait() {
        return millisecondsToWait;
    }

    public void setMillisecondsToWait(int millisecondsToWait) {
        this.millisecondsToWait = millisecondsToWait;
    }

    public Error getError() {
        return error;
    }

    public Response<V> setError(Error error) {
        this.error = error;
        return this;
    }
}
