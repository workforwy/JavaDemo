package data_structure;

/**
 * @author wangyong
 */
public class TLinkedList<T> {
    /**
     * 链表头部
     */
    private Node head;
    /**
     * 链表元素的个数
     */
    private int size;

    public TLinkedList() {
        head = null;
        size = 0;
    }

    /**
     * 将结点作为内部类。也可以新建一个Node类，作为结点
     */
    class Node {
        private Node next;//下一个结点
        private T t;//结点的数据

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

    /**
     * 在链表头部添加一个结点
     */
    public void addFirst(T t) {
        Node node = new Node(t);
        node.next = head;
        head = node;
        size++;
    }

    /**
     * 在链表中间添加一个结点
     */

    public void addMid(T t, int index) {
        Node node = new Node(t);
        Node mid = head;
        for (int i = 0; i < index - 1; i++) {
            mid = mid.next;
        }
        node.next = mid.next;
        mid.next = node;
        size++;
    }

    /**
     * 在链表尾部添加一个结点
     */

    public void addLast(T t) {
        Node node = new Node(t);
        Node last = head;
        while (last.next != null) {
            last = last.next;
        }
        last.next = node;
        node.next = null;
        size++;
    }

    /**
     * 删除链表的头结点
     */

    public void removeFirst() {
        head = head.next;
        size--;
    }

    /**
     * 删除链表的中间元素
     */

    public void removeMid(int index) {
        Node mid = head;
        if (index == 0) {
            removeFirst();
            return;
        }
        int j = 0;
        Node qMid = head;
        while (j < index) {
            qMid = mid;
            mid = mid.next;
            j++;
        }
        qMid.next = mid.next;
        size--;
    }

    /**
     * 删除链表的尾结点
     */

    public void removeLast() {
        Node mid = head;
        Node qMid = head;
        while (mid.next != null) {
            qMid = mid;
            mid = mid.next;
        }
        qMid.next = null;
        size--;
    }

    /**
     * 获取链表指定下标的结点
     */

    public Node get(int index) {
        Node mid = head;
        if (index == 0) {
            return head;
        }
        int j = 0;
        while (j < index) {
            mid = mid.next;
            j++;
        }
        return mid;
    }

    public static void main(String[] args) {
        TLinkedList<String> linkedList = new TLinkedList<>();
        linkedList.addFirst("hello1");
        linkedList.addFirst("hello2");
        linkedList.addFirst("hello3");
        for (int i = 0; i < linkedList.size; i++) {
            System.out.println(linkedList.get(i).getT());
        }
//        linkedList.removeLast();
//        linkedList.removeFirst();
//        linkedList.addLast("hello4");
        linkedList.addMid("hello", 2);
        System.out.println("--------------");
        for (int i = 0; i < linkedList.size; i++) {
            System.out.println(linkedList.get(i).getT());
        }
    }
}

