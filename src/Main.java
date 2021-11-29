import Elements.Afficheur;
import Elements.Canal;
import Elements.CapteurImpl;
import Elements.ObserverDeCapteur;
import Elements.Scheduler;
import algoDiffusion.AlgorithmeDiffusion;
import algoDiffusion.DiffusionEpoque;
import algoDiffusion.DiffusionSequentielle;

public class Main {

	public static void main(String[] args) throws InterruptedException {
		Scheduler scheduler=new Scheduler();
		//On peut ajouter du delai pour voir que la diffusion sequentielle bloque certaines valeurs
		scheduler.setDelay(1L);
		
		AlgorithmeDiffusion algo= new DiffusionSequentielle();
		CapteurImpl capteur=new CapteurImpl(algo);
		
		ObserverDeCapteur afficheur1 = new Afficheur();
        ObserverDeCapteur afficheur2 = new Afficheur();
        ObserverDeCapteur afficheur3 = new Afficheur();
        ObserverDeCapteur afficheur4 = new Afficheur();
		
		capteur.attach(new Canal(capteur,scheduler,afficheur1));
		capteur.attach(new Canal(capteur,scheduler,afficheur2));
		capteur.attach(new Canal(capteur,scheduler,afficheur3));
		capteur.attach(new Canal(capteur,scheduler,afficheur4));
		
		//on configure la diffusion une fois que les canaux sont crees (car on a besoin d eux pour la config.)
		algo.configure(capteur);
		
		while(capteur.compteur<6) {
			capteur.tick();
			Thread.sleep(2);
		}
		
		scheduler.waitAndFinished();
		
	}

}
