package greedyproblem;

/**
 *  Jump GameⅡ
 *
 * @Author lvkai
 * @Description
 *
 **/
public class JumpGameV2 {

    public static void main(String[] args) {
        int[] nums = new int[]{2,3,1,1,4};
        System.out.println(canOver(nums));
    }

    /**
     *  i和end标记了可以选择的跳跃步数，
     *  farthest标记了所有可选择跳跃步数[i..end]中能够跳到的最远距离，
     *  jumps记录了跳跃次数。
     * @param nums
     * @return
     */
    public static int canOver(int[] nums){
        boolean canOver = false;
        int farthest = 0;
        int end = 0;
        int jumps = 0;
        int length = nums.length;
        for (int i = 0; i < length - 1; i++) { // 最后一个元素不算
            farthest = Math.max(farthest,i + nums[i]);
            //
            if (end == i){
                jumps++;
                end = farthest;
            }
        }
        return jumps;
    }
}
