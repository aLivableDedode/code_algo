package coinschange;

import java.util.HashMap;

/**
 *  备忘录
 *      记录每个子目标钱的最小数，避免重复计算
 */
public class Level2AideMemoire {

    public static int[] coinskind = new int[]{1,2,3,5};
    // 备忘录
    public static HashMap<Integer,Integer> memo = new HashMap<>();
    public static void main(String[] args) {
        int targetAmount = 16;
        System.out.println(subPiece(targetAmount));
        System.out.println(memo);
    }

    public static int subPiece(int targetAmount){
        // 查备忘录，避免重复计算
        if (memo.containsKey(targetAmount)) return memo.get(targetAmount);

        if (targetAmount == 0) return 0;
        if (targetAmount < -1) return -1;

        int res = Integer.MAX_VALUE;
        for (int feCoin : coinskind) {
            int subproblem = subPiece(targetAmount - feCoin);
            if (subproblem == -1 ) continue;
            res = Math.min(res,1 + subproblem);
        }

        // 记录备忘录
        int i = res != Integer.MAX_VALUE ? res : -1;
        if (!memo.containsKey(targetAmount))  memo.put(targetAmount,i);
        return i;
    }

}
