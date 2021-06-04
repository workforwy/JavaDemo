package data_structure;

/**
 * @author wangyong
 */
public class TQueue<T> {
    /**
     * 头结点
     */
    private Node front;
    /**
     * 尾结点
     */
    private Node tail;
    /**
     * 队列中元素的个数
     */
    private int size;

    class Node {
        //下一个结点
        private Node next;
        //结点的数据
        private T t;

        public Node(T t) {
            this.t = t;
        }

        public T getT() {
            return t;
        }

        public void setT(T t) {
            this.t = t;
        }
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public TQueue() {
        front = tail = null;
    }

    /**
     * 入队
     */
    public void put(T t) {
        Node node = new Node(t);
        if (size == 0) {
            front = tail = node;
            size++;
            return;
        }
        Node lastNode = front;
        while (lastNode.next != null) {
            lastNode = lastNode.next;
        }
        lastNode.next = node;
        tail = node;
        size++;
    }

    /**
     * 出队
     */
    public T pop() {
        if (size == 0) {
            System.out.println("队列中无值");
            return null;
        }
        T t = front.getT();
        front = front.next;
        size--;
        return t;
    }

    public static void main(String[] args) {
        TQueue<String> tQueue = new TQueue<>();
        tQueue.put("Hello1");
        tQueue.put("Hello2");
        tQueue.put("Hello3");
        for (int i = 0; i < tQueue.getSize(); i++) {
            System.out.println(tQueue.pop());
        }
    }
}
