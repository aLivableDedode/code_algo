package binarysearchtree;

import utils.TreeNode;

/**
 * 二叉树的最近公共祖先
 *  给定一个二叉树, 找到该树中两个指定节点的最近公共祖先。
 *     百度百科中最近公共祖先的定义为：“对于有根树 T 的两个结点 p、q，最近公共祖先表示为一个结点 x，
 *         满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。
 *
 *     输入: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1
 *     输出: 3
 *     解释: 节点 5 和节点 1 的最近公共祖先是节点 3。
 *
 *
 *     只要看到二叉树的问题，先把这个框架写出来准没问题：
 *      traverse(TreeNode root) {
 *          // 前序遍历
 *          traverse(root.left)
 *          // 中序遍历
 *          traverse(root.right)
 *          // 后序遍历
 *      }
 *
 * @Author lvkai
 * @Description
 * @Date 2021/1/10 23:17
 **/
public class CommonAncestorProblem {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q){

        // 两种情况的 base case
        if (root == null) return null;
        if (root == p || root == q) return root;

        /**
         * 情况 1，如果p和q都在以root为根的树中，那么left和right一定分别是p和q（从 base case 看出来的）。
         *  -->因为这里是二叉树的后序遍历啊！前序遍历可以理解为是从上往下，
         *  -->而后序遍历是从下往上，就好比从p和q出发往上走，第一次相交的节点就是这个root
         *
         * 情况 2，如果p和q都不在以root为根的树中，直接返回null。
         *
         * 情况 3，如果p和q只有一个存在于root为根的树中，函数返回该节点。
         */
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        // 情况 1
        if (left != null && right != null) {
            return root;
        }
        // 情况 2
        if (left == null && right == null) {
            return null;
        }
        // 情况 3
        return left == null ? right : left;
    }

}
