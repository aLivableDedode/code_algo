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
    }

    /**
     *  单链表反转
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


}
