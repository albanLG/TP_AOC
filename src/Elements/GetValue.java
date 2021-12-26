package Elements;
import java.util.concurrent.Callable;

public class GetValue implements Callable<Integer>{
	private Canal canal;

	public GetValue(Canal c) {
		this.canal=c;
	}
	
	@Override
	public Integer call() {
		Capteur capt=canal.getCapt();
		return capt.getValue();
	}

}
