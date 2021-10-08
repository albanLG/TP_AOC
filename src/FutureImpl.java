public class FutureImpl<T> implements Future {
	T value;
	boolean done=false;
	
	
	
    @Override
    public Object get() {
        return null;
    }

    @Override
    public boolean isDone() {
        return done;
    }

	@Override
	public void setDone(boolean done) {
		this.done=done;
	}
}
