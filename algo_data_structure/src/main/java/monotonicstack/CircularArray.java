package monotonicstack;

import java.util.Stack;

/**
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
