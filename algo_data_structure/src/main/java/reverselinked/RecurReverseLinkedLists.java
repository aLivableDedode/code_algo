package reverselinked;

import utils.ListNode;
import utils.Utils;

/**
 *  递归反转单链表
 * @Author lvkai
 * @Description
 * @Date 2021/1/2 22:28
 **/
public class RecurReverseLinkedLists {

    public static void main(String[] args) {
        ListNode listNode = Utils.constructSingly(5);
        Utils.traverse(listNode);
        ListNode last = recurReverseLinkedLists(listNode);
        Utils.traverse(last);
        last = reverseLinkedLists(last);
        Utils.traverse(last);
    }

    /**
     *  单链表反转-递归方式
     * @param head
     * @return
     */
    public static ListNode recurReverseLinkedLists(ListNode head){
        if (head.next == null) return head;
        ListNode last = recurReverseLinkedLists(head.next);
        head.next.next = head;
        head.next = null;
        return last;
    }

    /**
     *  非递归方式: 反转以 a 为头结点的链表
     * @param a
     * @return
     */
    public static ListNode reverseLinkedLists(ListNode a){
        if (a.next == null) return a;
        ListNode pre,cur,next;
        pre = null;
        cur = a;
        next = a;
        while (cur != null) {
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }

}
