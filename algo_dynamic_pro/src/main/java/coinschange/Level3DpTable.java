package coinschange;

import java.util.Arrays;
import java.util.TreeMap;

/**
 *  从1元开始到targetAmount,
 *      计算每个子目标需要的最少数,然后通过最优子问题结果合成最终结果
 */
public class Level3DpTable {

    public static int[] coinskind = new int[]{1,2,3,5};


    public static void main(String[] args) {
        // 前提：
        int[] coins = new int[]{1,2,3,5};
        int amount = 17;
        // 定义 dpTable
        int[] dp = new int[amount+1];
        Arrays.fill(dp,amount+1);
        dp[0] = 0;
        // 第一拆分
        for(int i=0; i<dp.length; i++){
            // 遍历所有可能
            for (int coin : coins) {
                // 终止的条件
                if( i - coin < 0) continue;
                // 选择的场景：这里抽象出来，想要找最少的个数的话，那要比较
                // 1、i值时个数    2、 剩余那部分钱（i-coin）的个数 + 1
                dp[i] = Math.min(dp[i],1 + dp[i -coin]);
            }
        }
        for (int i = 0; i < dp.length; i++) {
            System.out.print("amount :"+i+" "+dp[i]);
            System.out.println();
        }
    }



    public static void mainV(String[] args) {
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
            // 最多情况就是全是 1
            res.put(i,capacity + 1);
        }
        return res;
    }
}
