package algoDiffusion;

import java.util.concurrent.Semaphore;

import Elements.Capteur;
import Elements.ObserverDeCapteurAsync;

/**
 * DiffusionAtomique is the class who distribute the value by using Atomic methode.
 *
 * @author LE GOFF Alban, MA Qian
 * @version 1
 */

public class DiffusionAtomique implements AlgorithmeDiffusion {
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
		//bloque le thread principale jusqu'a ce qu il y ai assez de permissions
		//(quand on bloque le thread principale, on bloque aussi l appelle du tick)
        semaphore.acquire(this.capteur.getObservers().size());
        capteur.updateLockedValue();
        
		for(ObserverDeCapteurAsync obs: capteur.getObservers()) {
    		obs.update();
    	}
	}

	@Override
	public void releaseSemaphore() {
		semaphore.release(1);
	}

}
