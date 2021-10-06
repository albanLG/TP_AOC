import java.util.ArrayList;
import java.util.List;

public class Scheduler {
    List<MethodInvocation> updates = new ArrayList<>();

    public Future enqueue(MethodInvocation m){
        updates.add(m);
        return null;
    }

    public void setValue(Future f){

    }
}
