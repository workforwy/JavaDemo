package rx;

/**
 * Created by 1 on 2017/12/21 0021.
 */

public class ConcreteObserver implements Observer.Contact,Observer {
    //观察者的状态
    private String observerState;

    @Override
    public void update(String state) {
        /**
         * 更新观察者的状态，使其与目标的状态保持一致
         */
        observerState = state;
        System.out.println("状态为："+observerState);
    }

    @Override
    public void add(String a) {

    }

    @Override
    public void delete(int id) {

    }

    @Override
    public void update(int id) {

    }
}
