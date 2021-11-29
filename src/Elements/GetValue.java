package Elements;
import java.util.concurrent.Callable;

public class GetValue implements MethodInvocation, Callable<Integer>{
	Canal canal;

	public GetValue(Canal c) {
		this.canal=c;
	}
	
	@Override
	public Integer call() {
		return canal.capt.getValue();
	}

}
