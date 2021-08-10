package staticfinal;

class Demo {
    static int count;

    Demo() {
        count++;
    }

    static {
        count++;
    }

    public static void main(String args[]) {
        Demo s = new Demo();
        System.out.println(s.count);
        s = new Demo();
        System.out.println(s.count);

    }
}
