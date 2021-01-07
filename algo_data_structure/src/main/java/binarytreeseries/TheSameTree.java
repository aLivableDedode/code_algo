package binarytreeseries;

import utils.TreeNode;

/**
 * @Author lvkai
 * @Description
 * @Date 2021/1/7 22:11
 **/
public class TheSameTree {

    public static boolean sameTree(TreeNode p, TreeNode q){
        if(p==null&&q==null){
            return true;
        }else if((p==null&&q!=null)||(q==null&&p!=null)){
            return false;
        }else if (p.val == q.val){
            if (sameTree(p.left,q.left) && sameTree(p.right,q.right)){
                return true;
            }else return false;
        }else {return false;}



    }
}
