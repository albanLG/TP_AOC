import java.util.concurrent.Callable;

public class GetValue implements MethodInvocation, Callable<Integer>{
	Canal canal;

	@Override
	public Integer call() {
		return canal.capt.getValue();
	}

}
