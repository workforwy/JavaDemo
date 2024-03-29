package rxjava;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 1 on 2017/12/21 0021.
 */

public abstract class Subject<T> {
    /**
     * 用来保存注册的观察者对象
     */
    private List<Observer> list = new ArrayList<Observer>();

    /**
     * 注册观察者对象
     *
     * @param observer 观察者对象
     */
    public void attach(Observer observer) {
        list.add(observer);
        System.out.println("Attached an observer");
    }

    /**
     * 删除观察者对象
     *
     * @param observer 观察者对象
     */
    public void detach(Observer observer) {

        list.remove(observer);
    }

    /**
     * 通知所有注册的观察者对象
     */
    public void nodifyObservers(String newState) {

        for (Observer observer : list) {
            observer.update(newState);
        }
    }
}
