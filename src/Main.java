import java.util.List;
import java.util.ArrayList;

public class Main {
	static Scheduler scheduler=new Scheduler();
	static Capteur capteur=new CapteurImpl();
	static List<ObserverDeCapteur> observers=new ArrayList<ObserverDeCapteur>();
	static Long timeDelay=2L;
	
	public static void main(String[] args) {
		
	}

}
