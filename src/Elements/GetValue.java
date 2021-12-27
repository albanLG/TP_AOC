package Elements;
import java.util.concurrent.Callable;

/**
 * Afficheur is the class who receive the value
 *
 * @author LE GOFF Alban, MA Qian
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
