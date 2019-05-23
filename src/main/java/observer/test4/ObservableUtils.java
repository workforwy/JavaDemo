package observer.test4;

import rx.Observable;

/**
 * Created on 2018/5/9 0009 17:46.
 *
 * @author wy
 * 类定义：
 */
public class ObservableUtils {

    public static Observable getObserable1() {
        return Observable.create((Observable.OnSubscribe<String>) subscriber -> {
            subscriber.onNext("Hello");
            subscriber.onNext("Hi");
            subscriber.onNext("Aloha");
            subscriber.onCompleted();
        });
    }

    public static Observable getObserable2() {
        return Observable.just("Hello", "Hi", "Aloha", "123");
    }

    public static Observable getObserable3() {
        String[] words = {"Hello", "Hi", "Aloha"};
        return Observable.from(words);
    }

}
