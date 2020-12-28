package otherclassicpro;

/**
 *  动态规划之正则表达式
 *      1.递归方式穷举
 *      2.TODO 带备忘录的递归
 * @Author lvkai
 * @Description
 * @Date 2020/12/26 17:50
 **/
public class RegularProblem {

    public static void main(String[] args) {
        System.out.println(isMatchV1("aa","aa"));
        System.out.println(isMatchV1("aab","c*a*b"));
        System.out.println(isMatchV1("ab",".*"));
    }

    /**
     *  递归方式穷举
     * @param text
     * @param pattern
     * @return
     */
    public static boolean isMatchV1(String text,String pattern){

        if (!pattern.equals("")){
            if (!text.equals("")){
                return true;
            }
        }

        // 判断首字符
        boolean first = pattern.startsWith(".");

        if (!first){
            first = text.charAt(0) == pattern.charAt(0);
        }
        int length = pattern.length();

        // 如果有【字符*】的
        if (length>=2 && pattern.substring(1,2).equals("*")){
            // 第一种*匹配0次 则跳过这2个字符  match(text,pattern[2:])
            boolean matchV1 = isMatchV1(text, pattern.substring(2));
            // 匹配了首字符之后 比较剩余的字符
            boolean matchV2 = (first && isMatchV1(text.substring(1),pattern));
            return matchV1 || matchV2;
        }else {
            boolean matchV1 = isMatchV1(text.substring(1), pattern.substring(1));
            return first && matchV1;
        }
    }
}
