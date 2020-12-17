package coinschange;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

/**
 *  零钱问题利用递归穷举
 */
public class Level1CoinsRecursive {

    public static int[] coinskind = new int[]{1,2,3,5};
    public static void main(String[] args) {
        int targetAmount = 16;
        System.out.println(subPiece(targetAmount));
    }

    public static int subPiece(int targetAmount){
        if (targetAmount == 0) return 0;
        if (targetAmount < -1) return -1;

        int res = Integer.MAX_VALUE;
        for (int feCoin : coinskind) {
            int subproblem = subPiece(targetAmount - feCoin);
            if (subproblem == -1 ) continue;
            res = Math.min(res,1 + subproblem);
        }
        return res != Integer.MAX_VALUE?res:-1;
    }



}
