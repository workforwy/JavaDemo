package reflect;

import java.lang.reflect.Constructor;

public class Main {

    public static void main(String[] args) {
        Class a = Main.class;
        Constructor[] constructors = a.getConstructors();
        for (Constructor constructor : constructors) {
            System.out.println("类名称"+constructor.getName()+"类参数"+constructor.getParameters().length);
        }
    }
}
