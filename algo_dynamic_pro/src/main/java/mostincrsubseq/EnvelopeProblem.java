package mostincrsubseq;

import java.util.Arrays;
import java.util.Comparator;
import java.util.EmptyStackException;
import java.util.Map;

/**
 *  二维的最长子序列问题w:宽 h:高
 *      先按w排序升序，当w相同，则按h降序
 * @Author lvkai
 * @Description
 * @Date 2020/12/17 22:27
 **/
public class EnvelopeProblem {

    public static int[][] envelopes = {{1,8},{2,3},{5,4},{5,2},{6,7},{6,4}};

    public static void main(String[] args) {
        System.out.println(envelopes(envelopes));

    }
    public static int envelopes(int[][] envelopes){

        // 排序:先按w排序升序，当w相同，则按h降序
        Arrays.sort(envelopes, new Comparator<int[]>() {
            @Override
            public int compare(int[] a, int[] b) {
                if (a[0] == b[0]){
                    return b[1] - a[1];
                }else {
                    return a[0] - b[0];
                }
            }
        });

        // 构建高度的LIS
        int[] height = new int[envelopes.length];
        for (int i = 0; i < height.length; i++) {
            height[i] = envelopes[i][1];
        }

        // 构建dpTable
        int[] dp = new int[height.length];
        Arrays.fill(dp,1);
        for (int i = 0; i < height.length; i++) {
            for (int j = 0; j < i; j++) {
                if (height[j] < height[i]){
                    dp[i] = Math.max(dp[i],dp[j] +1 );
                }
            }
        }

        return Arrays.stream(dp).max().getAsInt();
    }
}
