package binarysearchtree;

import utils.TreeNode;

/**
 *  在 BST 中插入一个数
 * @Author lvkai
 * @Description
 * @Date 2021/1/10 22:21
 **/
public class InsertXBST {

    public TreeNode insertXBST(TreeNode root,int target){
        if (root == null) return new TreeNode((target));

        if (target > root.val) return insertXBST(root.left,target);

        return insertXBST(root.right, target);

    }
}
