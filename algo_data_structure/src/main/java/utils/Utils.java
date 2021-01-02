package utils;

import java.util.Random;

/**
 * @Author lvkai
 * @Description
 * @Date 2021/1/2 22:53
 **/
public class Utils {
    public static void main(String[] args) {
        traverse(constructSingly(4));
    }

    public static ListNode constructSingly(int size){
        if (size == 0 ) return null;
        int nextInt = new Random().nextInt(50);
        ListNode head = new ListNode(nextInt);
        ListNode last = head;

        for (int i = 1; i < size; i++) {
            nextInt = new Random().nextInt(50);
            ListNode next = new ListNode(nextInt);
            last.next = next;
            last = next;
        }
        return head;
    }

    public static void traverse(ListNode head){
        if (head == null) {
            System.out.println();
            return;
        }
        System.out.print(head.val+"-->");
        traverse(head.next);
    }
}
