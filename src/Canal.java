import java.util.concurrent.Future;

public class Canal implements ObserverDeCapteurAsync{
    @Override
    public Future update(Capteur s) {
    	
    	Update u=new Update();
    	Future f=Main.scheduler.enqueue(u);
    	
        return f;
    }

}
