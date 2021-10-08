public class FutureImpl<T> implements Future<T> {
	T value;
	boolean done=false;
	

    @Override
    public T get() {
        return value;
    }

    @Override
    public boolean isDone() {
        return done;
    }

	@Override
	public void setDone(boolean done) {
		this.done=done;
	}

	@Override
	public void setValue(T val) {
		this.value=val;
		setDone(true);
	}
}
