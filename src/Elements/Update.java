package Elements;
public class Update implements Runnable{
	Canal canal;
	
	public Update(Canal c) {
		this.canal=c;
	}
	
	@Override 
	public void run(){
		canal.affich.update(canal);
    }
}
