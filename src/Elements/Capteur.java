package Elements;

import java.util.Set;


public interface Capteur {
    void attach(ObserverDeCapteurAsync  o);
    int getValue();
    void tick();
    
    Set<ObserverDeCapteurAsync> getObservers();
    
    void updateLockedValue();
    
    void releaseSemaphore();
}
