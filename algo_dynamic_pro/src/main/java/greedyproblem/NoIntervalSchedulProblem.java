package greedyproblem;

import java.util.Arrays;
import java.util.Comparator;

/**
 *  第 435 题，无重叠区间：
 *
 * @Author lvkai
 * @Description
 * @Date 2020/12/26 0:10
 **/
public class NoIntervalSchedulProblem {

    public static void main(String[] args) {
        int[][] intervals = {{1,2},{2,3},{3,4},{1,3}};
        int x = IntervalSchedulProblem.intervalSchedulProblem(intervals);
        int length = intervals.length;
        System.out.println("总共区间:"+ length +" 重叠区间:"+x+" 无重叠区间:"+ (length - x));
    }

}
