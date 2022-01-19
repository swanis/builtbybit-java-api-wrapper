package is.swan.mcmarketapi.request.sorting;

import java.util.concurrent.atomic.AtomicLong;

public class Throttler {
	enum RequestType {
		READ, WRITE 
	}
	
	private final AtomicLong readLastRetry = new AtomicLong(0);
	private final AtomicLong readLastRequest = new AtomicLong(System.currentTimeMillis());
	
	private final AtomicLong writeLastRetry = new AtomicLong(0);
	private final AtomicLong writeLastRequest = new AtomicLong(System.currentTimeMillis());
	
	public long stallFor(RequestType type) {
	    long time = System.currentTimeMillis();
	    
	    switch (type) {
	    	case READ:
	    		return Throttler.stalForHelper(this.readLastRetry, this.readLastRequest, time);
	    	case WRITE:
	    		return Throttler.stalForHelper(this.writeLastRetry, this.writeLastRequest, time);
	    	default:
	    		return 0;
	    }
	}
	
	private static long stalForHelper(AtomicLong aLastRetry, AtomicLong aLastRequest, long time){
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
