package monotonicstack;

import java.util.Stack;

/**
 *  给你一个数组T，这个数组存放的是近几天的天气气温，你返回一个等长的数组，
 *     计算：对于每一天，你还要至少等多少天才能等到一个更暖和的气温；如果等不到那一天，填 0。
 *
 * @Author lvkai
 * @Description
 * @Date 2021/1/21 21:53
 **/
public class CircularArray {

    public int[] circularArray(int[] nums){
        int length = nums.length;
        int[] res = new int[length];
        Stack<Integer> stack = new Stack<>();
        //假装nums 长度扩大2倍
        for (int i = 2 * length - 1; i >= 0; i--) {

            while (!stack.isEmpty() && stack.peek() <= nums[i%length]){
                stack.pop();
            }

            res[i % length] = stack.isEmpty()? -1:stack.pop();

            stack.push(i%length);
        }
        return res;
    }
}
