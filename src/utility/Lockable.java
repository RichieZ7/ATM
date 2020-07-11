package utility;

public interface Lockable<T> {

    T lock();
    T unlock();
    boolean getStatus();

}
