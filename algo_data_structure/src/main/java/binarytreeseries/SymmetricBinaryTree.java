package binarytreeseries;

import utils.TreeNode;

/**
 * @Author lvkai
 * @Description
 * @Date 2021/1/7 22:11
 **/
public class SymmetricBinaryTree {

    public static boolean isSymmetricBinaryTree(TreeNode root){
        if(null == root || (root.left == null && root.right == null) ) return true;

        if (root.left == null || root.right == null) return false;
        return sameTree(root.left,root.right);
    }

    public static boolean sameTree(TreeNode p, TreeNode q){
        if(p==null&&q==null){
            return true;
        }else if((p==null&&q!=null)||(q==null&&p!=null)){
            return false;
        }else if (p.val == q.val){
            if (sameTree(p.left,q.right) && sameTree(p.right,q.left)){
                return true;
            }else return false;
        }else {return false;}



    }
}
