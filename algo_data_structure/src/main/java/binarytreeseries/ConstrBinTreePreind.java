package binarytreeseries;

import utils.TreeNode;

/**
 *  从前序与中序遍历序列构造二叉树
 *          例如，给出前序遍历 preorder = [3,9,20,15,7]
 *                 中序遍历 inorder = [9,3,15,20,7]
 *
 *   前序遍历:
 *      preorder.add(root.val)
 *      travel(root.left)
 *      travel(root.right)
 *   --> 可以知道preorder的大体结构是[root.val,左子树，右子树]
 *   中序遍历:
 *      travel(root.left)
 *      inorder.add(root.val)
 *      travel(root.right)
 *   --> 可以知道inorder的大体结构是[左子树，root.val，右子树]
 *
 *   --》那么先构建根节点
 *      --》 左子树：preorder [root.val下标 + 1,左子树，右子树] inorder [左子树，root.val下标 -1]
 *          --》 右子树：preorder [root.val下标 + 1,左子树，右子树] inorder [root.val下标 + 1，右子树]
 *      --》 然后递归上面的逻辑
 */
public class ConstrBinTreePreind {

    public static void main(String[] args) {
        buildTree(new int[]{3,9,20,15,7},new int[]{9,3,15,20,7});
    }

    public static TreeNode buildTree(int[] preorder, int[] inorder) {
        return build(preorder,0,preorder.length -1,
                inorder,0,inorder.length -1);
    }

    public static TreeNode build(int[] preorder ,int preStart,int preEnd,
                                              int[] inorder,int inorStart,int inoEnd ){

        if (preStart > preEnd) {
            return null;
        }

        // 根节点
        int rootVal = preorder[preStart];
        int index = 0;
        for (int i = inorStart; i <= inoEnd; i++) {
            if (rootVal == inorder[i]){
                index = i;
                break;
            }
        }

        // 找到左子树的区间大小 --> 限制前序/后续数组的长度
        int leftSize = index - inorStart;

        TreeNode root = new TreeNode(rootVal);

        root.left = build(preorder,preStart + 1,preStart + leftSize,
                            inorder, inorStart,index -1 );
        root.right = build(preorder,preStart + leftSize + 1,preEnd,
                            inorder,index + 1,inoEnd);
        return root;

    }


}
