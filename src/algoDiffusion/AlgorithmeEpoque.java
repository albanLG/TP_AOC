package algoDiffusion;

import Elements.Capteur;
import Elements.ObserverDeCapteurAsync;

public class AlgorithmeEpoque implements AlgorithmeDiffusion {
	Capteur capteur;
	
	@Override
	public void configure(Capteur c) {
		this.capteur = c;
	}
	
	@Override
	public void diffuse() {
		for(ObserverDeCapteurAsync obs: capteur.getObservers()) {
    		obs.update();
    	}
	}

}
