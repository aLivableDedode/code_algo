package mostcommsubseq;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 *  最长公共子序列问题：给你输入两个字符串s1和s2，请你找出他们俩的最长公共子序列，返回这个子序列的长度。
 *
 *  思路方面：没有办法的情况下 就是用s1和s2的所有子序列进行比较，明显当字符串越长越复杂
 *  所以利用dp数组：对于两个字符串求子序列，用两个指针i和j分别在两个字符串上移动 形成二维的dp[][]
 *      ---tip：反过来说 其实跟前面的斐波那契数列的解题思路是一样的
 *
 * @Author lvkai
 * @Description
 * @Date 2020/12/23 22:02
 **/
public class MostCommSubSeq {

    public static void main(String[] args) {
        longestCommonSubSeq("zabcde","acez");
        longestCommonSubSeqV2("zabcde","acez");


    }

    /**
     *  >>>>..>>>>>>>自底而上<<<<<<<<<<<<<<<<:
     *  伪代码：
     *      for 选择1 in 选择列表1:
     *         for 选择2 in 选择列表2:
     *              if (s1[i] == s2[j]){
     *                  dp[i][j] = 1 + dp[][]
     *              }else{
     *                  dp[i][j] = Max(xxx,xxx,xx)
     *              }
     */
    public static int longestCommonSubSeq(String a,String b){
        int m = a.length();
        int n = b.length();

        int[][] dp = new int[m+1][n+1];
        // dp[0][x]、dp[x][0] 都是 0

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (a.charAt(i - 1) == b.charAt(j - 1)){
                    dp[i][j] = 1 + dp[i - 1][j-1];
                }else {
                    // s1[i-1] 和 s2[j-1] 至少有一个不在 lcs 中
                    dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
                }
            }
        }

        /*for (int i = 0; i < dp.length; i++) {
            System.out.println(Arrays.stream(dp[i]).max().getAsInt());
        }*/
        Integer lcs = Arrays.stream(dp).map(x -> Arrays.stream(x).max().getAsInt())
                .collect(Collectors.toList()).stream()
                .sorted(Comparator.reverseOrder()).findFirst().get();
        System.out.println(" lcs -->"+lcs);
        return lcs;
    }


    /**
     *  自顶而下方式+备忘录
     *  伪代码：
     *      dp(s1,i,s2,j):
     *          if(s1[i] == s2[j]):
     *              dp[i][j] = 1 + dp[s1,1+i,s2,j+1]
     *          else:
     *              dp[i][j] = max(dp[s1,1+i,s2,j]，dp[s1,i,s2,j+1])
     */
    public static void longestCommonSubSeqV2(String a,String b){
        int m = a.length(), n = b.length();
        // 备忘录值为 -1 代表未曾计算
        int[][] memo = new int[m][n];
        for (int[] row : memo)
            Arrays.fill(row, -1);
        // 计算 s1[0..] 和 s2[0..] 的 lcs 长度
        System.out.println(dp(a,0,b,0,memo));
    }

    public static int dp(String a,int i ,String b,int j,int[][] memo){
        if (a.length() == i || b.length() == j) return 0;

        // 之前计算过的不再计算
        if (memo[i][j] != -1) return memo[i][j];

        if (a.charAt(i) == b.charAt(j)){
            memo[i][j] = 1 + dp(a,i+1,b,j+1,memo);
        }else {
            memo[i][j] = Math.max(dp(a,i+1,b,j,memo),dp(a,i,b,j+1,memo));
        }

        return memo[i][j];
    }


}
