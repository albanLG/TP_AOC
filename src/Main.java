import javax.swing.JFrame;

import Elements.Afficheur;
import Elements.Canal;
import Elements.CapteurImpl;
import Elements.ObserverDeCapteur;
import Elements.ObserverDeCapteurAsync;
import Elements.Scheduler;
import algoDiffusion.AlgorithmeDiffusion;
import algoDiffusion.DiffusionAtomique;
import algoDiffusion.DiffusionEpoque;
import algoDiffusion.DiffusionSequentielle;

public class Main {

	public static void main(String[] args) throws InterruptedException {
		Scheduler scheduler=new Scheduler(8L);
		
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
		
		enableRendering();
		
		while(capteur.compteur<6) {
			capteur.tick();
			Thread.sleep(10);
		}
		
		scheduler.waitAndFinished();
		
		//on affiche les afficheurs :O
		for(ObserverDeCapteurAsync o : capteur.getObservers()) {
			System.out.println(o.getAfficheur().getValues());
		}
	}
	
	public static void enableRendering() {
		JFrame f=new JFrame();
		f.setSize(400,500);//400 width and 500 height  
		f.setLayout(null);//using no layout managers  
		f.setVisible(true);//making the frame visible  
	}

}
