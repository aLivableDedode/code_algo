package reverselinked;

import utils.ListNode;
import utils.Utils;

/**
 *  反转链表的一部分
 *  给一个索引区间[m,n]（索引从 1 开始），仅仅反转区间中的链表元素
 * @Author lvkai
 * @Description
 * @Date 2021/1/2 22:28
 **/
public class RecurPartLinked {

    // 后驱节点 即 第N-1个节点
    public static ListNode successor = null;
    public static void main(String[] args) {
        ListNode listNode = Utils.constructSingly(10);
        Utils.traverse(listNode);
        ListNode last = reversBetween(listNode,2,6);
        Utils.traverse(last);
    }


    public static ListNode reversBetween(ListNode head,int m,int n){
        // 如果m == 1，就相当于反转链表开头的n个元素
        if (m == 1){
            return recurPreNLinked(head,n);
        }
        // 如果m != 1怎么办？如果我们把head的索引视为 1，那么我们是想从第m个元素开始反转
        // 如果把head.next的索引视为 1 呢？那么相对于head.next，反转的区间应该是从第m - 1个元素开始的；
        // 那么对于head.next.next ....
        // 递归思想
        head.next = reversBetween(head.next, m - 1, n - 1);
        return head;
    }

    /**
     *  反转以 head 为起点的 n 个节点，返回新的头结点
     * @param head
     * @param n
     * @return
     */
    public static ListNode recurPreNLinked(ListNode head,int n){

        if (n == 1) {
            successor = head.next;
            return head;
        }

        ListNode last = recurPreNLinked(head.next,n -1);
        head.next.next = head;
        head.next = successor;
        return last;

    }
    
}
