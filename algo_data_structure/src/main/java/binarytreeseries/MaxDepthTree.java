package binarytreeseries;

import utils.TreeNode;
import utils.Utils;

/**
 *  一个树的最大深度
 *      --》在层序遍历的基础上 累计遍历迭代次数
 * @Author lvkai
 * @Description
 * @Date 2021/1/7 22:31
 **/
public class MaxDepthTree {

    public static void main(String[] args) {
        Utils.maxDepthTreeV1(new TreeNode(1));
        Utils.maxDepthTreeV2(new TreeNode(1));

    }
}
