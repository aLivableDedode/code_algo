package reverselinked;

import utils.ListNode;
import utils.Utils;

/**
 *  递归思维：k 个一组反转链表
 * @Author lvkai
 * @Description
 * @Date 2021/1/2 22:28
 **/
public class ReverseKGroup {

    public static void main(String[] args) {
        ListNode listNode = Utils.constructSingly(7);
        Utils.traverse(listNode);
        ListNode last = reverseKGroup(listNode,2);
        Utils.traverse(last);
    }

    /**
     *  非递归方式: 反转以 a 为头结点的链表
     * @param a
     * @return
     */
    public static ListNode reverseLinkedListsV1(ListNode a){
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


    /**
     *  反转区间 [a, b) 的元素，注意是左闭右开
     * @param a
     * @param b
     * @return
     */
    public static ListNode reverseLinkedListsV2(ListNode a,ListNode b){
        ListNode pre,cur,next;
        pre = null;
        cur = a;
        next = a;
        while (b!=cur){
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }

    public static ListNode reverseKGroup(ListNode head,int k){
        if (head == null) return head;

        // 找到子集的反转区间 [a, b)
        ListNode a,b;
        a = b = head;
        for (int i = 0; i < k; i++) {
            // 如果最后的不足区间不足k个元素,那么上次的结果时b = b.next = null
            if (b == null) return head;

            // 通过.next.next... 找到右区间
            b = b.next;
        }

        // 反转[a,b)区间  --> 得到反转后的链表
        ListNode newHead = reverseLinkedListsV2(a, b);

        // 处理子问题
        ListNode subListNode = reverseKGroup(b, k);
        // 反转后的时a为尾节点
        a.next = subListNode;
        return newHead;
    }
}
