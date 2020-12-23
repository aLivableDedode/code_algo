package mostcommsubseq;

/**
 * 给定两个单词s1和s2，找到使得s1和s2相同所需的最小步数，
 *     每一步可以删除任意一个字符串中的一个字符
 *     --> 基本就是找最长公共子序列，然后根据原始字符长度减去公共子序长度值
 * @Author lvkai
 * @Description
 * @Date 2020/12/23 23:30
 **/
public class LCSMinDistance {
    public static void main(String[] args) {
        String s1 = "bank";
        String s2 = "ack";
        int lcs = MostCommSubSeq.longestCommonSubSeq(s1, s2);
        System.out.println(s1.length() + s2.length() - 2 * lcs);
    }
}
