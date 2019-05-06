package observer.test2;

public class Test {

    public static void main(String[] args) {
        MyObservable myObservable = new MyObservable();
        MyObserver myObserver = new MyObserver();
        myObservable.addObserver(myObserver);
        myObservable.notifyObservers("hahaha");
    }
}
