package backpackproblem;

import java.util.Arrays;

/**
 *  给定一个只包含正整数的非空数组。是否可以将这个数组分割成两个子集，使得两个子集的元素和相等
 *      定义dp数组：dp[i][j] = x表示，对于前i个物品，当前背包的容量为j时，若x为true，
 *                  则说明可以恰好将背包装满，若x为false，则说明不能恰好将背包装满。
 *          ---》 对于重量j 前i个物体可以刚刚满足要求
 *          --》最终需要的目标 dp[i][sum/2]
 *          --》dp[0][X] = false dp[X][0] = true
 *          --》 选择: 对于dp[i][j]
 *              --》放入第i个物品  判断依据: dp[i - 1][j - nums[i -1]]
 *                          即:你如果装了第i个物品，就要看背包的剩余重量j - nums[i-1]限制下是否能够被恰好装满。
 *              --》不放入第i个物品 那么结果取决与上一个即dp[i-i][j]
 *
 *   TODO 另一个解法： 看这个问题，变相的凑零钱问题(不重复币数)，由有限的几个值凑成指定值的问题，只要能凑成那就是有结果 反之则无结果
 *
 * @Author lvkai
 * @Description
 * @Date 2020/12/24 23:05
 **/
public class SplitEqualSubSet {

    public static int[] nums = new int[]{1, 7, 11,5};

    public static void main(String[] args) {
        equalSubSetV1();
    }

    public static void equalSubSetV1(){
        int sum = Arrays.stream(nums).sum();

        if (sum % 2 != 0 ){
            System.out.println("别想了，找不到!");
            System.exit(0);
        }
        int w = sum / 2;
        boolean[][] dp = new boolean[nums.length + 1][w + 1];
        for (int i = 0; i <= nums.length; i++)
            dp[i][0] = true;


        for (int i = 1; i <= nums.length; i++) {
            for (int j = 1; j <= w; j++) {
                if (j < nums[i -1]){
                    // 重量不足 不放入
                    dp[i][j] = dp[i -1][j];
                }else {
                    dp[i][j] = dp[i -1][j] | dp[i -1][j - nums[i -1]];
                }
            }
        }
        /*for (int i = 1; i < dp.length; i++) {
            System.out.print(i+"\t");
        }
        System.out.println();
        for (int j = 1; j < dp.length; j++) {
            boolean[] booleans = dp[j];
            for (int m = 1; m < booleans.length; m++) {
                System.out.print(booleans[m]+"\t");
            }
            System.out.println();
        }*/

        // 看dp[x][w]的结果
        boolean tp = false;
        for (int j = 1; j < dp.length; j++) {
            //boolean[] booleans = dp[j];
            tp = dp[j][w] | tp;

        }
        System.out.println(tp);
    }

    public static void equalSubSetV2(){

    }
}
