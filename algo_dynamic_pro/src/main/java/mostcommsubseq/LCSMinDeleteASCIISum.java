package mostcommsubseq;

import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.Collectors;

/**
 * 给定两个单词s1和s2，找到使两个字符串相等所需要删除字符的ASCII值的最小和
 *      --> 基本就是找最长公共子序列，不过要改下原来的代码
 * @Author lvkai
 * @Description
 * @Date 2020/12/23 23:30
 **/
public class LCSMinDeleteASCIISum {
    public static void main(String[] args) {
        String s1 = "sea";
        String s2 = "eat";
        minDeleteASCIISum(s1, s2);
    }

    public static void minDeleteASCIISum(String a,String b){
        int m = a.length(), n = b.length();
        // 备忘录值为 -1 代表未曾计算
        int[][] memo = new int[m][n];
        for (int[] row : memo)
            Arrays.fill(row, -1);
        // 计算 s1[0..] 和 s2[0..] 的 lcs 长度
        System.out.println(dp(a,0,b,0,memo));
    }

    public static int dp(String a,int i ,String b,int j,int[][] memo){
        int res = 0;
        if (a.length() == i){
            // 没有一个相同 则需要另一个全删
            for (; j < b.length(); j++) {
                res += b.charAt(j);
            }
            return res;
        }

        if (b.length() == j){
            // 没有一个相同 则需要另一个全删
            for (; i< a.length(); i++) {
                res += a.charAt(i);
            }
            return res;
        }



        // 之前计算过的不再计算
        if (memo[i][j] != -1) return memo[i][j];

        if (a.charAt(i) == b.charAt(j)){
//            memo[i][j] = 1 + dp(a,i+1,b,j+1,memo);
            // 这里就不需要+1了
            memo[i][j] = dp(a,i+1,b,j+1,memo);
        }else {
            memo[i][j] = Math.min( // 这里是最小的
                    a.charAt(i) + dp(a,i+1,b,j,memo)  //i 对应的不相同需要删除
                    ,b.charAt(j) + dp(a,i,b,j+1,memo) //j 对应的不相同需要删除
            );
        }

        return memo[i][j];
    }
}
