package binaryheap;

import java.util.PriorityQueue;

/**
 *中位数是有序列表中间的数。如果列表长度是偶数，中位数则是中间两个数的平均值。
 *     例如，
 *     [2,3,4] 的中位数是 3
 *     [2,3] 的中位数是 (2 + 3) / 2 = 2.5
 *     设计一个支持以下两种操作的数据结构：
 *     void addNum(int num) - 从数据流中添加一个整数到数据结构中。
 *     double findMedian() - 返回目前所有元素的中位数。
 *
 *     addNum方法时间复杂度 O(logN)，findMedian方法时间复杂度 O(1)
 */
public class MedianDataStream {

    private PriorityQueue<Integer> large;
    private PriorityQueue<Integer> small;
    /** initialize your data structure here. */
    public MedianDataStream() {
        // 小顶堆
        large = new PriorityQueue<>();
        // 大顶堆
        small = new PriorityQueue<>((a, b) -> {
            return b - a;
        });
    }

    public void addNum(int num) {
        // 不仅要维护large和small的元素个数之差不超过 1，
        // 还要维护large堆的堆顶元素要大于等于small堆的堆顶元素
        if (small.size() >= large.size()){
            // 想要往large里添加元素，不能直接添加，而是要先往small里添加，
            // 然后再把small的堆顶元素加到large中；向small中添加元素同理。
            small.offer(num);
            large.offer(small.poll());
        }else {
            large.offer(num);
            small.offer(large.poll());
        }
    }

    public double findMedian() {
        // 如果元素不一样多，多的那个堆的堆顶元素就是中位数
        if (large.size() < small.size()) {
            return small.peek();
        } else if (large.size() > small.size()) {
            return large.peek();
        }
        // 如果元素一样多，两个堆堆顶元素的平均数是中位数
        return (large.peek() + small.peek()) / 2.0;

    }
}
