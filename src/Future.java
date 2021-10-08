public interface Future<T> {
	void setDone();
	
    T get();
    boolean isDone();
}
