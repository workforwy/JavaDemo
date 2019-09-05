package rx.test4.bean;

import java.util.List;

/**
 * Created on 2018/5/10 0010 14:49.
 *
 * @author wy
 * 类定义：
 */
public class Student {

    public Student(List<Course> courses) {
        this.courses = courses;
    }

    private List<Course> courses;

    public List<Course> getCourses() {
        return courses;
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }

    public class Course {
        private String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}
