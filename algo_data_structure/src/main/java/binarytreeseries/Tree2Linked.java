package binarytreeseries;

import utils.TreeNode;
import utils.Utils;

import java.util.Arrays;
import java.util.LinkedList;

/**
 *  将二叉树展开为链表
 * @Author lvkai
 * @Description
 * @Date 2021/1/7 23:02
 **/
public class Tree2Linked {

    public static void main(String[] args) {
        LinkedList<Integer> linkedList = new LinkedList<>(
                Arrays.asList(new Integer[]{3, 2, 9, null, null, 10, null, null, 8, null, 4}));
        TreeNode treeNode = Utils.constrBinaryTree(linkedList);
        TreeNode tree2Linked = tree2Linked(treeNode);
        Utils.preorderTraversal(tree2Linked);
    }

    public static TreeNode tree2Linked(TreeNode treeNode){
        if (null == treeNode) return null;

        // 递归左右子树
        tree2Linked(treeNode.left);
        tree2Linked(treeNode.right);

        // 后序遍历处理拉平
        TreeNode left = treeNode.left;
        TreeNode right = treeNode.right;

        //左边子树放大右边下面
        treeNode.left = null;
        treeNode.right = left;

        // 将原来的右子树拼到当前右子树的下面
        TreeNode p = treeNode;
        while (p.right!=null){
            //找到最后一个节点
            p = p.right;
        }
        p.right = right;

        return treeNode;
    }
}
