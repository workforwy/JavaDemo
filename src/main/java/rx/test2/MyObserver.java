package rx.test2;

public class MyObserver implements Observer {

    @Override
    public void update(Observable obs, Object arg) {
        //更新状态
        if (obs instanceof MyObservable) {
            MyObservable observable = (MyObservable) obs;
            System.out.println(arg);
        }
    }
}
