public class Main {
	static Long timeDelay=0L;

	public static void main(String[] args) throws InterruptedException {
		Scheduler scheduler=new Scheduler();
		CapteurImpl capteur=new CapteurImpl();
		
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
			Thread.sleep(1500);
		}
	}

}
