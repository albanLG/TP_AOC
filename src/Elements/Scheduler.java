package Elements;
import java.util.Objects;
import java.util.concurrent.Callable;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Scheduler {
	private long delayMax;
	
	//il faut strict minimum 2 pools, un pour le update, l autre pour le getValue
    private ScheduledExecutorService serviceScheduled = Executors.newScheduledThreadPool(20);
    
    public Scheduler(long max) {
    	this.delayMax=max;
    }
    
    public Future<Integer> enqueue(Callable<Integer> m){
    	Objects.requireNonNull(m,"Le callable ne doit pas etre null");
        return serviceScheduled.schedule(m, getRandomDelay(), TimeUnit.MILLISECONDS);
    }
    public Future<?> enqueue(Runnable m){
    	Objects.requireNonNull(m,"Le runnable ne doit pas etre null");
        return serviceScheduled.schedule(m, getRandomDelay(), TimeUnit.MILLISECONDS);
    }
    
    public void waitAndFinished() {
    	try {
			serviceScheduled.awaitTermination(3, TimeUnit.SECONDS);
			serviceScheduled.shutdown();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
    }
    
    private long getRandomDelay()
    {
        return (long) (Math.random() * delayMax);
    }
}
