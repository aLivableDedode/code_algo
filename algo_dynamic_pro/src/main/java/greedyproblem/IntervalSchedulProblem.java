package greedyproblem;

import java.util.Arrays;
import java.util.Comparator;

/**
 *  区间调度问题
 *  正确的思路其实很简单，可以分为以下三步：
 *    1.从区间集合 intvs 中选择一个区间 x，这个 x 是在当前所有区间中结束最早的（end 最小）。
 *    2.把所有与 x 区间相交的区间从区间集合 intvs 中删除。
 *      重复步骤 1 和 2，直到 intvs 为空为止。之前选出的那些 x 就是最大不相交子集。
 *
 * @Author lvkai
 * @Description
 * @Date 2020/12/26 0:10
 **/
public class IntervalSchedulProblem {

    public static void main(String[] args) {
        int[][] intervals = {{1,3},{2,4},{3,6}};
        System.out.println(intervalSchedulProblem(intervals));
    }

    public static int intervalSchedulProblem(int[][] intervals){
        int count = 1;
        // 按照区间的end升序排序
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] pre, int[] next) {
                return pre[1] - next[1];
            }
        });
        int x_end = intervals[0][1];
        for (int[] interval : intervals) {
            int start = interval[0];
            if (start >= x_end){
                count++;
                x_end = interval[1];
            }
        }
        return count;
    }
}
