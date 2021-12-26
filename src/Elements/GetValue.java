package Elements;
import java.util.concurrent.Callable;

public class GetValue implements Callable<Integer>{
	Canal canal;

	public GetValue(Canal c) {
		this.canal=c;
	}
	
	@Override
	public Integer call() {
		return canal.capt.getValue();
	}

}
