package binarysearchtree;

import utils.TreeNode;

/**
 *  在 BST 中搜索一个数
 * @Author lvkai
 * @Description
 * @Date 2021/1/10 22:21
 **/
public class FindXBST {

    public boolean findXInBST(TreeNode root,int target){
        if (root == null) return false;
        if (root.val == target) return true;

        if (target > root.val) return findXInBST(root.left,target);

        return findXInBST(root.right, target);

    }
}
