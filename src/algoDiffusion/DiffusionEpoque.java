package algoDiffusion;

import Elements.Capteur;
import Elements.ObserverDeCapteurAsync;

/**
 * DiffusionEpoque is the class who distribute the value by using epoque(period) methode.
 *
 * @author LE GOFF Alban, MA Qian
 * @version 1
 */

public class DiffusionEpoque implements AlgorithmeDiffusion {
	Capteur capteur;
	
	@Override
	public void configure(Capteur c) {
		this.capteur = c;
	}
	
	@Override
	public void diffuse() {
		//On diffuse sans bloquer le thread principale et on n utilise pas la lockedValue,
		//ce qui veut dire qu il peut y avoir un tick pile au moment ou j update mes afficheurs.
		//Donc il y aura des afficheurs avec la valeur i et les autres avec la valeur i+1
		for(ObserverDeCapteurAsync obs: capteur.getObservers()) {
    		obs.update();
    	}
	}

	@Override
	public void releaseSemaphore() {
		//Pas besoin de semaphore pour la diffusion par epoque
	}

}
