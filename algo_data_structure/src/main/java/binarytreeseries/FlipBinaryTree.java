package binarytreeseries;

import utils.TreeNode;
import utils.Utils;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * 翻转二叉树
 * @Author lvkai
 * @Description
 * @Date 2021/1/5 23:19
 **/
public class FlipBinaryTree {

    public static void main(String[] args) {

        LinkedList<Integer> linkedList = new LinkedList<>(
                Arrays.asList(new Integer[]{3, 2, 9, null, null, 10, null, null, 8, null, 4}));
        TreeNode treeNode = Utils.constrBinaryTree(linkedList);
        Utils.preorderTraversal(treeNode);
        treeNode = flipBinaryTree(treeNode);
        Utils.preorderTraversal(treeNode);
    }

    public static TreeNode flipBinaryTree(TreeNode root){
        if (root == null) return root;

        TreeNode tmp = root.left;
        root.left = root.right;
        root.right = tmp;

        flipBinaryTree(root.left);
        flipBinaryTree(root.right);

        return root;

    }
}
