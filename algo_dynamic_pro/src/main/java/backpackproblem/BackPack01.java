package backpackproblem;

import java.util.Arrays;

/**
 * 给你一个可装载重量为W的背包和N个物品，每个物品有重量和价值两个属性。
 *  其中第i个物品的重量为wt[i]，价值为val[i]，现在让你用这个背包装物品，最多能装的价值是多少？
 */
public class BackPack01 {
    public static int[] wt = new int[]{2, 1, 3};
    public static int[] val = new int[]{4, 2, 3};
    public static void main(String[] args) {
        int W = 4;
        int N = 3;

        int[][] dp = new int[N+1][W+1];
        Arrays.fill(dp,0);

        for (int i = 0; i < N; i++) { //物体
            for (int w = 1; w <= W; w++) { //重量
                if (w - wt[i - 1] < 0) {

                }
            }


        }


    }
}
