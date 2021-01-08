package binarytreeseries;

import utils.TreeNode;

/**
 *  最大二叉树
 *
 * 给定一个不含重复元素的整数数组 nums 。一个以此数组直接递归构建的 最大二叉树 定义如下：
 *
 * 二叉树的根是数组 nums 中的最大元素。
 * 左子树是通过数组中 最大值左边部分 递归构造出的最大二叉树。
 * 右子树是通过数组中 最大值右边部分 递归构造出的最大二叉树。
 * 返回有给定数组 nums 构建的 最大二叉树 。
 *
 * 示例 1：输入：nums = [3,2,1,6,0,5]
 *        输出：[6,3,5,null,2,0,null,null,1]
 *
 *
 *  -->>> 找到最大值、下标x
 *  -->>> 分成2段 (0,n) --> (0,x),(x,n)  --> 逻辑递归
 */
public class ConstLargestBinTree {
    public static void main(String[] args) {
        constrlargestBinTree(new int[]{3,2,1,6,0,5});
    }

    public static TreeNode constrlargestBinTree(int[] nums){
        return build(nums,0,nums.length-1);
    }

    public static TreeNode build(int[] nums ,int lo,int hi){
        // base case
        if (lo > hi) {
            return null;
        }
        // 找到数组中的最大值和对应的索引
        int index = -1, maxVal = Integer.MIN_VALUE;
        for (int i = lo; i <= hi; i++) {
            if (maxVal < nums[i]) {
                index = i;
                maxVal = nums[i];
            }
        }
        // 根节点
        TreeNode treeNode = new TreeNode(maxVal);
        treeNode.left = build(nums,lo,index);
        treeNode.right = build(nums,index,hi);
        return treeNode;

    }
}
