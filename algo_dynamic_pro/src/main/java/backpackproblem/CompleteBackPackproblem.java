package backpackproblem;

/**
 *  给定不同面额的硬币和一个总金额，写出函数计算可以凑成总金额的硬币组合,每一种面额的硬币由无限个
 *     --》 转换下描述：有一个背包，最大容量为amount，有一系列物品coins，每个物品的重量为coins[i]，每个物品的数量无限。
 *         请问有多少种方法，能够把背包恰好装满？
 *  dp数组的定义:dp[i][j] --> 使用i个coins 凑成j金额的总共组合
 *      那么第i个硬币的状态转移:
 *          --> 不将coins[i]放入，则dp[i][j] 取决于 dp[i-1][j]
 *          --> 将coins[i]放入，则dp[i][j] 取决于 dp[i][j-coins[i-1]] + dp[i-1][j]
 * @Author lvkai
 * @Description
 * @Date 2020/12/25 23:21
 **/
public class CompleteBackPackproblem {

    public static int[] coins = new int[]{1,2,5};

    public static void main(String[] args) {
        int amount = 5;
        System.out.println(completeBackPackproblemV1(coins,amount));
        System.out.println(completeBBPV2(coins,amount));
    }

    public static int completeBackPackproblemV1(int[] coins,int amount){
        int n = coins.length;
        int[][] dp = new int[n +1][amount+1];
        for (int i = 0; i < dp.length; i++) {
            dp[i][0]= 1; // 没有硬币就是 0
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= amount; j++) {
                if (j - coins[i -1] >= 0){ // 还有剩余金额
                    // 第i-1的情况 + 第i
                    dp[i][j] = dp[i-1][j] + dp[i][j-coins[i-1]];
                }else {
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        return dp[n][amount];
    }

    /**
     *  我们通过观察可以发现，dp数组的转移只和dp[i][..]和dp[i-1][..]有关，
     *      所以可以压缩状态，进一步降低算法的空间复杂度
     * @param coins
     * @param amount
     * @return
     */
    public static int completeBBPV2(int[] coins,int amount){
        int n = coins.length;
        int[] dp = new int[amount+1];
        dp[0] = 1;
        for (int i = 0; i < n; i++) { // 注意i从0开始
            for (int j = 1; j <= amount; j++) {
                // 只要j > 上次coins[i]
                if (j - coins[i] >=0){
                    dp[j] = dp[j] + dp[j-coins[i]];
                }
            }
        }

        return dp[amount];
    }
}
