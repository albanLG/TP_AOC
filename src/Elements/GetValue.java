package Elements;
import java.util.concurrent.Callable;

/**
 * Affcheur is the class who recieve the value
 *
 * @author LEGOFF Alban, MA Qian
 * @version 1
 */
public class GetValue implements Callable<Integer>{
	private Canal canal;

	public GetValue(Canal c) {
		this.canal=c;
	}
	
	@Override
	public Integer call() {
		Capteur capt=canal.getCapt();
		return capt.getValue();
	}

}
