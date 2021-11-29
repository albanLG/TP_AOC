package Elements;
import java.util.concurrent.Future;

public interface ObserverDeCapteurAsync {
    Future<?> update();
    Future<Integer> getValue();
    void releaseSemaphore();
}
