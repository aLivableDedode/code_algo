package otherclassicpro;

import java.util.Arrays;

/**
 *  经典动态规划：高楼扔鸡蛋
 *  你面前有一栋从 1 到N共N层的楼，然后给你K个鸡蛋（K至少为 1）。
 *  现在确定这栋楼存在楼层0 <= F <= N，在这层楼将鸡蛋扔下去，鸡蛋恰好没摔碎（高于F的楼层都会碎，低于F的楼层都不会碎）。
 *  现在问你，最坏情况下，你至少要扔几次鸡蛋，才能确定这个楼层F呢？
 *      --> 「状态」很明显，就是当前拥有的鸡蛋数K和需要测试的楼层数N。
 *          随着测试的进行，鸡蛋个数可能减少，楼层的搜索范围会减小，这就是状态的变化。
 *      --> 第i层楼扔了鸡蛋之后，可能出现两种情况：鸡蛋碎了，鸡蛋没碎
 *          --> 状态转移:
 *              --> 碎了：鸡蛋【K-1】 楼层【1,i-1】
 *              --> 没碎:鸡蛋【K】 楼层【i+1,N】
 *
 *  动态规划+线性搜索 可以  但是会超时
 *  TODO　动态规划＋二分搜索
 */
public class ThrowEggs {
    public static void main(String[] args) {
//        System.out.println(throwEggs(6, 10000));
        // 备忘录
        int K = 6,N =10000;
        int[][] memo = new int[K+1][N+1];
        for (int[] ints : memo) {
            Arrays.fill(ints,-1);
        }
        System.out.println(throwEggsBinarySearch(K, N, memo));
    }

    /**
     *  这种动态规划+线性搜索 可以  但是会超时
     * @param K
     * @param N
     * @return
     */
    public static int throwEggs(int K,int N){
        // 备忘录
        int[][] memo = new int[K+1][N+1];
        for (int[] ints : memo) {
            Arrays.fill(ints,-1);
        }
        return dp(K, N, memo);
    }

    public static int dp(int K,int N,int[][] memo){

        if (K == 1) return N;
        if (N == 0 ) return 0;

        if (memo[K][N] != -1) return memo[K][N];

        int res = Integer.MAX_VALUE;
        for (int i = 1; i < N+1; i++) {
            res = Math.min(res
                    ,1 + Math.max(dp(K,N-i,memo) // 没碎
                            ,dp(K-1,i-1,memo))//碎了
            );

        }
        memo[K][N] = res;
        return res;
    }

    /**
     *  动态规划＋二分搜索
     * @param K
     * @param N
     * @return
     */
    public static int throwEggsBinarySearch(int K,int N,int[][] memo){

        if (K == 1 || N == 0) return N;

        if (memo[K][N] != -1) return memo[K][N];

        int low = 1;
        int hight = N;
        int res = Integer.MAX_VALUE;
        while (low <= hight){
            int mid = low + (hight - low) /2;
            // 碎了
            int broken = dp(K-1,mid-1,memo);
            // 没碎
            int noBroken = dp(K,N - mid,memo);
            if (broken > noBroken){
                hight = mid - 1;
                res = Math.min(res,broken +1);
            }else {
                low = mid + 1;
                res = Math.min(res,noBroken + 1);
            }
        }
        memo[K][N] = res;
        return memo[K][N];
    }

}
