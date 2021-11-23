import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Scheduler {
	//il faut strict minimum 2 pools, un pour le update, l autre pour le getValue
    ScheduledExecutorService serviceScheduled = Executors.newScheduledThreadPool(8);
    
    public Future enqueue(Callable<Integer> m){
        return serviceScheduled.schedule(m, Main.timeDelay, TimeUnit.SECONDS);
    }
    public Future enqueue(Runnable m){
        return serviceScheduled.schedule(m, Main.timeDelay, TimeUnit.SECONDS);
    }
    
}
