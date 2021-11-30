package Elements;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Future;

public class Afficheur implements ObserverDeCapteur{
	int max=-1;
	List<Integer> values=new ArrayList<Integer>();
	
    @Override
    public void update(Canal c) {
        //il faut appeller la methode getValue du canal en mode bloquant
    	Future<Integer> f2= c.getValue();
    	try
        {
    		int data=f2.get();
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
		return values;
	}
}
