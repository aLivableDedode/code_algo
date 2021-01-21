package monotonicstack;

import java.util.Arrays;
import java.util.Stack;

/**
 *  下一个更大元素 I
 *
 *  给你一个数组，返回一个等长的数组，对应索引存储着下一个更大元素，如果没有更大的元素，就存 -1
 *  比如说，输入一个数组nums = [2,1,2,4,3]，你返回数组[4,2,4,-1,-1]。
 *
 * @Author lvkai
 * @Description
 * @Date 2021/1/21 20:56
 **/
public class NextGreaterNumber {

    public static void main(String[] args) {
        int[] nums = new int[]{2,1,2,4,3};
        int[] res = nextGreaterElement(nums);
        for (int re : res) {
            System.out.println(re);
        }
    }

    public static int[] nextGreaterElement(int[] nums){
        int[] res = new int[nums.length];

        Stack<Integer> stack = new Stack<>();
        // 后进先出
        for (int i = nums.length - 1; i >= 0; i--) {
            // 判定个子高矮
            while (!stack.empty() && stack.peek() <= nums[i]) {
                stack.pop();
            }
            res[i] = stack.empty()? -1 : stack.peek();

            // 进栈
            stack.push(nums[i]);
        }
        return res;
    }
}
