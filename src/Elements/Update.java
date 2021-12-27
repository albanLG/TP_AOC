package Elements;

import java.util.Objects;
/**
 * Update is the class who update the value of afficheur
 *
 * @author LE GOFF Alban, MA Qian
 * @version 1
 */
public class Update implements Runnable{
	private Canal canal;
	/**
	 * Allows to link an canal
	 *
	 * @param c is a canal (non null)
	 * @throws NullPointerException if the observer is null
	 */
	public Update(Canal c) {
		Objects.requireNonNull(c);
		this.canal=c;
	}

	/**
	 * Allows update the value of afficheur in this canal
	 * @throws NullPointerException if the capteur is null
	 */
	@Override 
	public void run(){
		ObserverDeCapteur affich=canal.getAfficheur();
		Objects.requireNonNull(affich);
		affich.update(canal);
    }
}
