package backpackproblem;

import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.Collectors;

/**
 * 给你一个可装载重量为W的背包和N个物品，每个物品有重量和价值两个属性。
 *  其中第i个物品的重量为wt[i]，价值为val[i]，现在让你用这个背包装物品，最多能装的价值是多少？
 *
 *  TODO 找到装最多的组合
 *
 */
public class BackPack01 {
    public static int[] wt = new int[]{2, 1, 3};
    public static int[] val = new int[]{4, 2, 3};
    public static void main(String[] args) {
        int W = 4;
        int N = 3;

        // dp[i][w]表示：对于前i个物品，当前背包的容量为w时，这种情况下可以装下的最大价值是dp[i][w]。
        int[][] dp = new int[N+1][W+1];

        for (int i = 1; i <= N; i++) { //物体
            for (int w = 1; w <= W; w++) { //重量
                if (w < wt[i - 1]) {
                    // 重量已经超 所以本次不放入
                    dp[i][w] = dp[i -1][w];
                }else {
                    // 可以装入或不装入 则比较价值大小  取大者
                    // 如果想装第i个物品，你怎么计算这时候的最大价值？换句话说，在装第i个物品的前提下，
                    // 背包能装的最大价值是多少？
                    //显然，你应该寻求剩余重量w-wt[i-1]限制下能装的最大价值，加上第i个物品的价值val[i-1]，
                    // 这就是装第i个物品的前提下，背包可以装的最大价值。
                    dp[i][w] = Math.max(dp[i -1][w - wt[i -1]] + val[i-1]
                        ,dp[i -1][w]  // 不装入
                    );
                    // System.out.println(" i = "+i+" w= "+w +" dp[i][w] = "+dp[i][w]);
                }
            }
        }
        Integer maxVal = Arrays.stream(dp).map(x -> Arrays.stream(x).max().getAsInt())
                .collect(Collectors.toList()).stream()
                .sorted(Comparator.reverseOrder()).findFirst().get();
        System.out.println(maxVal);
    }
}
