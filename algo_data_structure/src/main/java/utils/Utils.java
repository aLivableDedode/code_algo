package utils;

import com.sun.org.apache.bcel.internal.generic.RET;

import java.util.*;
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
        System.out.println(sequencTraversal(treeNode));
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

    /**
     *  层序遍历
     * @param treeNode
     * @return
     */
    public static LinkedList sequencTraversal(TreeNode treeNode){
        if (treeNode == null) {
            return null;
        }
        LinkedList nodeVals = new LinkedList();
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(treeNode);
        while (!queue.isEmpty()){
            TreeNode node = queue.poll();
            nodeVals.add(node.val);
            if (null != node.left) queue.offer(node.left);
            if (null != node.right) queue.offer(node.right);
        }
        return nodeVals;
    }

    /**
     *  最大深度
     * @param treeNode
     * @return
     */
    public static int maxDepthTreeV1(TreeNode treeNode) {
        if (treeNode == null) {
            return 0;
        }else {
            return Math.max(maxDepthTreeV1(treeNode.left),maxDepthTreeV1(treeNode.right)) + 1;
        }

    }

    /**
     *  最大深度
     * @param treeNode
     * @return
     */
    public static int maxDepthTreeV2(TreeNode treeNode){
        if (treeNode == null) {
            return 0;
        }
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(treeNode);
        int res =0;
        while (!queue.isEmpty()){
            int size = queue.size();
            while (size > 0){
                TreeNode node = queue.poll();
                if (null != node.left) queue.offer(node.left);
                if (null != node.right) queue.offer(node.right);
                size --;
            }

            res++;
        }
        return res;
    }

    /**
     *  二叉树的层序遍历 II
     *  给定一个二叉树，返回其节点值自底向上的层序遍历。 （即按从叶子节点所在层到根节点所在的层，逐层从左向右遍历）
     * @param treeNode
     * @return
     */
    public static LinkedList reverseSequencTraversal(TreeNode treeNode){
        if (treeNode == null) {
            return null;
        }
        LinkedList nodeVals = new LinkedList();
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(treeNode);
        while (!queue.isEmpty()){
            TreeNode node = queue.poll();
            nodeVals.add(node.val);
            if (null != node.left) queue.offer(node.left);
            if (null != node.right) queue.offer(node.right);
        }
        return nodeVals;
    }
}
