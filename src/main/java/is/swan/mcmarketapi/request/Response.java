package is.swan.mcmarketapi.request;

public class Response<V> {

    private V value;
    private boolean ratelimited;
    private int millisecondsToWait;
    private Error error;

    public Response(V value) {
        this.value = value;
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

    public Response setError(Error error) {
        this.error = error;
        return this;
    }
}
