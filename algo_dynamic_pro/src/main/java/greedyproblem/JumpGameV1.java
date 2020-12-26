package greedyproblem;

/**
 *  Jump Game I
 *
 * @Author lvkai
 * @Description
 *
 **/
public class JumpGameV1 {

    public static void main(String[] args) {
        int[] nums = new int[]{2,3,1,1,4};
        System.out.println(canOver(nums));
    }

    public static boolean canOver(int[] nums){
        boolean canOver = false;
        int farthest = 0;
        int length = nums.length;
        for (int i = 0; i < length - 1; i++) { // 最后一个元素不算
            farthest = Math.max(farthest,i + nums[i]);
            // 出现0 或 最远往后退的情况
            if (farthest <= i) return false;
        }

        return farthest>=length -1;
    }

}
