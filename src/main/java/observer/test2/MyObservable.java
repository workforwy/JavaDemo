package observer.test2;

import java.util.ArrayList;

public class MyObservable implements Observable {
    private ArrayList observers;
    private String message;

    public MyObservable() {
        observers = new ArrayList();
    }

    public void addObserver(Observer ob) {
        observers.add(ob);
    }

    public void deleteObserver(Observer ob) {
        int i = observers.indexOf(ob);
        if (i >= 0) {
            observers.remove(i);
        }
    }

    public void notifyObservers(Object arg) {
        for (int i = 0; i < observers.size(); i++) {
            Observer observer = (Observer) observers.get(i);
            observer.update(this, arg);
        }
    }

    public void setMessage(String message) {
        this.message = message;
        notifyObservers(null);
    }

    public String getMessage() {
        return message;
    }
}