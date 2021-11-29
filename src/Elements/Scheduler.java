package Elements;
import java.util.concurrent.Callable;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Scheduler {
	Long timeDelay=0L;
	
	//il faut strict minimum 2 pools, un pour le update, l autre pour le getValue
    ScheduledExecutorService serviceScheduled = Executors.newScheduledThreadPool(20);
    
    public Future<Integer> enqueue(Callable<Integer> m){
        return serviceScheduled.schedule(m, timeDelay, TimeUnit.SECONDS);
    }
    public Future<?> enqueue(Runnable m){
        return serviceScheduled.schedule(m, timeDelay, TimeUnit.SECONDS);
    }
    
    public void waitAndFinished() {
    	try {
			serviceScheduled.awaitTermination(2, TimeUnit.SECONDS);
			serviceScheduled.shutdown();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
    }
}
