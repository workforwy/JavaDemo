package enums;

/**
 * 定义 RSS(Really Simple Syndication) 种子的枚举类型
 */
public enum NewsRSSFeed {

    // 雅虎头条新闻 RSS 种子
    YAHOO_TOP_STORIES("<a href=http://rss.news.yahoo.com/rss/topstories></a>"),

    //CBS 头条新闻 RSS 种子
    CBS_TOP_STORIES("<a href=http://feeds.cbsnews.com/CBSNewsMain?format=xml></a>"),

    // 洛杉矶时报头条新闻 RSS 种子
    LATIMES_TOP_STORIES("<a href=http://feeds.latimes.com/latimes/news?format=xml></a>");

    // 枚举对象的 RSS 地址的属性
    private String rss_url;

    // 枚举对象构造函数
    NewsRSSFeed(String rss) {
        this.rss_url = rss;
    }

    // 枚举对象获取 RSS 地址的方法
    public String getRssURL() {
        return this.rss_url;
    }
}
