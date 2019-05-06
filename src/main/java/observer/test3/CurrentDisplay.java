package observer.test3;

/**
 * 观察者接口的具体实现
 */
public class CurrentDisplay implements Observer {
    private float w;
    private float s;
    private Subject wd;

    public CurrentDisplay(Subject wd) {
        this.wd = wd;
        wd.add(this);
    }

    @Override
    public void updata(float w, float s, float p) {
        this.w = w;
        this.s = s;
        display();
    }

    public void display() {
        System.out.println("w= " + w + "s= " + s);
    }
}
