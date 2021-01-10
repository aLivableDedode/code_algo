package binarysearchtree;

import utils.TreeNode;

/**
 *  判断BST的合法性
 *      对于每一个节点root，代码值检查了它的左右孩子节点是否符合左小右大的原则；
 *       ---》但是根据 BST 的定义，root的整个左子树都要小于root.val，整个右子树都要大于root.val 《 ---
 * @Author lvkai
 * @Description
 * @Date 2021/1/10 21:37
 **/
public class JudgingBSTLegal {


    public boolean isValidBST(TreeNode root){
        return isValidBST(root, null, null);
    }

    /**
     * 限定以 root 为根的子树节点必须满足 max.val > root.val > min.val
     * @return
     */
    public boolean isValidBST(TreeNode root,TreeNode min,TreeNode max){

        if (root == null) {
            return true;
        }

        if (null != max && max.val <= root.val) {
            return false;
        }
        if (null != min && min.val >= root.val) {
            return false;
        }


        // root的整个左子树都要小于root.val，整个右子树都要大于root.val
        return isValidBST(root.left, min, root)
                && isValidBST(root.right, root, max);
    }
}
