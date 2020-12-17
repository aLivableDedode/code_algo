package mostincrsubseq;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 *  最长递增子序列长度
 */
public class MostIncrSubseq {

    public static int[] arr = new int[]{10,9,2,5,3,7,101,18};
    public static Map<Integer, LinkedList<Integer>> indexSubqeq = new HashMap<>();

    public static void main(String[] args) {

        // 定义dp数组，dp[i]即arr中第i个元素之前 可以组成的最长递增子序列长度
        int[] dp = new int[arr.length];
        // 默认为1 初始默认没有递增子序列
        Arrays.fill(dp,1);
        // 遍历每个元素X
        for (int i = 0; i < arr.length; i++) {
            LinkedList<Integer> iSubseq = new LinkedList<>();
            // 判断直到X元素之前有多少个递增
            for (int j = 0; j < i; j++) {
                if (arr[j] < arr[i]) {
                    dp[i] = Math.max(dp[i],dp[j] +1);
                }
            }
        }
        System.out.println(Arrays.stream(dp).max().getAsInt());

    }
}
