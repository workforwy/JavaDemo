package rx.test2;

public interface Observable {
    public void addObserver(Observer ob);

    public void deleteObserver(Observer ob);

    public void notifyObservers(Object arg);
}
