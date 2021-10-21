import java.util.concurrent.Future;

public class Canal implements ObserverDeCapteurAsync{
	Afficheur affich=new Afficheur();
	
    @Override
    public Future update(Capteur s) {
    	
    	Update u=new Update();
    	u.canal = this;
    	Future f=Main.scheduler.enqueue(u);
    	
        return f;
    }

}
