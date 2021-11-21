import java.util.concurrent.Future;

public class Canal implements ObserverDeCapteurAsync{
	Afficheur affich=new Afficheur();
	Capteur capt;
	
	public Canal(Capteur c) {
		this.capt=c;
	}
	
    @Override
    public Future update() {
    	Update u=new Update();
    	u.canal = this;
    	
        return Main.scheduler.enqueue(u);
    }
    @Override
    public Future getValue() {
    	GetValue gv=new GetValue();
    	gv.canal=this;
    	
    	return Main.scheduler.enqueue(gv);
    }
}