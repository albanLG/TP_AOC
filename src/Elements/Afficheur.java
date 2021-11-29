package Elements;
import java.util.concurrent.Future;

public class Afficheur implements ObserverDeCapteur{
	int data;
	
    @Override
    public void update(Canal c) {
        //System.out.println("new value: ");
        //il faut appeller la methode getValue du canal en mode bloquant
    	Future<Integer> f2= c.getValue();
    	try
        {
    		data=f2.get();
    		
    		c.releaseSemaphore();//tick termine pour cet afficheur, on libere une unite du semaphore
    		
    		System.out.println(data);
    		
        }catch (Exception e){
        	System.out.println("Doesn't work ...");
        }
    }
}
