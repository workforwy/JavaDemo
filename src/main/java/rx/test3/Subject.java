package rx.test3;

/**
 * 被观察者
 */
public interface Subject {
    void add(Observer o);

    void del(Observer o);

    void call();
}
