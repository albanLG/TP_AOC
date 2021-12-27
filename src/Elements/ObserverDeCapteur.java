package Elements;

import java.util.List;
/**
 * <b>Represents a observer of captuer</b>
 *
 * @author LE GOFF Alban, MA Qian
 * @version 1
 */

public interface ObserverDeCapteur {

    /**
     * Allows to simulate the update of the afficheur value by the canal.
     *
     * @param c is a Canal
     *
     * @throws InterruptedException or ExecutionException
     */
    void update(Canal c);

    /**
     * Allows you to obtain the values that the canal observer has received.
     *
     * @return List<Integer> represents the set of values received
     */
    List<Integer> getValues();
}
