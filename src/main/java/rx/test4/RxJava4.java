package rx.test4;

import rx.Observable;
import rx.functions.Action1;
import rx.functions.Func1;
import utils.Log;

public class RxJava4 {

    public static void main(String[] args) {

        fun1();
    }

    private static void fun1() {
        Observable.just("images/logo.png") // 输入类型 String
                .map(new Func1<String, String>() {
                    @Override
                    public String call(String filePath) { // 参数类型 String
                        Log.d("call" + filePath);
                        return getBitmapFromPath(filePath); // 返回类型 Bitmap
                    }
                })
                .subscribe(new Action1<String>() {
                    @Override
                    public void call(String bitmap) { // 参数类型 Bitmap
                        showBitmap(bitmap);
                    }
                });
    }


    private static void showBitmap(String bitmap) {
        Log.d(bitmap);
    }

    private static String getBitmapFromPath(String filePath) {
        return filePath;
    }
}
