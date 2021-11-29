package Elements;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.Set;

import algoDiffusion.AlgorithmeDiffusion;
import algoDiffusion.DiffusionEpoque;

public class CapteurImpl implements Capteur{
	Scheduler sheduler;
	
	public Set<ObserverDeCapteurAsync> observers;
	
	public int compteur=0;				//la valeur du compteur
	int lockedValue=compteur;	//la valeur du compteur qui est cense etre lu par tous les canaux avant d etre update
	
	AlgorithmeDiffusion algoDiff;
	
	
	public CapteurImpl(AlgorithmeDiffusion alg)
    {
        this.observers = new LinkedHashSet<>();
        this.algoDiff=alg;
        this.algoDiff.configure(this);
    }
	
	
    @Override
    public void attach(ObserverDeCapteurAsync o) {observers.add(o);}

    @Override
    public int getValue() {
    	if(algoDiff instanceof DiffusionEpoque) {//si on utilise l algorithme par epoque, on renvoie la valeur tel quel, on ne cherche pas a avoir la meme valeur pour tous
    		return compteur;
    	}
    	return lockedValue;
    }

    @Override
    public void tick() {
    	compteur++;
    	try {
			algoDiff.diffuse();
		} 
    	catch (InterruptedException e) {
			System.out.println("Tick error !");
		}
    }
    
    //Renvoie les observeurs. On en aura besoin dans les algorithmes de diffusion.
    public Set<ObserverDeCapteurAsync> getObservers()
    {
        return Collections.unmodifiableSet(this.observers);
    }


	@Override
	public void updateLockedValue() {
		lockedValue=compteur;
	}


	@Override
	public void releaseSemaphore() {
		algoDiff.releaseSemaphore();
	}
}
