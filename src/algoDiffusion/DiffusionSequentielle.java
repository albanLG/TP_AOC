package algoDiffusion;

import java.util.concurrent.Semaphore;

import Elements.Capteur;
import Elements.ObserverDeCapteurAsync;

public class DiffusionSequentielle implements AlgorithmeDiffusion {
	Capteur capteur;
	Semaphore semaphore;
	
	@Override
	public void configure(Capteur c) {
		this.capteur = c;
		this.semaphore = new Semaphore(capteur.getObservers().size());
	}
	
	@Override
	public void diffuse() throws InterruptedException {
		//on update uniquement si tous les observateurs sont prets (s il y en a qui update tjrs, alors on rentre pas) 
		if (semaphore.availablePermits() == this.capteur.getObservers().size()){
            semaphore.acquire(this.capteur.getObservers().size());
            
            this.capteur.updateLockedValue();
            
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
