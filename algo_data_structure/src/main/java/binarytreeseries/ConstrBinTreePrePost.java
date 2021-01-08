package binarytreeseries;

import utils.TreeNode;

/**
 *  从中序与后序遍历序列构造二叉树
 *          例如，中序遍历 inorder = [9,3,15,20,7]
 *              后序遍历 postorder = [9,15,7,20,3]
 *
 *   后续序遍历:
 *      travel(root.left)
 *      travel(root.right)
 *      preorder.add(root.val)
 *   --> 可以知道preorder的大体结构是[左子树，右子树,root.val]
 *   中序遍历:
 *      travel(root.left)
 *      inorder.add(root.val)
 *      travel(root.right)
 *   --> 可以知道inorder的大体结构是[左子树，root.val，右子树]
 *
 *   --》那么先构建根节点
 *      --》 左子树：postorder [左子树，右子树,root.val下标] inorder [左子树，root.val下标 -1]
 *          --》 右子树：postorder [左子树，右子树,root.val下标] inorder [root.val下标 + 1，右子树]
 *      --》 然后递归上面的逻辑
 */
public class ConstrBinTreePrePost {

    public static void main(String[] args) {
        buildTree(new int[]{9,15,7,20,3},new int[]{9,3,15,20,7});
    }

    public static TreeNode buildTree(int[] postorder, int[] inorder) {
        return build(postorder,0,postorder.length -1,
                inorder,0,inorder.length -1);
    }

    public static TreeNode build(int[] postorder ,int posStart,int posEnd,
                                              int[] inorder,int inorStart,int inoEnd ){

        if (posStart > posEnd) {
            return null;
        }

        // 根节点
        int rootVal = postorder[posEnd];
        int index = 0;
        for (int i = inorStart; i <= inoEnd; i++) {
            if (rootVal == inorder[i]){
                index = i;
                break;
            }
        }

        // 找到左子树的区间大小 --> 限制前序/后续数组的长度
        int leftTreeSize = index - inorStart;

        TreeNode root = new TreeNode(rootVal);

        root.left = build(postorder,posStart,posStart + leftTreeSize -1,
                            inorder, inorStart,index -1 );
        root.right = build(postorder,posStart + leftTreeSize,posEnd - 1,
                            inorder,index + 1,inoEnd);
        return root;

    }


}
