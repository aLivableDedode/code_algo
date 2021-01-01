package otherclassicpro;

/**
 *  4键盘问题：
 *  四种按键:
 *         A : 在屏幕打印一个'A'
 *         C-A : 选中整个屏幕
 *         C-C : 复制
 *         C-V : 粘贴
 *
 *         假设按键可以按N次，那么屏幕最多可以显示几个'A'?
 *
 *
 * @第一种思路: 第一个状态是剩余的按键次数，用n表示；
 *          第二个状态是当前屏幕上字符 A 的数量，用a_num表示；
 *          第三个状态是剪切板中字符 A 的数量，用copy表示。
 * 那么状态转移:
 *      --》 按下A键
 *      dp(n-1,a_num+1,copy)
 *
 *      --》按下C-V
 *       dp(n-1,a_num+copy,copy)
 *
 *      --》按下 C-A C-C  最优的情况下 这两个键肯定是联合使用
 *      dp(n-2,a_num,a_num)
 *
 * @第二种思路: 稍微有点复杂，但是效率高。继续走流程，「选择」还是那 4 个，但是这次我们只定义一个「状态」，也就是剩余的敲击次数n
 *      --》字符数量少（N 比较小）时，C-A C-C C-V这一套操作的代价相对比较高，
 *          可能不如一个个按A；而当 N 比较大时，后期C-V的收获肯定很大。
 *          这种情况下整个操作序列大致是：开头连按几个A，
 *          然后C-A C-C组合再接若干C-V，然后再C-A C-C接着若干C-V，循环下去
 *
 *      --》》》 换句话说，最后一次按键要么是A要么是C-V
 *      定义int[] dp = new int[N + 1]; ==》表示 i 次操作后最多能显示多少个 A
 *          --》最后一次按键是A ==》 dp[i] = dp[i - 1] + 1;
 *          --》最后一次按键是C-V
 *              -->最优的操作序列一定是C-A C-C接着若干C-V ,用一个变量j作为若干C-V的起点。那么j之前的 2 个操作就应该是C-A C-C了
 *              --> dp[i] = dp[j-2] * (i - j + 1)
 *
 * @Author lvkai
 * @Description
 * @Date 2020/12/31 21:20
 **/
public class FourkeyboardProblem {
    public static void main(String[] args) {
        System.out.println(fourKeyboardV1(7,0,0));
        System.out.println(fourKeyboardV2(7));
    }


    /**
     *  可以优化为带备忘录的模式
     * @param n
     * @param a_num
     * @param copy
     * @return
     */
    public static int fourKeyboardV1(int n,int a_num,int copy){
        if (n <= 0) return a_num;

        return Math.max(Math.max(
                fourKeyboardV1(n - 1, a_num + 1, copy),
                fourKeyboardV1(n - 1, a_num + copy, copy)),
                fourKeyboardV1(n - 2, a_num, a_num));
    }

    public static int fourKeyboardV2(int n){
        int[] dp = new int[n+1];
        dp[0] = 0;
        for (int i = 1; i <= n; i++) {
            // 一直按A键
            dp[i] = dp[i-1]+1;
            for (int j = 2; j < i; j++) {
                dp[i] = Math.max(dp[i], dp[j-2]*(i - j +1));
            }
        }
        return dp[n];
    }




}
