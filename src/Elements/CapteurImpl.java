package Elements;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Set;

import algoDiffusion.AlgorithmeDiffusion;
import algoDiffusion.DiffusionEpoque;

public class CapteurImpl implements Capteur{
	Scheduler sheduler;
	
	private Set<ObserverDeCapteurAsync> observers;
	
	private int compteur=0;				//la valeur du compteur
	private int lockedValue=getCompteur();	//la valeur du compteur qui est cense etre lu par tous les canaux avant d etre update
	
	AlgorithmeDiffusion algoDiff;
	
	
	public CapteurImpl(AlgorithmeDiffusion alg)
    {
		Objects.requireNonNull(alg, "L'algorithme de diffusion ne doit pas etre null");
        this.observers = new LinkedHashSet<>();
        this.algoDiff=alg;
    }
	
	
    @Override
    public void attach(ObserverDeCapteurAsync o) {
    	Objects.requireNonNull(o, "Le canal ne doit pas etre null");
    	observers.add(o);
    }

    @Override
    public int getValue() {
    	if(algoDiff instanceof DiffusionEpoque) {//si on utilise l algorithme par epoque, on renvoie la valeur tel quel, on ne cherche pas a avoir la meme valeur pour tous
    		return getCompteur();
    	}
    	algoDiff.releaseSemaphore();//tick termine un afficheur, on libere une unite du semaphore
    	return lockedValue;
    }

    @Override
    public void tick() {
    	compteur = compteur + 1;
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
		lockedValue=getCompteur();
	}


	public int getCompteur() {
		return compteur;
	}
}
