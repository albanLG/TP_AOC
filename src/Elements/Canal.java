package Elements;
import java.util.Objects;
import java.util.concurrent.Future;

public class Canal implements ObserverDeCapteurAsync{
	private Scheduler scheduler;
	private ObserverDeCapteur affich;
	private Capteur capt;
	
	public Canal(Capteur c, Scheduler schedul, ObserverDeCapteur afficheur) {
		Objects.requireNonNull(c,"Le capteur ne doit pas etre null");
        Objects.requireNonNull(schedul,"Le scheduler ne doit pas etre null");
        Objects.requireNonNull(afficheur,"L'afficheur ne doit pas etre null");
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

	public Capteur getCapt() {
		return capt;
	}
}