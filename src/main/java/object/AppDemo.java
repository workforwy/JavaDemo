package object;

/**
 * 画笔对象
 */
class Paint {
    int color;
}

/**
 * 画布对象
 */
class Canvas {
    public void drawCircle(int x, int y, int r, Paint p) {
        System.out.println("画一个圆!");
    }

    public void drawLine() {
    }
    // ......
}

class View {
    int width = 100;
    int height = 100;
    Paint p = new Paint();

    public void onDraw(Canvas canvas) {
        canvas.drawCircle(width / 2, height / 2, 10, p);
    }

    public void setText(String qText) {

    }
}

/**
 * 理解为手机屏幕窗口
 */
class PhoneWindow {
    View[] views = new View[10];
    int size;

    public void add(View v) {
        views[size++] = v;
    }

}

class Activity {
    // 属性(对象构建时初始化)
    PhoneWindow window = new PhoneWindow();

    public void setContentView(View view) {
        window.add(view);
    }
}

public class AppDemo {
    public void start() {
        Activity aty = new Activity();
        View v01 = new View();
        aty.setContentView(v01);
    }

    public static void main(String[] args) {
        AppDemo app = new AppDemo();
        app.start();
    }
}
