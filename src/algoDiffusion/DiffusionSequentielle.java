package algoDiffusion;

import java.util.concurrent.Semaphore;

import Elements.Capteur;
import Elements.ObserverDeCapteurAsync;

/**
 * DiffusionSeauentielle is the class who distribute the value by using sequential methode.
 *
 * @author LEGOFF Alban, MA Qian
 * @version 1
 */


public class DiffusionSequentielle implements AlgorithmeDiffusion {
	Capteur capteur;
	Semaphore semaphore;
	
	@Override
	public void configure(Capteur c) {
		this.capteur = c;
		int numb=capteur.getObservers().size();
		this.semaphore = new Semaphore(numb);
	}
	
	@Override
	public void diffuse() throws InterruptedException {
		//Si il n y a pas assez de permission dispo, alors on ne diffuse pas
		//Le thread principale quand à lui n est pas bloque donc les afficheurs vont tous rater qqvaleurs
		
		if (semaphore.availablePermits() == this.capteur.getObservers().size()){
			
            semaphore.acquire(this.capteur.getObservers().size());
            capteur.updateLockedValue();
            
			for(ObserverDeCapteurAsync obs: capteur.getObservers()) {
	    		obs.update();
	    	}
        }
	}

	@Override
	public void releaseSemaphore() {
		semaphore.release(1);
	}

}
