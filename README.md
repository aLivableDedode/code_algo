# code_algo
# [algo_dynamic_pro 动态规划](algo_dynamic_pro)

#### [1.斐波那契数列构建:](algo_dynamic_pro/src/main/java/fiponachi)

- [通过递归的方式](algo_dynamic_pro/src/main/java/fiponachi/Level1Recursive.java) :可行但是计算的时间复杂度高(O(2^n))
- [通过备忘录模式](algo_dynamic_pro/src/main/java/fiponachi/Level2AideMemoire.java)    :将计算的结果放入缓存的备忘录中，如果下次计算再次用的则无需重新从头开始计算
- [通过dpTable模式自下而上](algo_dynamic_pro/src/main/java/fiponachi/Level3DpTable.java)  :通过从头开始计算每一个值，然后逐步推导到第N个值的方式，构建了一个数组
- [dpTable 优化](algo_dynamic_pro/src/main/java/fiponachi/Level4DpTableMajorization.java)  

#### [2.零钱问题](algo_dynamic_pro/src/main/java/coinschange) 
    给 k 种⾯值的硬币，⾯值分别为 c1, c2 ... ck ，每种硬
    币的数量⽆限，再给⼀个总⾦额 amount ，问你最少需要⼏枚硬币凑出这个
    ⾦额，如果不可能凑出，算法返回 -1
 - [暴力穷求](algo_dynamic_pro/src/main/java/coinschange/Level1CoinsRecursive.java)
 - [通过备忘录模式](algo_dynamic_pro/src/main/java/coinschange/Level2AideMemoire.java)
 - [dpTabel模式自下而上](algo_dynamic_pro/src/main/java/coinschange/Level3DpTable.java):将用一个数组记录每一个
        子目标金额的最优结果，然后逐渐累加拼接成最终的金额对应到最优结果

#### [3.最长递增子序列长度 LIS](algo_dynamic_pro/src/main/java/mostincrsubseq) 
```java
/**
 *  给定一个无序的整数数组,找到其中最长的递增子序列的长度
 *   >>> tip: 注意「子序列」和「子串」这两个名词的区别，子串一定是连续的，而子序列不一定是连续的
 */
```
 - [dpTable模式](algo_dynamic_pro/src/main/java/mostincrsubseq/MostIncrSubseq.java)
 - [二分查找模式](algo_dynamic_pro/src/main/java/mostincrsubseq/MostIncrSubseq4BinarySearch.java)
 - [进阶问题:最大子序和](algo_dynamic_pro/src/main/java/mostincrsubseq/MostIncrSubseqSum.java) 在得到最大自序的基础上，并将这种情况列出来
 - [变种问题: 俄罗斯套娃/信封问题](algo_dynamic_pro/src/main/java/mostincrsubseq/EnvelopeProblem.java):这个其实是将原来的一维问题变成二维问题,当然也可以变成三维问题（套箱子）
 
 ##### [3.1 最大子数组和](algo_dynamic_pro/src/main/java/maxsubarraysum/MaximumSubArraySum.java) 
```
    给定一个整数数组nums,找到一个具有最大和的连续子数组(至少一个元素),返回其和
```
 
 ##### [3.2 最长公共子序列LCS](algo_dynamic_pro/src/main/java/mostcommsubseq/MostCommSubSeq.java) 
 ```python
    最长公共子序列（Longest Common Subsequence，简称 LCS）是一道非常经典的面试题目，
    因为它的解法是典型的二维动态规划，大部分比较困难的字符串问题都和这个问题一个套路
    
    相比较而言就是上面斐波那契数列解题思路的扩展，由一维数组变成二维数组
 ```
 -[变种问题:字符串的删除操作](algo_dynamic_pro/src/main/java/mostcommsubseq/LCSMinDistance.java)
    
    给定两个单词s1和s2，找到使得s1和s2相同所需的最小步数，
    每一步可以删除任意一个字符串中的一个字符
    --> 基本就是找最长公共子序列，然后根据原始字符长度减去公共子序长度值
 
 -[变种问题:最小 ASCII 删除和](algo_dynamic_pro/src/main/java/mostcommsubseq/LCSMinDeleteASCIISum.java)

     给定两个单词s1和s2，找到使两个字符串相等所需要删除字符的ASCII值的最小和
     --> 基本就是找最长公共子序列，不过要改下原来的代码
 
  #### [4.背包类型问题](algo_dynamic_pro/src/main/java/backpackproblem)
   - [4.1 0-1 背包问题]()

    给你一个可装载重量为W的背包和N个物品，每个物品有重量和价值两个属性。
    其中第i个物品的重量为wt[i]，价值为val[i]，现在让你用这个背包装物品，最多能装的价值是多少？
    
    举个简单的例子，输入如下：
    N = 3, W = 4
    wt = [2, 1, 3]
    val = [4, 2, 3]
    
    想比较凑零钱问题，这2个类型很相似, 只不过这里在比较的时候不是 dp[i - 1] + 1 而是
    转换成价值的val数组的具体比较
    
  
  #### [贪心类型问题]
  #### [其他经典问题]

 
# [algo_backtracking 回溯算法](algo_backtracking)

####[1.全排列任意数据](algo_backtracking/src/main/java/fullarray/FullArrayMode.java)

```python
回溯算法的基本框架

for 选择 in 选择列表：
    排除重复选择 --》将该选择从选择列表中排除 --》因为每次选择都是从nums的第一个元素开始
    做选择 --》将该选择加入当前选择的路径列中
    backtrack(选择列表,路径)
    路径.remove(选择) --》取消选择

    
```
####[2.N皇后问题]()

# [algo_data_structure 数据结构](algo_data_structure)