
public class Canal implements ObserverDeCapteurAsync{
    @Override
    public Future update(Capteur s) {
    	
    	Update u=new Update();
    	Future f=Main.sheduler.enqueue(u);
    	
        return f;
    }

}
