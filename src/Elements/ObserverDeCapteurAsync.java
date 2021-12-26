package Elements;
import java.util.concurrent.Future;

/**
 * <b>Represents a observer of capteur in asynchronous mode</b>
 *
 * @author LE GOFF Alban, MA Qian
 * @version 1
 */
public interface ObserverDeCapteurAsync {
    /**
     * Allows to make an asynchronous call to notify the afficheur of a new value after a certain time
     *
     * The sensor must not be null
     *
     * @return Future<?> a future of nothing
     *
     * @throws NullPointerException if the sensor is null
     */

    Future<?> update();

    /**
     * Allows to make an asynchronous call to retrieve the value of the capteur after a certain time .
     *
     * The capteur must not be null
     *
     * @return Future<Integer> a future containing the sensor value
     *
     * @throws NullPointerException if the sensor is null
     */
    Future<Integer> getValue();

    /**
     * Allows to return the current qfficheur.
     *
     * The afficheur must not be null
     *
     * @return Future<Integer> a future containing the sensor value
     *
     * @throws NullPointerException if the sensor is null
     */

    ObserverDeCapteur getAfficheur();
}
