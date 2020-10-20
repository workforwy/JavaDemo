class Root {
    static {
        System.out.println("Root的静态初始化块。");
    }
    public Root() {
        System.out.println("Root的无参构造函数。");
    }
    {
        System.out.println("Root的普通初始化块。");
    }
}

class Mid extends Root {
    static {
        System.out.println("Mid的静态初始化块。");
    }

    {
        System.out.println("Mid的普通初始化块。");
    }

    public Mid() {
        System.out.println("Mid的无参构造函数。");
    }

    public Mid(String msg) {
        System.out.println("Mid的带参数构造函数，参数值为:" + msg);
    }
}

class Leaf extends Mid {
    static {
        System.out.println("Leaf的静态初始化块。");
    }

    {
        System.out.println("Leaf的普通初始化块。");
    }

    public Leaf() {
        super("Leaf传给Mid");
        System.out.println("执行Leaf的构造函数。");
    }
}

public class StaticTest {
    public static void main(String[] args) {
        new Leaf();
    }
}
