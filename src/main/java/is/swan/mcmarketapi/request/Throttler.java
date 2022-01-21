package is.swan.mcmarketapi.request;

import java.util.concurrent.atomic.AtomicLong;

import is.swan.mcmarketapi.request.Request.Method;

public class Throttler {

	private final AtomicLong readLastRetry = new AtomicLong(0);
	private final AtomicLong readLastRequest = new AtomicLong(System.currentTimeMillis());
	
	private final AtomicLong writeLastRetry = new AtomicLong(0);
	private final AtomicLong writeLastRequest = new AtomicLong(System.currentTimeMillis());
	
	public long stallFor(Method method) {
	    long time = System.currentTimeMillis();
	    
	    if (method == Method.GET) {
    		return Throttler.stallForHelper(this.readLastRetry, this.readLastRequest, time);
	    } else {
    		return Throttler.stallForHelper(this.writeLastRetry, this.writeLastRequest, time);
	    }
	}
	
	private static long stallForHelper(AtomicLong aLastRetry, AtomicLong aLastRequest, long time){
	    long lastRetry = aLastRetry.getAcquire();
	    long lastRequest = aLastRequest.getAcquire();
	    
	    if (lastRetry > 0 && (time - lastRequest) < lastRetry) {
	        return lastRetry - (time - lastRequest);
	    } else {
	    	return 0;
	    }
	}
	
	public void setRead(long value) {
		readLastRetry.setRelease(value);
		readLastRequest.setRelease(System.currentTimeMillis());
	}
	
	public void setWrite(long value) {
		writeLastRetry.setRelease(value);
		writeLastRequest.setRelease(System.currentTimeMillis());
	}
	
	public void resetRead() {
		readLastRetry.setRelease(0);
		readLastRequest.setRelease(System.currentTimeMillis());
	}
	
	public void resetWrite() {
		writeLastRetry.setRelease(0);
		writeLastRequest.setRelease(System.currentTimeMillis());
	}
}
