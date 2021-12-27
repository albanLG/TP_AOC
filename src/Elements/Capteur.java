package Elements;

import java.util.Set;

/**
 * <b>Represents a capteur</b>
 *
 * @author LE GOFF Alban, MA Qian
 * @version 1
 */

public interface Capteur {
    /**
     * Allows you to link an asynchronous capteur observer (channel) to the sensor, by adding the observer to the observer set.
     *
     * @param o is a Observer of capteur in asynchronous mode (non null)
     * @throws NullPointerException if the observer is null
     */
    void attach(ObserverDeCapteurAsync o);


    /**
     * Allows you to obtain the counter value of the cqpteur
     *
     * @return Integer an Integer containing the value of the capteur
     */
    int getValue();

    /**
     * Allows to simulate a tick in the capteur.
     *
     * @throws InterruptedException
     */
    void tick();

    /**
     * Allows to obtain the collection of all the observers of the sensor.
     *
     * @return Set<SensorObserverAsync> a Set containing all the observers of the sensor
     */
    Set<ObserverDeCapteurAsync> getObservers();

    /**
     * Allows you to update the counter value of the capteur that will be locked.
     */
    void updateLockedValue();
}
