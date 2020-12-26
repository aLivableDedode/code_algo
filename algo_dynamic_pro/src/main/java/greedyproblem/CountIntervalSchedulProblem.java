package greedyproblem;

import java.util.Arrays;
import java.util.Comparator;

/**
 *
 *  重叠子区间个数
 * @Author lvkai
 * @Description
 * @Date 2020/12/26 0:10
 **/
public class CountIntervalSchedulProblem {

    public static void main(String[] args) {
        int[][] intervals = {{10,16},{2,8},{1,6},{7,12}};
        int x = countIntervalSchedulProblem(intervals);
        System.out.println(x);
    }

    public static int countIntervalSchedulProblem(int[][] intervals){
        // 按照区间的end升序排序
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] a, int[] b) {
                return a[1] - b[1];
            }
        });

        int x_end = intervals[0][1];
        int count = 1;
        for (int i = 0; i < intervals.length; i++) {
            if (intervals[i][0] > x_end) {
                count++;
                x_end = intervals[i][1];
            }
        }
        return count;
    }

}
