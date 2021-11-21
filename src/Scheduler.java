import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Scheduler {
    ScheduledExecutorService serviceScheduled = Executors.newScheduledThreadPool(1);
    
    public Future enqueue(Callable m){
        return serviceScheduled.schedule(m, Main.timeDelay, TimeUnit.SECONDS);
    }
    public Future enqueue(Runnable m){
        return serviceScheduled.schedule(m, Main.timeDelay, TimeUnit.SECONDS);
    }
    
    public void setValue(Future f){}//a quoi sert cette fonction?
    
}
