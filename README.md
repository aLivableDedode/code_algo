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
```python
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
   - [4.1 0-1 背包问题](algo_dynamic_pro/src/main/java/backpackproblem/BackPack01.java)

    给你一个可装载重量为W的背包和N个物品，每个物品有重量和价值两个属性。
    其中第i个物品的重量为wt[i]，价值为val[i]，现在让你用这个背包装物品，最多能装的价值是多少？
    
    举个简单的例子，输入如下：
    N = 3, W = 4
    wt = [2, 1, 3]
    val = [4, 2, 3]
    
    想比较凑零钱问题，这2个类型很相似, 只不过这里在比较的时候不是 dp[i - 1] + 1 而是
    转换成价值的val数组的具体比较
    
  - [4.2 分割等和子集](algo_dynamic_pro/src/main/java/backpackproblem/SplitEqualSubSet.java)
 ```python
    给定一个只包含正整数的非空数组。是否可以将这个数组分割成两个子集，使得两个子集的元素和相等。

    定义dp数组：dp[i][j] = x表示，对于前i个物品，当前背包的容量为j时，若x为true，
    则说明可以恰好将背包装满，若x为false，则说明不能恰好将背包装满。
```  
 - [4.3 完全背包问题](algo_dynamic_pro/src/main/java/backpackproblem/CompleteBackPackproblem.java)
        
 ```python
    给定不同面额的硬币和一个总金额，写出函数计算可以凑成总金额的硬币组合,每一种面额的硬币由无限个
    --》 转换下描述：有一个背包，最大容量为amount，有一系列物品coins，每个物品的重量为coins[i]，每个物品的数量无限。
        请问有多少种方法，能够把背包恰好装满？
    
```
  #### [5.贪心类型问题](algo_dynamic_pro/src/main/java/greedyproblem)
        什么是贪心算法呢？贪心算法可以认为是动态规划算法的一个特例，相比动态规划，使用贪心算法需要满足更多的条件（贪心选择性质），但是效率比动态规划要高。
        简单说就是：每一步都做出一个局部最优的选择，最终的结果就是全局最优。注意，这是一种特殊性质，其实只有一小部分问题拥有这个性质。
        如果满足贪心选择性质，那么可以进一步降低时间复杂度，达到线性级别的。

 - [5.1 Interval Scheduling（区间调度问题）](algo_dynamic_pro/src/main/java/greedyproblem/IntervalSchedulProblem.java)
        
        给你很多形如[start,end]的闭区间，请你设计一个算法，算出这些区间中最多有几个互不相交的区间。
        举个例子，intvs=[[1,3],[2,4],[3,6]]，这些区间最多有两个区间互不相交，即[[1,3],[3,6]]，你的算法应该返回 2。注意边界相同并不算相交。
        这个问题在生活中的应用广泛，比如你今天有好几个活动，每个活动都可以用区间[start,end]表示开始和结束的时间，
        请问你今天最多能参加几个活动呢？
        
 - [5.2 无重叠区间](algo_dynamic_pro/src/main/java/greedyproblem/NoIntervalSchedulProblem.java)
 
        给定一个区间集合,找到需要移出区间的最小数量,使得剩余区间相互不重叠
        区间数 - 重叠区间(即5.1的计算方式) = 【需要移出区间的最小数量】
        
 - [5.3 重叠区间个数](algo_dynamic_pro/src/main/java/greedyproblem/CountIntervalSchedulProblem.java)
 
        给定一个区间集合,找到重叠子区间的个数：如少的箭头射爆气球类问题
                             
 - [5.4 跳跃游戏 I](algo_dynamic_pro/src/main/java/greedyproblem/JumpGameV1.java)
 
        给定一个非负整数数组，你最初位于数组的第一个位置，数组中每个元素代表你在这个位置可以跳跃
        的最大长度，判断你是否能够跳跃到最后一个位置
        
 - [5.5 跳跃游戏 II](algo_dynamic_pro/src/main/java/greedyproblem/JumpGameV2.java)
  
         给定一个非负整数数组，你最初位于数组的第一个位置，数组中每个元素代表你在这个位置可以跳跃
         的最大长度，目标：最少跳跃次数到达最后一个位置 【前提保证一定能到达最后一个位置】
        
  #### [6.其他经典问题](algo_dynamic_pro/src/main/java/otherclassicpro)
  
  - [6.1 动态规划之正则表达式*](algo_dynamic_pro/src/main/java/otherclassicpro/RegularProblemAsterisk.java)
  
       给定一个字符串（s）和另一个字符模式（p）。使两者匹配 支持【*】【.】 

  - [6.2 动态规划之正则表达式·](algo_dynamic_pro/src/main/java/otherclassicpro/RegularProblemAsterisk.java)
  
       给定一个字符串（s）和另一个字符模式（p）。使两者匹配 支持【*】【.】 

 
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