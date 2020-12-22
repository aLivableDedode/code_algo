package maxsubarraysum;

import java.util.Arrays;

/**
 *  动态规划套路：最大子数组和
 *  给定一个整数数组nums,找到一个具有最大和的连续子数组(至少一个元素),返回其和
 *   定义dp数组：第i个元素之前的最大连续子数组的和
 *      每次比较dp[i] 和 (nums[i] + dp[i-1]) 之间的大小
 */
public class MaximumSubArraySum {

    public static int[] nums = {-2,1,-3,4,-1,2,1,-5,4};

    public static void main(String[] args) {
        System.out.println(maxSubArraySum(nums));

        System.out.println(maxSubArraySumV2(nums));
    }

    public static int maxSubArraySum(int[] nums){
        int[] dp = new int[nums.length];
        // 定义dp数组：第i个元素之前的最大连续子数组
        // 第一位之前没有子数组初始化为0
        dp[0] = 0;
        // 状态转移
        for (int i = 1; i < dp.length; i++) {
            dp[i] = Math.max(nums[i],nums[i]+dp[i-1]);
        }

        System.out.println(" dpTable :"+ Arrays.stream(dp).mapToObj(x->String.valueOf(x)).reduce((x, y)->x+"_"+y).get());
        // 存储中间结果
        int res = Integer.MIN_VALUE;
        // 遍历dp 获取最大的子数组之和
        for (int i = 0; i < dp.length; i++) {
            res = Math.max(res,dp[i]);
        }
        return res;
    }

    public static int maxSubArraySumV2(int[] nums){
        int[] dp = new int[nums.length];
        // 定义dp数组：第i个元素之前的最大连续子数组
        // 第一位之前没有子数组初始化为0
        dp[0] = 0;
        // 状态转移

        int pre = nums[0];
        int curr = 0;
        // 存储中间结果
        int res = pre;
        for (int i = 1; i < dp.length; i++) {
            //dp[i] = Math.max(nums[i],nums[i]+dp[i-1]);
            // 计算
            curr = Math.max(nums[i],nums[i] + pre);
            // 存储
            pre = curr;

            // 比较
            res = Math.max(res,curr);
        }

        return res;
    }
}
