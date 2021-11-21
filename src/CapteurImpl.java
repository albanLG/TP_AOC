import java.util.ArrayList;
import java.util.List;

public class CapteurImpl implements Capteur{
	Scheduler sheduler;
	List<ObserverDeCapteurAsync> observers=new ArrayList<ObserverDeCapteurAsync>();
	int compteur=0;
	
    @Override
    public void attach(ObserverDeCapteurAsync o) {
    	observers.add(o);
    	
    }

    @Override
    public int getValue() {
        return compteur;
    }

    @Override
    public void tick() {
    	compteur++;
    	updateAll();
    }
    
    public void updateAll() {
    	for(ObserverDeCapteurAsync obs: observers) {
    		obs.update();
    	}
    }
}
