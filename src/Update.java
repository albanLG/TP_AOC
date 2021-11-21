public class Update implements MethodInvocation, Runnable{
	Canal canal;
	
	@Override 
	public void run(){
		canal.affich.c=canal;
		canal.affich.update();
    }
}
