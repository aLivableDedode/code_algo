package fiponachi;

import java.util.Arrays;

/**
 *  将备忘录独立出来成为一个DP tabel,然后【自下而上】的推算
 *  速度贼快!
 */
public class Level3DpTable {

    public static void main(String[] args) {
        int N = 50;
        Long[] dpTable = new Long[N+1];
        dpTable[1] = dpTable[2] =1l;
        for (int i = 3 ; i <= N;i++){
            dpTable[i] = dpTable[i-1] + dpTable[i-2];
        }
        System.out.println(Arrays.asList(dpTable));
    }
}
