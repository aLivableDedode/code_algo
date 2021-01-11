package lfu;

import java.util.HashMap;
import java.util.LinkedHashSet;

/**
 * 1、调用get(key)方法时，要返回该key对应的val。
 * 2、只要用get或者put方法访问一次某个key，该key的freq就要加一。
 * 3、如果在容量满了的时候进行插入，则需要将freq最小的key删除，如果最小的freq对应多个key，
 *      则删除其中最旧的那一个。
 *
 *  O(1) 的时间内解决这些需求:
 *      1、使用一个HashMap存储key到val的映射，就可以快速计算get(key)。
 *       HashMap<Integer, Integer> keyToVal;
 *      2、使用一个HashMap存储key到freq的映射，就可以快速操作key对应的freq。
 *      HashMap<Integer, Integer> keyToFreq;
 *
 * LFU 算法的核心:
 *      1.首先，肯定是需要freq到key的映射，用来找到freq最小的key
 *      2.将freq最小的key删除，那你就得快速得到当前所有key最小的freq是多少。
 *          想要时间复杂度 O(1) 的话，肯定不能遍历一遍去找，那就用一个变量minFreq来记录当前最小的freq
 *      3.可能有多个key拥有相同的freq，所以 freq对key是一对多的关系，即一个freq对应一个key的列表
 *      4.希望freq对应的key的列表是存在时序的，便于快速查找并删除最旧的key
 *      5.希望能够快速删除key列表中的任何一个key，因为如果频次为freq的某个key被访问，
 *          那么它的频次就会变成freq+1，就应该从freq对应的key列表中删除，加到freq+1对应的key的列表中
 */
public class LFUCache {
    // key 到 val 的映射，我们后文称为 KV 表
    HashMap<Integer, Integer> keyToVal;
    // key 到 freq 的映射，我们后文称为 KF 表
    HashMap<Integer, Integer> keyToFreq;
    // freq 到 key 列表的映射，我们后文称为 FK 表
    HashMap<Integer, LinkedHashSet<Integer>> freqToKeys;
    // 记录最小的频次
    int minFreq;
    // 记录 LFU 缓存的最大容量
    int cap;

    public LFUCache(int capacity) {
        keyToVal = new HashMap<>();
        keyToFreq = new HashMap<>();
        freqToKeys = new HashMap<>();
        this.cap = capacity;
        this.minFreq = 0;
    }

    /**
     *  维护KV表，KF表，FK表三个映射
     */
    public int get(int key) {
        if (!keyToFreq.containsKey(key)){
            return -1;
        }
        // 增加 key 对应的 freq
        increaseFreq(key);
        return keyToVal.get(key);
    }

    public void put(int key, int val) {
        if (this.cap <= 0) return;

        /* 若 key 已存在，修改对应的 val 即可 */
        if (keyToVal.containsKey(key)) {
            keyToVal.put(key, val);
            // key 对应的 freq 加一
            increaseFreq(key);
            return;
        }

        /* key 不存在，需要插入 */
        /* 容量已满的话需要淘汰一个 freq 最小的 key */
        if (this.cap <= keyToVal.size()) {
            removeMinFreqKey();
        }

        /* 插入 key 和 val，对应的 freq 为 1 */
        // 插入 KV 表
        keyToVal.put(key, val);
        // 插入 KF 表
        keyToFreq.put(key, 1);
        // 插入 FK 表
        freqToKeys.putIfAbsent(1, new LinkedHashSet<>());
        freqToKeys.get(1).add(key);
        // 插入新 key 后最小的 freq 肯定是 1
        this.minFreq = 1;
    }

    private void removeMinFreqKey() {
        // freq 最小的 key 列表
        LinkedHashSet<Integer> keyList = freqToKeys.get(this.minFreq);
        // 其中最先被插入的那个 key 就是该被淘汰的 key
        int deletedKey = keyList.iterator().next();
        /* 更新 FK 表 */
        keyList.remove(deletedKey);
        if (keyList.isEmpty()) {
            freqToKeys.remove(this.minFreq);
            // 问：这里需要更新 minFreq 的值吗？
            // 其实这里没必要更新minFreq变量
            // removeMinFreqKey这个函数是在什么时候调用？在put方法中插入新key时可能调用
            // put的代码，插入新key时一定会把minFreq更新成 1，所以说即便这里minFreq变了，不需要管它
        }
        /* 更新 KV 表 */
        keyToVal.remove(deletedKey);

        /* 更新 KF 表 */
        keyToFreq.remove(deletedKey);
    }

    public void increaseFreq(int key){
        Integer oldFeq = keyToFreq.get(key);
        /* 更新 KF 表 */
        keyToFreq.put(key, oldFeq + 1);
        /* 更新 FK 表 */
        // 将 key 从 freq 对应的列表中删除
        freqToKeys.get(oldFeq).remove(key);
        // 将 key 加入 freq + 1 对应的列表中
        LinkedHashSet<Integer> orDefault = freqToKeys.getOrDefault(oldFeq + 1, new LinkedHashSet<>());
        freqToKeys.get(oldFeq+1).add(key);
        // 如果 freq 对应的列表空了，移除这个 freq
        if (freqToKeys.get(oldFeq).isEmpty()) {
            freqToKeys.remove(oldFeq);
            // 如果这个 freq 恰好是 minFreq，更新 minFreq
            if (oldFeq == this.minFreq) {
                this.minFreq++;
            }
        }
    }
}
