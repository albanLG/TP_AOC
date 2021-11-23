import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.Set;

public class CapteurImpl implements Capteur{
	Scheduler sheduler;
	private Set<ObserverDeCapteurAsync> observers;
	int compteur=0;
	
	
	public CapteurImpl()
    {
        this.observers = new LinkedHashSet<>();
    }
	
	
    @Override
    public void attach(ObserverDeCapteurAsync o) {observers.add(o);}

    @Override
    public int getValue() {
        return compteur;
    }

    @Override
    public void tick() {
    	compteur++;
    	updateAll();
    }
    
    //Renvoie les observeurs. On en aura besoin dans les algorithmes de diffusion.
    public Set<ObserverDeCapteurAsync> getObservers()
    {
        return Collections.unmodifiableSet(this.observers);
    }
    
    public void updateAll() {
    	for(ObserverDeCapteurAsync obs: observers) {
    		obs.update();
    	}
    }
}
