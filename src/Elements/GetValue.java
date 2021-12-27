package Elements;
import java.util.Objects;
import java.util.concurrent.Callable;

/**
 * GetValue is the class who get the current value of canal
 *
 * @author LE GOFF Alban, MA Qian
 * @version 1
 */
public class GetValue implements Callable<Integer>{
	private Canal canal;
	/**
	 * Allows to link an canal
	 *
	 * @param c is a canal (non null)
	 * @throws NullPointerException if the observer is null
	 */
	public GetValue(Canal c) {
		Objects.requireNonNull(c);
		this.canal=c;
	}
	/**
	 * Allows get the counter value of the capteur in this canal
	 * @throws NullPointerException if the capteur is null
	 */
	@Override
	public Integer call() {
		Capteur capt=canal.getCapt();
		Objects.requireNonNull(capt);
		return capt.getValue();
	}

}
