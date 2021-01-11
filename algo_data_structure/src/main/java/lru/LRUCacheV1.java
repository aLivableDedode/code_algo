package lru;

import java.util.HashMap;
import java.util.LinkedHashMap;

/**
 *  LRU
 *  输入
 * ["LRUCache", "put", "put", "get", "put", "get", "put", "get", "get", "get"]
 * [[2], [1, 1], [2, 2], [1], [3, 3], [2], [4, 4], [1], [3], [4]]
 * 输出
 * [null, null, null, 1, null, -1, null, -1, 3, 4]
 *
 * 解释
 * LRUCache lRUCache = new LRUCache(2);
 * lRUCache.put(1, 1); // 缓存是 {1=1}
 * lRUCache.put(2, 2); // 缓存是 {1=1, 2=2}
 * lRUCache.get(1);    // 返回 1
 * lRUCache.put(3, 3); // 该操作会使得关键字 2 作废，缓存是 {1=1, 3=3}
 * lRUCache.get(2);    // 返回 -1 (未找到)
 * lRUCache.put(4, 4); // 该操作会使得关键字 1 作废，缓存是 {4=4, 3=3}
 * lRUCache.get(1);    // 返回 -1 (未找到)
 * lRUCache.get(3);    // 返回 3
 * lRUCache.get(4);    // 返回 4
 *
 * 链接：https://leetcode-cn.com/problems/lru-cache
 *
 *
 *  ==> 首先要接收一个 capacity 参数作为缓存的最大容量，
 *  ==> 然后实现两个 API，一个是 put(key, val) 方法存入键值对，
 *  ==> 另一个是 get(key) 方法获取 key 对应的 val，如果 key 不存在则返回 -1。
 *  ====> 【get 和 put 方法必须都是 O(1) 的时间复杂度】
 *      链表？ 在知道元素的情况下插入是O(1)的 但是查找是O(N)
 *      哈希表？ 查找元素是O(1) 但是哈希表本身是无序的查找只能遍历
 *  ====>>>> V1:结合一下用链表+哈希表
 *  ====>>>> V2:使用内置的LinkedHashMap
 *
 *
 *
 */
public class LRUCacheV1 {

    private int capacity;

    // hash表
    private HashMap<Integer,Node> map;

    // 双链表
    private DoubleList cache;

    public LRUCacheV1(int capacity) {
        this.capacity = capacity;
        map = new HashMap<>();
        cache = new DoubleList();
    }

    /**
     *  尽量让 LRU 的主方法 get 和 put 避免直接操作 map 和 cache 的细节
     */

    /* 删除某一个 key */
    private void deleteKey(int key){
        Node x = map.get(key);
        // 链表删除
        cache.remove(x);
        // 哈希表删除
        map.remove(key);
    }

    /* 添加最近使用的元素 */
    private void addRecently(int key, int val){
        Node node = new Node(key, val);
        // 链表尾部就是最近使用的元素
        cache.addLast(node);
        // 别忘了在 map 中添加 key 的映射
        map.put(key,node);
    }

    /* 将某个 key 提升为最近使用的 */
    private void makeRecently(int key){
        Node x = map.get(key);
        // 先从链表中删除这个节点
        cache.remove(x);
        // 重新插到队尾
        cache.addLast(x);
    }

    /* 删除最久未使用的元素 */
    private void removeLeastRecently(){
        // 链表头部的第一个元素就是最久未使用的
        Node node = cache.removeFirst();
        // 同时别忘了从 map 中删除它的 key
        map.remove(node.key);
    }

    public int get(int key) {
        if (!map.containsKey(key)) {
            return -1;
        }
        // 将该数据提升为最近使用的
        makeRecently(key);
        return map.get(key).val;
    }

    public void put(int key,int val){
        // key 存在
        if (map.containsKey(key)){
            // 删除旧的数据
            deleteKey(key);
            // 新插入的数据为最近使用的数据
            addRecently(key, val);
            return;
        }
        if (capacity >= cache.size()){
            removeLeastRecently();
        }
        // 添加为最近使用的元素
        addRecently(key, val);
    }

}
