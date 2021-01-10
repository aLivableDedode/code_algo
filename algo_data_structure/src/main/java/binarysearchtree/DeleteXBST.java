package binarysearchtree;

import utils.TreeNode;

/**
 *  在 BST 中删除一个数
 *      情况 1：A恰好是末端节点，两个子节点都为空，那么它可以当场去世了。
 *      情况 2：A只有一个非空子节点，那么它要让这个孩子接替自己的位置。
 *      情况 3：A有两个子节点，麻烦了，为了不破坏 BST 的性质，
 *          A必须找到左子树中最大的那个节点，或者右子树中最小的那个节点来接替自己。
 * @Author lvkai
 * @Description
 * @Date 2021/1/10 22:21
 **/
public class DeleteXBST {

    public TreeNode deleteXBST(TreeNode root,int target){
        if (root == null) return null;
        if (root.val == target) {
            // 情况 1：A恰好是末端节点，两个子节点都为空
            //if (root.left == null && root.right == null) return null;
            // 情况 2：A只有一个非空子节点，那么它要让这个孩子接替自己的位置
            if (root.left == null) return root.right;
            if (root.right == null) return root.left;

            // 情况 3：A有两个子节点，麻烦了，为了不破坏 BST 的性质，
            // A必须找到左子树中最大的那个节点，或者右子树中最小的那个节点来接替自己
            TreeNode min = getMin(root.right);
            root.val = min.val;
            root.right = deleteXBST(root.right,min.val);
        }else if (target > root.val) {
            root.right = deleteXBST(root.right,target);
        }else{
            root.left = deleteXBST(root.left, target);
        }
        return root;
    }

    public TreeNode getMin(TreeNode node){
        // BST最左边就是最小的
        while (null != node.left ){
            node = node.left ;
        }
        return node;
    }
}
