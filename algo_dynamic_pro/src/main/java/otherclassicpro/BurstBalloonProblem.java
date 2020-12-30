package otherclassicpro;

/**
 *  经典动态规划：戳气球问题
 *  有n个气球，编号为0到n-1，每个气球上都标有一个数字，这些数字存在数组nums中。
 *         现在要求你戳破所有的气球。如果你戳破气球i，就可以获得nums[left] * nums[i] * nums[right]个硬币。
 *         这里的left和right代表和i相邻的两个气球的序号。
 *         注意当你戳破了气球i后，气球left和气球right就变成了相邻的气球。
 *         求所能获得硬币的最大数量。
 *
 *  题解思路：每戳破一个气球nums[i]，得到的分数和该气球相邻的气球【nums[i-1]和nums[i+1]是有相关性的】。
 *      而【运用动态规划算法的一个重要条件：子问题必须独立。】
 *      所以对于这个戳气球问题，如果想用动态规划，必须巧妙地定义dp数组的含义，避免子问题产生相关性，才能推出合理的状态转移方程
 *
 *      那么正常来说dp[i][j] =x:代表戳破气球i和气球j之间（开区间，不包括i和j）的所有气球，可以获得的最高分数为x
 *          那么求最值按照回溯算法思想，只要每一次都是最优解【爆破最佳的气球】,那就需要一个一个的来穷举尝试最优解
 *              但是随着nums的长度增加成本太高
 * --》》所以可以反过来想: 其实气球i和气球j之间的所有气球都可能是最后被戳破的那一个，不防假设为k。
 *      回顾动态规划的套路，这里其实已经找到了「状态」和「选择」：i和j就是两个「状态」，最后戳破的那个气球k就是「选择」。
 *      即：dp[i][j] = dp[i][k] + points[i] * points[k] * points[j] + dp[k][j]
 *
 *      那么伪代码：
 *      for i in ...:
 *          for j ...:
 *              for k in ...:
 *                  dp[i][j] = max(dp[i][j]
 *                      ,dp[i][k] + points[i] * points[k] * points[j] + dp[k][j])
 *
 *       --> 最后结果dp[0][n+1]
 *
 *  输入: [3,1,5,8]
 *  输出: 167
 *  解释: nums = [3,1,5,8] --> [3,5,8] -->   [3,8]   -->  [8]  --> []
 *       coins =  3*1*5      +  3*5*8    +  1*3*8      + 1*8*1   = 167
 * @Author lvkai
 * @Description
 * @Date 2020/12/30 23:05
 **/
public class BurstBalloonProblem {
    public static void main(String[] args) {
        int[] nums = new int[]{3,1,5,8};
        System.out.println(burstBalloon(nums));
    }

    public static int burstBalloon(int[] nums){
        int n = nums.length;
        // 计算要包含 i j 即：闭区间--》左右添加个虚拟气球
        int[] points = new int[n+2];
        points[0] = points[n+1] = 1;
        int[][] dp = new int[n+2][n+2];

        for (int i = 1; i <= n; i++) {
            points[i] = nums[i - 1];
        }

        // 计算dp[0][n+1] 需要从dp[0][0] 开始遍历到dp[0][n+1]
        // 前提是知道每一个位置的值
        // 可以采用 ：i由下往上
        for (int i = n; i >= 0; i--) {  // 注意边界是0
            // 可以采用 ：j应该从左往右
            for (int j = i + 1; j < n + 2; j++) {
                // 最后戳破的气球是哪个？
                for (int k = i + 1; k < j; k++) {
                    dp[i][j] = Math.max(dp[i][j],
                            dp[i][k] + points[i] * points[k] * points[j] + dp[k][j]);
                }
            }
        }

        return dp[0][n+1];
    }
}
