package Elements;
public class Update implements Runnable{
	private Canal canal;
	
	public Update(Canal c) {
		this.canal=c;
	}
	
	@Override 
	public void run(){
		ObserverDeCapteur affich=canal.getAfficheur();
		affich.update(canal);
    }
}
