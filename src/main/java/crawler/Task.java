package crawler;

public class Task {

    private String info;

    private void setInfo(String info) {
        this.info = info;
    }

    public void call() {
        Crawler.getInstance().crawl(new Handler() {
            @Override
            public void handle(String info) {
                setInfo(info);
            }
        });
    }

    public static void main(String[] args) {
        new Task().call();
    }
}

