package fiponachi;

/**
 *  dpTable 优化:
 *      在计算的过程中，其实只是用到了2个中间变量记录 N-1、N-2
 *      所以dpTable 可以优化
 */
public class Level4DpTableMajorization {

    public static void main(String[] args) {
        System.out.println(majorization(50));
    }

    public static long majorization(int n){
        if (n == 1 || n ==2 ) return 1l;
        long prev = 1l;
        long curr = 1l;
        for (int i = 3; i<=n ; i++){
            long sum = curr + prev;
            prev = curr;
            curr = sum;
        }
        return curr;
    }
}
