package otherclassicpro;

/**
 *  @博弈问题
 *  你和你的朋友面前有一排石头堆，用一个数组 piles 表示，piles[i] 表示第 i 堆石子有多少个。
 *  你们轮流拿石头，一次拿一堆，但是只能拿走最左边或者最右边的石头堆。
 *  所有石头被拿完后，谁拥有的石头多，谁获胜。
 *
 * 石头的堆数可以是任意正整数，石头的总数也可以是任意正整数，这样就能打破先手必胜的局面了。
 * 比如有三堆石头 piles = [1,100,3]，先手不管拿 1 还是 3，
 * 能够决定胜负的 100 都会被后手拿走，后手会获胜。
 *
 * @【假设两人都很聪明，请你设计一个算法，返回先手和后手的最后得分（石头总数）之差。】
 * 比如上面那个例子，先手能获得 4 分，后手会获得 100 分，你的算法应该返回 -96
 *
 * @博弈问题的难点在于，两个人要轮流进行选择，而且都贼精明，应该如何编程表示这个过程呢？
 * 针对一个nums[i~j]的数组 想要得到最优解按照动态规划的思路：每次选择都是最大的值
 * 另外分别成先手fir、后手sec
 * @--》dp[i][j].fir 表示，对于 piles[i...j] 这部分石头堆，先手能获得的最高分数。
 * @--》dp[i][j].sec 表示，对于 piles[i...j] 这部分石头堆，后手能获得的最高分数。
 *
 * 想求的答案是先手和后手最终分数之差，
 * 按照这个定义也就是 dp[0][n-1].fir - dp[0][n-1].sec，
 * 即面对整个 piles，先手的最优得分和后手的最优得分之差。
 * dp 数组的定义，状态显然有三个：开始的索引 i，结束的索引 j，当前轮到的人。
 * --》伪代码：
 * n = piles.lenght
 * for 0 <= i < n:
 *  for j < i < n:
 *      for who in {fir,sec}:
 *          dp[i][j][who] = max(left,right)
 * @【left: piles[i] + dp[i+1][j].sec ==> 选择i(最左)之后，轮到对方先相当于子集变成后手】
 * @【right: piles[j] + dp[i][j-1].sec ==> 选择j(最右)之后，轮到对方先相当于子集变成后手】
 *
 * @另外状态转移方程:
 * if 先手选左边 ==》left > right:
 *  dp[i][j].sec = dp[i+1][j].fir
 * if 先手右边 ==》left < right:
 *  dp[i][j].sec = dp[i][j-1].fir
 *
 * @根据dp数组的定义，我们也可以找出 base case，也就是最简单的情况：
 * dp[i][i] = piles[i]
 * dp[i][j].sec = 0 ==> 当i==j是只有一堆
 */
public class GameProblem {

    public static void main(String[] args) {
        int[] piles = new int[]{3,9,1,2};
        System.out.println(gameProblem(piles));
    }

    public static int gameProblem(int[] piles){
        int n = piles.length;
        // 初始化 dp 数组
        Pair[][] dp = new Pair[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                dp[i][j] = new Pair(0,0);
            }
        }

        // 填入 base case
        for (int i = 0; i < n; i++) {
            dp[i][i].fir = piles[i];
            dp[i][i].sec = 0;
        }

        // 开始遍历dp 数组【斜着遍历】
        for (int l = 2; l <= n; l++) {
            for (int i = 0; i <= n - l; i++) {
                int j = l + i -1;
                int left = piles[i] + dp[i + 1][j].sec;
                int right = piles[j] + dp[i][j - 1].sec;
                // 状态转移
                if (left > right){
                    dp[i][j].fir = left;
                    dp[i][j].sec = dp[i+1][j].fir;
                }else {
                    dp[i][j].fir = right;
                    dp[i][j].sec = dp[i][j-1].fir;
                }
            }
        }

        Pair res = dp[0][n - 1];
        return res.fir - res.sec;
    }


}

class Pair{
    int fir,sec;

    public Pair(int fir, int sec) {
        this.fir = fir;
        this.sec = sec;
    }
}