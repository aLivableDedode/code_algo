package fiponachi;

import java.util.HashMap;

/**
 *  备忘录模式
 *      利用备忘录记录计算节点信息,避免重复计算
 *      效果明显！
 */
public class Level2AideMemoire {

    public static HashMap<Integer,Long> aideMemoire = new HashMap<Integer, Long>();

    public static void main(String[] args) {
        System.out.println(aideMemoireMode(50,aideMemoire));
        System.out.println(aideMemoire);
    }

    public static Long aideMemoireMode(int n ,HashMap<Integer,Long> aideMemoire){
        if (n == 1 || n == 2) return 1l;

        if (aideMemoire.containsKey(n)) return aideMemoire.get(n);

        aideMemoire.put(n,aideMemoireMode(Integer.valueOf(n - 1),aideMemoire)
                + aideMemoireMode(Integer.valueOf(n - 2),aideMemoire));

        return aideMemoire.get(n);

    }
}
