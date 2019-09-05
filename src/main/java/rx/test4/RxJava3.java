package rx.test4;

import rx.test4.bean.Student;
import rx.Observable;
import rx.Subscriber;
import rx.functions.Func1;
import utils.Log;

/**
 * Created on 2018/5/10 0010 14:48.
 *
 * @author wy
 * 类定义：
 */
public class RxJava3 {

    private static String tag = "RxJava3";

    public static void main(String[] args) {
        fun1();
    }

    private static void fun1() {
        Student[] students = {};
        Subscriber<Student.Course> subscriber = new Subscriber<Student.Course>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(Student.Course course) {
                Log.d(tag, course.getName());
            }
        };
        Observable.from(students)
                .flatMap(new Func1<Student, Observable<Student.Course>>() {
                    @Override
                    public Observable<Student.Course> call(Student student) {
                        return Observable.from(student.getCourses());
                    }
                })
                .subscribe(subscriber);
    }
}
