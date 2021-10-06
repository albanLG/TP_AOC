public class Afficheur implements ObserverDeCapteur{
    @Override
    public void update(Capteur s) {
        System.out.println(s.getValue());
    }
}
