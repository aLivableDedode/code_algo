package utils;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Random;
import java.util.stream.Collectors;

/**
 * @Author lvkai
 * @Description
 * @Date 2021/1/2 22:53
 **/
public class Utils {
    public static void main(String[] args) {
//        traverse(constructSingly(4));
        LinkedList<Integer> linkedList = new LinkedList<>(
                Arrays.asList(new Integer[]{3, 2, 9, null, null, 10, null, null, 8, null, 4}));
        TreeNode treeNode = constrBinaryTree(linkedList);
        System.out.println(treeNode);
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

    public static TreeNode constrBinaryTree(LinkedList<Integer> nodes){
        TreeNode root = null;
        if (nodes == null || nodes.isEmpty()) {
            return null;
        }
        Integer data = nodes.removeFirst();

        if (null != data){
            root = new TreeNode(data);
            root.left = constrBinaryTree(nodes);
            root.right = constrBinaryTree(nodes);
        }
        return root;
    }

    public static void preorderTraversal(TreeNode treeNode){
        if (treeNode == null) {
            return;
        }

        System.out.println(treeNode.val);
        preorderTraversal(treeNode.left);
        preorderTraversal(treeNode.right);
    }


}
