package fullarray;

import java.util.*;

/*
 * @Author lvkai
 * @Description
 * @Date 2020/12/15 23:14
 **/
public class FullArrayMode {

    public static LinkedList<String> backTrackList = new LinkedList<String>();
    public static void main(String[] args) {
        // 构建一个无重复的长度为N的数组
        Integer[] nums = constructArray(5);
        System.out.println(Arrays.asList(nums));
        // 全排序
        fullArray(nums);
        System.out.println(backTrackList);


    }

    public static void fullArray(Integer[] nums){
        LinkedList<Integer> track = new LinkedList<Integer>();
        backTrackingFullArray(nums,track);
    }

    public static void backTrackingFullArray(Integer[] nums,LinkedList<Integer> track){
        if (track.size() == nums.length)
            backTrackList.add(track.stream().map(x->String.valueOf(x)).reduce((x,y)->x+"-"+y).get());

        // 遍历选择
        for (Integer num : nums) {
            // 排除不合法的选择
            if (track.contains(num)) continue;

            // 做选择
            track.add(num);

            // 进入下一层决策 --> 将本层的结果带入到下次
            backTrackingFullArray(nums,track);

            // 取消本层的结果,回到上层
            track.removeLast();

        }

    }




    public static Integer[] constructArray(int n){
        ArrayList<Integer> arrayList = new ArrayList<Integer>();
        Random random = new Random();
        while (arrayList.size() < n){
            int nextInt = random.nextInt(100);
            if (!arrayList.contains(nextInt)){
                arrayList.add(nextInt);
            }
        }
        return arrayList.toArray(new Integer[n]);
    }
}
