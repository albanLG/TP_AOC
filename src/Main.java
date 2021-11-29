import Elements.Afficheur;
import Elements.Canal;
import Elements.CapteurImpl;
import Elements.ObserverDeCapteur;
import Elements.Scheduler;
import algoDiffusion.AlgorithmeDiffusion;
import algoDiffusion.AlgorithmeEpoque;

public class Main {

	public static void main(String[] args) throws InterruptedException {
		Scheduler scheduler=new Scheduler();
		AlgorithmeDiffusion algo= new AlgorithmeEpoque();
		CapteurImpl capteur=new CapteurImpl(algo);
		
		ObserverDeCapteur afficheur1 = new Afficheur();
        ObserverDeCapteur afficheur2 = new Afficheur();
        ObserverDeCapteur afficheur3 = new Afficheur();
        ObserverDeCapteur afficheur4 = new Afficheur();
		
		capteur.attach(new Canal(capteur,scheduler,afficheur1));
		capteur.attach(new Canal(capteur,scheduler,afficheur2));
		capteur.attach(new Canal(capteur,scheduler,afficheur3));
		capteur.attach(new Canal(capteur,scheduler,afficheur4));

		while(capteur.compteur<6) {
			capteur.tick();
			Thread.sleep(1);
		}
		
		scheduler.waitAndFinished();
		
	}

}
