package data_structure;

public class TStack<T> {
    /**
     * 栈的头结点
     */
    private Node head;
    /**
     * 栈的元素个数
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

    public TStack() {
        head = null;
        size = 0;
    }

    /**
     * 入栈
     */
    public void push(T t) {
        Node node = new Node(t);
        if (size == 0) {
            node.next = head;
            head = node;
            size++;
            return;
        }
        if (size == 1) {
            head.next = node;
            node.next = null;
            size++;
            return;
        }
        Node lastNode = head;
        while (lastNode.next != null) {
            lastNode = lastNode.next;
        }
        lastNode.next = node;
        node.next = null;
        size++;
    }

    /**
     * 出栈
     */
    public T pop() {
        if (size == 0) {
            System.out.println("栈内无值");
            return null;
        }
        if (size == 1) {
            T t = head.getT();
            head = null;
            size--;
            return t;
        }
        Node lastNode = head;
        Node qNode = head;
        while (lastNode.next != null) {
            qNode = lastNode;
            lastNode = lastNode.next;
        }
        T t = lastNode.getT();
        qNode.next = null;
        size--;
        return t;
    }

    /**
     * 获取栈里面元素的个数
     */
    public int getSize() {
        return size;
    }

    /**
     * 返回栈顶元素
     */
    public T peek() {
        if (size == 0) {
            System.out.println("栈内无值");
            return null;
        }
        if (size == 1) {
            return head.getT();
        }
        Node lastNode = head;
        while (lastNode.next != null) {
            lastNode = lastNode.next;
        }
        return lastNode.getT();
    }

    public static void main(String[] args) {
        TStack<String> TStack = new TStack<>();
        TStack.push("hello1");
        TStack.push("hello2");
        TStack.push("hello3");
        for (int i = 0; i < 3; i++) {
            System.out.println(TStack.pop());
        }
    }
}
