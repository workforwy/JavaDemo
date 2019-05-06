package lambda;

public class Test_Lambda {

    private Test_Lambda() {
        Do b = this::printOnce;
        b.doStringWork("哈囉");
    }

    public static void main(String[] args) {
        Do b = Test_Lambda::printTwice;
        b.doStringWork("嗨");
        new Test_Lambda();

        Get c = Math::pow;
        b.doStringWork(String.valueOf(c.doComputeWork(2.5f, 2)));
    }

    private static void printTwice(String s) {
        System.out.print(s);
        System.out.println(s);
    }

    private void printOnce(String s) {
        System.out.println(s);
    }
}
