package observer.test3;

import java.util.ArrayList;
import java.util.List;

/**
 * 被观察者具体实现
 */
public class WeatherData implements Subject {
    private List<Object> list;
    private float w;
    private float s;
    private float p;

    public WeatherData() {
        list = new ArrayList<Object>();
    }

    @Override
    public void add(Observer o) {
        list.add(o);
    }

    @Override
    public void del(Observer o) {
        int i = list.indexOf(o);
        if (i >= 0) {
            list.remove(i);
        }
    }

    @Override
    public void call() {
        for (int i = 0; i < list.size(); i++) {
            Observer obs = (Observer) list.get(i);
            obs.updata(w, s, p);
        }
    }

    public void setTemp(float w, float s, float p) {
        this.w = w;
        this.s = s;
        this.p = p;
        call();
    }
}
