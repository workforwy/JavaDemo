package rx.test4;

import rx.Observable;
import rx.functions.Action0;
import rx.functions.Action1;
import rx.schedulers.Schedulers;
import utils.Log;
/**
 * Created on 2018/5/9 0009 14:32.
 *
 * @author wy
 * 类定义：
 */
public class RxJava2 {

    private static String tag = "RxJava1";
    private static Observable observable;

    public static void main(String[] args) {
        fun1();
    }

    private static void fun1() {
        observable = ObservableUtils.getObserable3();
        Action1<String> onNextAction = new Action1<String>() {
            // onNext()
            @Override
            public void call(String s) {
                Log.d(tag, s);
            }
        };
        Action1<Throwable> onErrorAction = new Action1<Throwable>() {
            // onError()
            @Override
            public void call(Throwable throwable) {
                // Error handling
            }
        };
        // onCompleted()
        Action0 onCompletedAction = () -> Log.d(tag, "completed");
        // 自动创建 Subscriber ，并使用 onNextAction 来定义 onNext()
        observable.subscribe(onNextAction);
        // 自动创建 Subscriber ，并使用 onNextAction 和 onErrorAction 来定义 onNext() 和 onError()
        observable.subscribe(onNextAction, onErrorAction);
        // 自动创建 Subscriber ，并使用 onNextAction、 onErrorAction 和 onCompletedAction 来定义 onNext()、 onError() 和 onCompleted()
        observable.subscribe(onNextAction, onErrorAction, onCompletedAction);
    }

    private static void fun2() {
        String[] names = {"Hello", "Hi", "Aloha"};
        Observable.from(names).subscribeOn(Schedulers.io())
//                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Action1<String>() {
                    @Override
                    public void call(String name) {
                        Log.d(tag, name);
                    }
                });
    }
}
