package Elements;

import java.util.List;

public interface ObserverDeCapteur {
    void update(Canal c);
    
    List<Integer> getValues();
}
