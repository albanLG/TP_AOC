import java.util.concurrent.Future;

public class Canal implements ObserverDeCapteurAsync{
	Afficheur affich=new Afficheur();
	
    @Override
    public Future update(Capteur s) {
    	
    	Update u=new Update();
    	Future f=Main.scheduler.enqueue(u);
    	
        return f;
    }

}
