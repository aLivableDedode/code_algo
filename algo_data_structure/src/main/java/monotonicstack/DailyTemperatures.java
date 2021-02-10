package monotonicstack;

import java.util.Stack;

/**
 *
 *  给你一个数组，返回一个等长的数组，对应索引存储着下一个更大元素，如果没有更大的元素，就存 -1
 *     比如说，输入一个数组nums = [2,1,2,4,3]，你返回数组[4,2,4,-1,-1]。
 * @Author lvkai
 * @Description
 * @Date 2021/1/21 21:45
 **/
public class DailyTemperatures {


    public static void main(String[] args) {

    }

    public static int[] dailyTemperatures(int[] nums){
        int[] res = new int[nums.length];
        Stack<Integer> stack = new Stack<>();

        for (int i = nums.length - 1; i >= 0; i--) {

            if (!stack.empty() && nums[stack.peek()] <= nums[i]) {
                stack.pop();
            }

            res[i] = stack.empty()? 0: (stack.peek() - i);
            stack.push(i);
        }
        return res;
    }
}
