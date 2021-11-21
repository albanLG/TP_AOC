import java.util.concurrent.Future;

public class Afficheur implements ObserverDeCapteur{
	public Canal c;
    @Override
    public void update() {
        //System.out.println("new value: ");
        //il faut appeller la methode getValue du canal en mode bloquant
    	Future<Integer> f2= c.getValue();
    }
}
