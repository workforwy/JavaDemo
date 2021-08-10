import java.util.Optional;

public class KeysDemo {
    public static void main(String[] args) {
        testOptional();
    }

    private static void testOptional() {
        String name = null;
        Optional<String> opt = Optional.ofNullable(name);
        System.out.println(opt.get());
    }

    private void testFor() {
        label:
        for (int j = 1; j <= 2; j++) {
            System.out.println("第" + j + "次外层循环");
            for (int i = 1; i <= 10; i++) {
                if (i == 5)
//					return; // 退出所有循环
//					continue; // 只跳过本层循环本次循环，继续本层下一次循环
//					continue label;// 跳过本层循环本次循环，继续执行上层下一次循环
                    break; // 退出本层循环
                System.out.println(i);
            }
        }
    }
}
