public interface Future<T> {
	void setDone(boolean isdone);
	boolean isDone();
	
    T get();
}
