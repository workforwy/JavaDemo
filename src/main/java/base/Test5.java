package base;

import java.util.Arrays;

public class Test5 {

    public static void main(String args[]) {
        Example ex = new Example();
        ex.change(ex.str, ex.ch);

        System.out.print(ex.str + " and " + Arrays.toString(ex.ch));
    }

    static class Example {
        String str = "good";
        char[] ch = {'a', 'b', 'c'};

        void change(String str, char ch[]) {
            str = "test ok";
            ch[0] = 'g';
        }
    }
}


