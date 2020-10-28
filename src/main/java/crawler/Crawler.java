package crawler;

public class Crawler {
    private static Crawler instance = null;

    public static Crawler getInstance() {
        if (instance == null) {
            instance = new Crawler();
        }
        return instance;
    }

    private String getInfo() {
        return "the info from crawler";
    }

    public void crawl(Handler handler) {
        handler.handle(getInfo());
    }
}
