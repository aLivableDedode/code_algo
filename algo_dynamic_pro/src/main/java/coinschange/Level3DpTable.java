package coinschange;

import java.util.TreeMap;

/**
 *  从1元开始到targetAmount,
 *      计算每个子目标需要的最少数,然后通过最优子问题结果合成最终结果
 */
public class Level3DpTable {

    public static int[] coinskind = new int[]{1,2,3,5};

    public static void main(String[] args) {
        int targetMoney = 17;
        TreeMap<Integer,Integer> dpTree = constructTreeMap(targetMoney+1);
        dpTree.put(0,0);
        System.out.println(dpTree);
        for (int i = 0; i < dpTree.size(); i++) {
            for (int coin : coinskind) {
                // 排除
                if (i - coin < 0) continue;

                // 选择
                int res = Math.min(dpTree.get(i),1 + dpTree.get(i - coin));
                dpTree.put(i,res);
            }
        }

        System.out.println(dpTree);

    }

    public static TreeMap<Integer,Integer> constructTreeMap(int capacity){
        TreeMap<Integer,Integer> res = new TreeMap<>();
        for (int i = 0; i <= capacity; i++) {
            res.put(i,capacity + 1);
        }
        return res;
    }
}
