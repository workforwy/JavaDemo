package rx.test4;

import rx.Observer;
import rx.Subscriber;
import utils.Log;

/**
 * Created on 2018/5/8 0008 17:20.
 *
 * @author wy
 * 类定义：
 */
public class RxJava1 {

    private static String tag = "RxJava1";

    public static void main(String[] args) {
        ObservableUtils.getObserable1().subscribe(observer);
        ObservableUtils.getObserable2().subscribe(subscriber);
    }

    static Observer<String> observer = new Observer<String>() {
        @Override
        public void onNext(String s) {
            Log.d(tag, "Item: " + s);
        }

        @Override
        public void onCompleted() {
            Log.d(tag, "Completed!");
        }

        @Override
        public void onError(Throwable e) {
            Log.d(tag, "Error!");
        }
    };

    static Subscriber<String> subscriber = new Subscriber<String>() {

        @Override
        public void onNext(String s) {
            Log.d(tag, "Item: " + s);
        }

        @Override
        public void onError(Throwable e) {
            Log.d(tag, "Error!");
        }

        @Override
        public void onCompleted() {
            Log.d(tag, "Completed!");
        }
    };
}
