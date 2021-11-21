import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.ArrayList;

public class Main {
	static Scheduler scheduler=new Scheduler();
	static CapteurImpl capteur=new CapteurImpl();
	static List<ObserverDeCapteurAsync> observers=new ArrayList<ObserverDeCapteurAsync>();
	static Long timeDelay=0L;

	public static void main(String[] args) throws InterruptedException {
		observers.add(new Canal(capteur));
		observers.add(new Canal(capteur));
		observers.add(new Canal(capteur));
		observers.add(new Canal(capteur));

		capteur.observers=observers;
		
		while(capteur.compteur<6) {
			capteur.tick();
			Thread.sleep(1500);
		}
	}

}
