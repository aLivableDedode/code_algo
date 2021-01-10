package binarysearchtree;

import utils.TreeNode;

/**
 *  完全二叉树的节点数
 * @Author lvkai
 * @Description
 * @Date 2021/1/10 23:38
 **/
public class NumsNodeCompeletBinTree {

    public int countNodes(TreeNode root) {
        if (root == null) return 0;
        int hl = 0, hr = 0;
        TreeNode l = root, r = root;
        while (root.left!=null){
            l = root.left;
            hl++;
        }

        while (root.right != null) {
            r = root.right;
            hr++;
        }

        if (hl == hr ) {
            // 如果左右子树的高度相同，则是一棵满二叉树
            return (int)Math.pow(2, hl) - 1;
        }

        return 1 + countNodes(root.left) + countNodes(root.right);
    }

    public int countNodesV2(TreeNode root) {
        if(root == null){
            return 0;
        }
        int left = countLevel(root.left);
        int right = countLevel(root.right);
        if(left == right){
            return countNodesV2(root.right) + (1<<left);
        }else{
            return countNodesV2(root.left) + (1<<right);
        }
    }
    private int countLevel(TreeNode root){
        int level = 0;
        while(root != null){
            level++;
            root = root.left;
        }
        return level;
    }


}
