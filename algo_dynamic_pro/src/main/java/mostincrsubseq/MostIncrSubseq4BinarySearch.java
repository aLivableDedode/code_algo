package mostincrsubseq;

/**
 *  二分查询确认最长递增子序列长度
 */
public class MostIncrSubseq4BinarySearch {

    public static int[] nums = new int[]{10,9,2,5,3,7,101,18};

    public static void main(String[] args) {
        int[] top = new int[nums.length];
        // 牌堆初始为0
        int piles = 0;

        for (int i = 0; i < nums.length; i++) {
            // 需要处理的扑克牌
            int poker = nums[i];

            /********左边界的二分查找***********/
            int left = 0; int right = piles;
            while (left < right){
                int mid = (left + right) / 2;
                if (top[mid] > poker){
                    right = mid;
                }else if (top[mid] < poker){
                    left = mid + 1;
                }else {
                    right = mid;
                }
            }
            // 没有找到合适的牌堆，新建一堆
            if (left == piles) piles++;
            // 把这张牌放到牌堆顶
            top[left] = poker;
        }

        System.out.println(piles);
    }
}
