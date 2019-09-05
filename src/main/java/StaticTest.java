public  class StaticTest {


    static {
        System.out.println("静态代码块");
    }

    private static StaticTest staticTest = new StaticTest();

    private StaticTest() {
        System.out.println("静态常量");
    }

    public static void main(String[] args) {
        new InnerClass();
    }

    private static class InnerClass {
        static {
            System.out.println("内部类的静态代码块");
        }
    }
}
