public class Update implements MethodInvocation, Runnable{
	Canal canal;
	
	public Update(Canal c) {
		this.canal=c;
	}
	
	@Override 
	public void run(){
		canal.affich.update(canal);
    }
}
