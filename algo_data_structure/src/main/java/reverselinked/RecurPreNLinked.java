package reverselinked;

import utils.ListNode;
import utils.Utils;

/**
 *  二、反转链表前 N 个节点
 * @Author lvkai
 * @Description
 * @Date 2021/1/2 22:28
 **/
public class RecurPreNLinked {

    // 后驱节点 即 第N-1个节点
    public static ListNode successor = null;

    public static void main(String[] args) {
        ListNode listNode = Utils.constructSingly(6);
        Utils.traverse(listNode);
        ListNode last = recurPreNLinked(listNode,3);
        Utils.traverse(last);
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
