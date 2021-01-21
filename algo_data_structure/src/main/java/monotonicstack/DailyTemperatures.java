package monotonicstack;

import java.util.Stack;

/**
 *
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
