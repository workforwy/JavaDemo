package staticfinal;

class Container {

    public void add(Object obj) {

    }
}

/**
 * 此类在类加载时读取文件，并将文件中的 内容通过Container对象的add方法保存起来
 */
class ContainerService {

    private static ContainerService cs = new ContainerService();
    private static Container c = new Container();

    private ContainerService() {
        loadDataFromFile();
    }

    private void loadDataFromFile() {
        // 假设此数据为读到的数据
        String data = "data";
        c.add(data);// 错,NullPointerException
    }

    public static void doMethod() {
        System.out.println("doMethod");
    }
}

public class StaticDemo3 {
    public static void main(String[] args) {
        ContainerService.doMethod();

    }
}
