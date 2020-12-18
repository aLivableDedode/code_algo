package mostincrsubseq;

import java.util.*;

/**
 * @Author lvkai
 * @Description
 * @Date 2020/12/17 23:28
 **/
public class MostIncrSubseqSum {

    public static int[] nums = new int[]{10,9,2,5,3,7,101,18};
    public static Map<Integer, LinkedList<Integer>> indexSubseq = new HashMap<>();

    public static void main(String[] args) {
        int[] dp = new int[nums.length];
        // 默认为1 初始默认没有递增子序列
        Arrays.fill(dp,1);
        for (int i = 0; i < nums.length; i++) {
            LinkedList<Integer> subList = new LinkedList<>();
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]){

                    //dp[i] = Math.max( dp[i],dp[j]+1);
                    if (dp[i] > dp[j] + 1){
                        dp[i] = dp[i];
                        subList.add(dp[j]);
                    }else {
                        dp[i] = 1 + dp[j];
                        LinkedList<Integer> newLink = new LinkedList<>();
                        newLink.addAll(indexSubseq.get(j));
                        subList = newLink;
                    }
                    //System.out.println(" dp[j]_Subseq :"+indexSubseq.get(j));

                }
            }
            subList.add(nums[i]);
            indexSubseq.put(i,subList);
//            System.out.println("i = "+i +" 当前值 "+nums[i] +" " +indexSubseq);
        }

        //System.out.println(" dpTable :"+ Arrays.stream(dp).mapToObj(x->String.valueOf(x)).reduce((x,y)->x+"_"+y).get());
        int asInt = Arrays.stream(dp).max().getAsInt();
        int sum = 0;
        for (int i = 0; i < dp.length; i++) {
            if (dp[i] == asInt) {
                Integer integer = indexSubseq.get(i).stream().reduce((a, b) -> a + b).get();
                sum = integer > sum ? integer : sum;
            }
        }
        System.out.println(" 最长子序列长度 :"+ asInt);
        System.out.println(" 最长子序列长度和 :"+ sum);
//        indexSubseq.values().stream().forEach(x->System.out.println(x.stream().reduce((a,b)->a+b).get()));

    }
}
