public class CapteurImpl implements Capteur{
	int compteur=0;
	
    @Override
    public void attache(ObserverDeCapteur o) {
    
    }

    @Override
    public int getValue() {
        return compteur;
    }

    @Override
    public void tick() {
    	compteur++;
    }
}
