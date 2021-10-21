import java.util.concurrent.Callable;

public class Update implements MethodInvocation, Callable<String>{
	@Override 
	public String call() throws Exception{
		return "coucou";
    }
}
