package reflect;

import list.Test1;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class Main {

    public static void main(String[] args) {
        Class test1Class = Test1.class;

        Method[] methods = test1Class.getDeclaredMethods();

        if (methods == null)
            return;

        StringBuilder sb = new StringBuilder();
        for (Method method : methods) {
            sb.append(Modifier.toString(method.getModifiers())).append(" ");
            sb.append(method.getReturnType()).append(" ");
            sb.append(method.getName()).append("(");
            Class[] parameters = method.getParameterTypes();
            if (parameters != null) {
                for (int i = 0; i < parameters.length; i++) {
                    Class paramCls = parameters[i];
                    sb.append(paramCls.getSimpleName());
                    if (i < parameters.length - 1)
                        sb.append(", ");
                }
            }
            sb.append(")\n\n");
            System.out.println(sb.toString());
        }
    }
}
