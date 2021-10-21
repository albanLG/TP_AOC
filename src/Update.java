import java.util.concurrent.Callable;

public class Update implements MethodInvocation, Callable<String>{
	Canal canal;
	
	@Override 
	public String call() throws Exception{
		canal.affich.update();
		return "yololo";
    }
}
