package monotonicqueue;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * 给你输入一个数组nums和一个正整数k，有一个大小为k的窗口在nums上从左至右滑动，请你输出每次窗口中k个元素的最大值。
 *
 * 输入: nums = [1,3,-1,-3,5,3,6,7], 和 k = 3
 * 输出: [3,3,5,5,6,7]
 *
 * @Author lvkai
 * @Description
 * @Date 2021/2/24 22:37
 **/
public class MaxSlidingWindow {

    public int[] maxSlidingWindow(int[] nums,int k){
        List<Integer> res = new ArrayList<>();
        MonotonicQueue window = new MonotonicQueue();

        for (int i = 0; i < nums.length; i++) {
            if (i<k-1){
                //先填满窗口的前 k - 1
                window.push(nums[i]);
            }else {
                // 窗口向前滑动，加入新数字
                window.push(nums[i]);
                // 记录当前窗口的最大值
                res.add(window.max());
                // 移出旧数字
                window.pop(nums[i-k+1]);
            }
        }

        // 需要转成 int[] 数组再返回
        int[] arr = new int[res.size()];
        for (int i = 0; i < res.size(); i++) {
            arr[i] = res.get(i);
        }
        return arr;
    }
}
