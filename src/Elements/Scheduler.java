package Elements;
import java.util.Objects;
import java.util.concurrent.Callable;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
/**
 * Scheduler is the class who
 *
 * @author LE GOFF Alban, MA Qian
 * @version 1
 */
public class Scheduler {
	private long delayMax;
	
	//il faut strict minimum 2 pools, un pour le update, l autre pour le getValue
    private ScheduledExecutorService serviceScheduled = Executors.newScheduledThreadPool(20);
    
    public Scheduler(long max) {
    	this.delayMax=max;
    }

    /**
     * Enqueue a Callable task
     * @param m is a Callable<Integer></>(non null)
     * @throws NullPointerException if the Callable is null
     */
    public Future<Integer> enqueue(Callable<Integer> m){
    	Objects.requireNonNull(m,"Le callable ne doit pas etre null");
        return serviceScheduled.schedule(m, getRandomDelay(), TimeUnit.MILLISECONDS);
    }
    /**
     * Enqueue a Runnable task
     * @param m is a Runnable(non null)
     * @throws NullPointerException if the Runnable is null
     */
    public Future<?> enqueue(Runnable m){
    	Objects.requireNonNull(m,"Le runnable ne doit pas etre null");
        return serviceScheduled.schedule(m, getRandomDelay(), TimeUnit.MILLISECONDS);
    }

    /**
     * Wait a task finished before execute another task
     * @throws InterruptedException or ExecutionException
     */
    public void waitAndFinished() {
    	try {
			serviceScheduled.awaitTermination(3, TimeUnit.SECONDS);
			serviceScheduled.shutdown();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
    }
    
    /**
     * Allows to randomly generate a long between 0 and MAX_DELAY
     *
     * @return a randomly generated long
     */
    private long getRandomDelay()
    {
        return (long) (Math.random() * delayMax);
    }
}
