package Elements;
import java.util.Objects;
import java.util.concurrent.Future;

public class Canal implements ObserverDeCapteurAsync{
	Scheduler scheduler;
	ObserverDeCapteur affich;
	Capteur capt;
	
	public Canal(Capteur c, Scheduler schedul, ObserverDeCapteur afficheur) {
		Objects.requireNonNull(c);
        Objects.requireNonNull(schedul);
        Objects.requireNonNull(afficheur);
		this.capt=c;
		this.scheduler=schedul;
		this.affich=afficheur;
	}
	
    @Override
    public Future<?> update() {
    	Update u=new Update(this);	
        return this.scheduler.enqueue(u);
    }
    
    @Override
    public Future<Integer> getValue() {
    	GetValue gv=new GetValue(this);   	
    	return this.scheduler.enqueue(gv);
    }
    
    @Override
	public ObserverDeCapteur getAfficheur() {
    	return affich;
    }
}