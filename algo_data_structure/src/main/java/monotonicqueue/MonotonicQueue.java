package monotonicqueue;

import java.util.LinkedList;

/**
 *  实现「单调队列」必须使用一种数据结构支持在头部和尾部进行插入和删除，
 *  很明显双链表是满足这个条件的
 *
 *  1.在队尾添加元素，并且把之前小于自己的元素删除
 *  2.在队头删除删除元素
 */
public class MonotonicQueue {
    private LinkedList<Integer> q  = new LinkedList<>();

    /**
     *  在队尾添加元素，但是要把前面比自己小的元素都删掉
     * @param n
     */
    public void push(int n){
        while (!q.isEmpty() && q.getLast() < n) {
            q.pollLast();
        }
        q.addLast(n);
    }

    public Integer max(){
        return q.getFirst();
    }

}
