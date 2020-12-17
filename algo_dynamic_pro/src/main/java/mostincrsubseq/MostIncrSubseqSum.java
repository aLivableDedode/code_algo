package mostincrsubseq;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * @Author lvkai
 * @Description
 * @Date 2020/12/17 23:28
 **/
public class MostIncrSubseqSum {

    public static int[] nums = new int[]{10,9,2,5,3,7,101,18};
    public static Map<Integer, LinkedList<Integer>> indexSubseq = new HashMap<>();

    public static void main(String[] args) {
        int[] dp = new int[nums.length];

        for (int i = 0; i < nums.length; i++) {
            LinkedList<Integer> subList = new LinkedList<>();
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]){
                    dp[i] = Math.max( dp[i],dp[j]+1);

                }
            }
            subList.add(nums[i]);
        }

        System.out.println(" 最长子序列长度 :"+Arrays.stream(dp).max().getAsInt());

    }
}
