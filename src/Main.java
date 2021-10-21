import java.util.List;
import java.util.ArrayList;

public class Main {
	static Scheduler scheduler=new Scheduler();
	static CapteurImpl capteur=new CapteurImpl();
	static List<ObserverDeCapteurAsync> observers=new ArrayList<ObserverDeCapteurAsync>();
	static Long timeDelay=2L;
	
	public static void main(String[] args) {
		observers.add(new Canal());
		observers.add(new Canal());
		observers.add(new Canal());
		observers.add(new Canal());
		
		capteur.observers=observers;
		
		capteur.updateAll();
	}

}
