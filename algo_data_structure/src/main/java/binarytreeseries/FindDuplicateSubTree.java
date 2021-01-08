package binarytreeseries;

import utils.ListNode;
import utils.TreeNode;
import utils.Utils;

import java.util.*;

/**
 *  寻找重复复子树
 *  --> 重复的判断前提是:
 *      --->1、以我为根的这棵二叉树（子树）长啥样？
 *      --->2、以其他节点为根的子树都长啥样？
 *   --> 想知道子树的样子，那么可以通过后续遍历得到完整的子树结构，并将其转化尾字符串，然后比较
 *
 * @Author lvkai
 * @Description
 * @Date 2021/1/8 22:31
 **/
public class FindDuplicateSubTree {

    // 记录子树结构string
    public static HashMap<String,Integer> memo = new HashMap<>();
    // 记录重复的子树
    public static List<TreeNode> res = new ArrayList<>();

    public static void main(String[] args) {
        LinkedList<Integer> linkedList = new LinkedList<>(Arrays.asList(
                new Integer[]{1,2,4,null,null,null,3,2,4,null,null,null,4,null}));
        TreeNode treeNode = Utils.constrBinaryTree(linkedList);
        List<TreeNode> duplicateSubtrees = findDuplicateSubtrees(treeNode);
        System.out.println(duplicateSubtrees);
    }

    public static List<TreeNode> findDuplicateSubtrees(TreeNode root){
        traverse(root);
        return res;
    }

    public static String traverse(TreeNode root){
        if (null == root) return "#";

        String left = traverse(root.left);
        String right = traverse(root.right);

        String subTree = left+","+right+","+root.val;
        int freq = memo.getOrDefault(subTree, 0);
        // 多次重复也只会被加入结果集一次
        if (freq == 1) {
            res.add(root);
        }
        memo.put(subTree,freq+1);
        return subTree;
    }
}
