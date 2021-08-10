package object;


/**
 * 大象类型
 */
class Elephant {
    /**
     * 名字
     */
    String name;
    /**
     * 出生日期
     */
    String birthday;

    /**
     * 构造方法
     */
    public Elephant(String ename, String ebirthday) {
        name = ename;
        birthday = ebirthday;
    }

    public void doSay() {
        System.out.println("好冷啊!");
    }
}

/**
 * 冰箱类型
 */
class IceBox {
    /**
     * 序号
     */
    int sn;
    /**
     * 品牌
     */
    String brand;

    Elephant[] elephants;
    /**
     * 冰箱中大象个数
     */
    int size;

    /**
     * 构造方法作用：对实例变量(没有static修饰) 进行初始化赋值
     */
    public IceBox(int isn, String ibrand) {
        sn = isn;
        brand = ibrand;
        elephants = new Elephant[5];
    }

    public void open() {
        System.out.println("打开冰箱门");
    }

    /**
     * 将大象放冰箱
     */
    public void put(Elephant e) {
        if (elephants.length == size)
            return;
        elephants[size] = e;
        e.doSay();
        size++;
        System.out.println("大象已放入冰箱");
    }

    public void close() {
        System.out.println("关闭冰箱门");
    }

    /**
     * 根据位置获得大象
     */
    public Elephant get(int pos) {
        if (pos < 0 || pos >= size) {
            return null;
        }
        return elephants[pos];
    }
}

/**
 * 将大象放冰箱
 */
public class AnimalDemo {
    public static void main(String[] args) {
        // 1.构建大象类型的对象
        Elephant e01 = new Elephant("EA01", "1999-09-11");
        Elephant e02 = new Elephant("EA02", "1999-10-11");
        // 2.构建冰箱对象
        IceBox box = new IceBox(1001, "西门子");
        // 3.将大象放冰箱
        box.open();
        box.put(e01);
        box.put(e02);
        box.close();
    }
}

