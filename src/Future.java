public interface Future<T> {
    T get();
    boolean isDone();
}
