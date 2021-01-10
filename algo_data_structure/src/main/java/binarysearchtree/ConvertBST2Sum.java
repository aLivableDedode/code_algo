package binarysearchtree;

import utils.TreeNode;

/**
 *  BST 转化累加树
 * @Author lvkai
 * @Description
 * @Date 2021/1/10 19:10
 **/
public class ConvertBST2Sum {

    public static int sum = 0;

    public static void main(String[] args) {

    }

    /**
     *  正常中序遍历是升序的
     *      --》 那么反过来
     * @param treeNode
     * @return
     */
    public static void convertBST2Sum(TreeNode treeNode){
        if (null == treeNode) {
            return ;
        }
        convertBST2Sum(treeNode.right);
        sum += treeNode.val;
        treeNode.val = sum;
        convertBST2Sum(treeNode.left);
    }


}
