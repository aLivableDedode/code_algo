package binarytreeseries;

import utils.TreeNode;

/**
 * 翻转二叉树
 * @Author lvkai
 * @Description
 * @Date 2021/1/5 23:19
 **/
public class FlipBinaryTree {

    public static void main(String[] args) {

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
