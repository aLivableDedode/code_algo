package binarysearchtree;

import sun.reflect.generics.tree.Tree;
import utils.TreeNode;

/**
 *  给定一个二叉搜索树，编写一个函数 binarysearchtree.kthSmallest 来查找其中第 k 个最小的元素
 * @Author lvkai
 * @Description
 * @Date 2021/1/9 0:06
 **/
public class kthSmallest {

    public static int res = 0;

    // 排名
    public static int rank = 0;

    public static void main(String[] args) {

    }

    public int kthSmallest(TreeNode root, int k) {
        kthSmallestV1(root,k);
        return res;
    }

    public static void kthSmallestV1(TreeNode treeNode,int k){
        if (treeNode == null) {
            return;
        }
        kthSmallestV1(treeNode.left,k);
        // 中序遍历 递增
        rank++;
        if (rank == k){
            res = treeNode.val;
            return;
        }
        kthSmallestV1(treeNode.right,k);
    }
}
