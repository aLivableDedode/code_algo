package lru;

public class DoubleList {

    // 头尾虚节点
    private Node head, tail;

    // 链表元素数
    private int size;

    public DoubleList(){
        // 初始化双向链表的数据
        head = new Node(0,0);
        tail = new Node(0,0);
        head.next = tail;
        tail.prev = head;
        size = 0;
    }

    /**
     * 加入尾部
     * @param x
     */
    public void addLast(Node x){

        // 去掉前驱指向
        x.prev = tail.prev;
        x.next = tail;

        // 去掉后驱指向
        tail.prev.next = x;
        tail.next = x;
        size++;
    }

    /**
     *   删除链表中的 x 节点（x 一定存在）
     *   由于是双链表且给的是目标 Node 节点，时间 O(1)
     * @param x
     */
    public void remove(Node x){
        // 去掉前驱指向
        x.prev.next =x.next;
        // 去掉后驱指向
        x.next.prev = x.prev;
        size--;
    }

    /**
     *   删除链表中第一个节点，并返回该节点，时间 O(1)
     */
    public Node removeFirst(){
        if (head.next == tail)
            return null;

        Node node = head.next;
        remove(node);
        return node;
    }

    // 返回链表长度，时间 O(1)
    public int size() { return size; }



}
