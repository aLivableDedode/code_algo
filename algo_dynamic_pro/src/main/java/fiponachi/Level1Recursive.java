package fiponachi;

/**
 *  暴⼒递归 : 自顶而下
 *  1 1 2 3 5 8 13 21 .....
 */
public class Level1Recursive {
    public static void main(String[] args) {
        System.out.println(recursive(50));
    }

    public static int recursive(int n){
        if (n == 1 || n == 2) return 1;
        return recursive(n - 1) + recursive(n - 2);
    }
}
