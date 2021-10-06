public interface Capteur {
    void attache(ObserverDeCapteur o);
    int getValue();
    void tick();
}
