package object;

class Point {
    /**
     * 在构建对象时会对对象进行默认初始化， 初始化顺序从上到下，默认值由类型决定
     */
    int x;
    int y;

    // x=20;不允许在此位置赋值
    {
        x = 10;
    }// 此代码块在构建对象时执行(用的很少)

    public Point(int x) {
        System.out.println(this);
        this.x = x;
    }

    public Point(int x, int y) {
        this(x);
        this.y = y;
        System.out.println(this);
    }

    /**
     * 求两点的距离
     */
    public double distance(Point p) {
        /*
         * int x=this.x-p.x; int y=this.y-p.y; return Math.sqrt(x*x+y*y);
         */
        // return this.distance(p.x,p.y);
        return distance(p.x, p.y);
    }

    public double distance(int x1, int y1) {
        int x = this.x - x1;
        int y = this.y - y1;
        return Math.sqrt(x * x + y * y);
    }
}

public class PointDemo {
    public static void main(String[] args) {
        Point p1 = new Point(1, 2);
        Point p2 = new Point(3, 5);
        double dis = p2.distance(p1);
        System.out.println(dis);

    }
}

