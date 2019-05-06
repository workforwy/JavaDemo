package observer.test3;

public class Test {
    public static void main(String[] args) {
        WeatherData s = new WeatherData();
        Observer o = new CurrentDisplay(s);
        s.setTemp(30.0f, 0.8f, 100.0f);
    }
}
