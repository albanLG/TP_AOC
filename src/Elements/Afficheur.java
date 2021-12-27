package Elements;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Future;
/**
 * Afficheur is the class who receive the value
 *
 * @author LE GOFF Alban, MA Qian
 * @version 1
 */

public class Afficheur implements ObserverDeCapteur{
	private int max=-1;
	private List<Integer> values=new ArrayList<Integer>();
	
    @Override
    public void update(Canal c) {
        //il faut appeller la methode getValue du canal en mode bloquant
    	Future<Integer> f2= c.getValue();
    	try
        {
    		int data=f2.get();//appel bloquant
    		if(max<=data) {
    			values.add(data);
    			max=data;
    		}
    		
        }catch (Exception e){
        	System.out.println("Doesn't work ...");
        }
    }

	@Override
	public List<Integer> getValues() {
		return Collections.unmodifiableList(values);
	}
}
