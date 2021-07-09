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

#### [2.1 最低票价](algo_dynamic_pro/src/main/java/lowestfare) 
    火车票有三种不同的销售方式：
    
    一张为期一天的通行证售价为 costs[0] 美元；
    一张为期七天的通行证售价为 costs[1] 美元；
    一张为期三十天的通行证售价为 costs[2] 美元。
    通行证允许数天无限制的旅行。 例如，如果我们在第 2 天获得一张为期 7 天的通行证，那么我们可以连着旅行 7 天：第 2 天、第 3 天、第 4 天、第 5 天、第 6 天、第 7 天和第 8 天。
    返回你想要完成在给定的列表 days 中列出的每一天的旅行所需要的最低消费。
    
    输入：days = [1,4,6,7,8,20], costs = [2,7,15]
    输出：11
    解释： 
    例如，这里有一种购买通行证的方法，可以让你完成你的旅行计划：
    在第 1 天，你花了 costs[0] = $2 买了一张为期 1 天的通行证，它将在第 1 天生效。
    在第 3 天，你花了 costs[1] = $7 买了一张为期 7 天的通行证，它将在第 3, 4, ..., 9 天生效。
    在第 20 天，你花了 costs[0] = $2 买了一张为期 1 天的通行证，它将在第 20 天生效。
    你总共花了 $11，并完成了你计划的每一天旅行。

#### [3.最长递增子序列长度 LIS](algo_dynamic_pro/src/main/java/mostincrsubseq) 

     给定一个无序的整数数组,找到其中最长的递增子序列的长度
     >>> tip: 注意「子序列」和「子串」这两个名词的区别，子串一定是连续的，而子序列不一定是连续的

 - [dpTable模式](algo_dynamic_pro/src/main/java/mostincrsubseq/MostIncrSubseq.java)
 - [二分查找模式](algo_dynamic_pro/src/main/java/mostincrsubseq/MostIncrSubseq4BinarySearch.java)
 - [进阶问题:最大子序和](algo_dynamic_pro/src/main/java/mostincrsubseq/MostIncrSubseqSum.java) 在得到最大自序的基础上，并将这种情况列出来
 - [变种问题: 俄罗斯套娃/信封问题](algo_dynamic_pro/src/main/java/mostincrsubseq/EnvelopeProblem.java):这个其实是将原来的一维问题变成二维问题,当然也可以变成三维问题（套箱子）
 
 ##### [3.1 最大子数组和](algo_dynamic_pro/src/main/java/maxsubarraysum/MaximumSubArraySum.java) 
```
    给定一个整数数组nums,找到一个具有最大和的连续子数组(至少一个元素),返回其和
```
 
 ##### [3.2 最长公共子序列LCS](algo_dynamic_pro/src/main/java/mostcommsubseq/MostCommSubSeq.java) 
     最长公共子序列（Longest Common Subsequence，简称 LCS）是一道非常经典的面试题目，
     因为它的解法是典型的二维动态规划，大部分比较困难的字符串问题都和这个问题一个套路
     
     相比较而言就是上面斐波那契数列解题思路的扩展，由一维数组变成二维数组

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
        给定一个只包含正整数的非空数组。是否可以将这个数组分割成两个子集，使得两个子集的元素和相等。
        
        定义dp数组：dp[i][j] = x表示，对于前i个物品，当前背包的容量为j时，若x为true，
        则说明可以恰好将背包装满，若x为false，则说明不能恰好将背包装满。
 - [4.3 完全背包问题](algo_dynamic_pro/src/main/java/backpackproblem/CompleteBackPackproblem.java)
        
        给定不同面额的硬币和一个总金额，写出函数计算可以凑成总金额的硬币组合,每一种面额的硬币由无限个
            --》 转换下描述：有一个背包，最大容量为amount，有一系列物品coins，每个物品的重量为coins[i]，每个物品的数量无限。
            请问有多少种方法，能够把背包恰好装满？
            
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
  
  - [6.1 动态规划之正则表达式](algo_dynamic_pro/src/main/java/otherclassicpro/RegularProblem.java)
  
        给定一个字符串（s）和另一个字符模式（p）。使两者匹配 支持【*】【.】 

  - [6.2 经典动态规划：高楼扔鸡蛋](algo_dynamic_pro/src/main/java/otherclassicpro/ThrowEggs.java)
  
        若干层楼，若干个鸡蛋，让你算出最少的尝试次数，找到鸡蛋恰好摔不碎的那层楼。
        国内大厂以及谷歌脸书面试都经常考察这道题，
        只不过他们觉得扔鸡蛋太浪费，改成扔杯子，扔破碗什么的 
        
        １》动态规划+线性搜索 可以，但是会超时
        ２》动态规划＋二分搜索
  - [6.3 「Burst Balloon」经典动态规划：戳气球问题](algo_dynamic_pro/src/main/java/otherclassicpro/BurstBalloonProblem.java)
        
        有n个气球，编号为0到n-1，每个气球上都标有一个数字，这些数字存在数组nums中。
        现在要求你戳破所有的气球。如果你戳破气球i，就可以获得nums[left] * nums[i] * nums[right]个硬币。 
        这里的left和right代表和i相邻的两个气球的序号。
        注意当你戳破了气球i后，气球left和气球right就变成了相邻的气球。
        求所能获得硬币的最大数量。
        
        输入: [3,1,5,8]
        输出: 167 
        解释: nums = [3,1,5,8] --> [3,5,8] -->   [3,8]   -->  [8]  --> []
             coins =  3*1*5      +  3*5*8    +  1*3*8      + 1*8*1   = 167
  - [6.4 动态规划之博弈问题](algo_dynamic_pro/src/main/java/otherclassicpro/GameProblem.java)
        
        博弈问题
         你和你的朋友面前有一排石头堆，用一个数组 piles 表示，piles[i] 表示第 i 堆石子有多少个。
         你们轮流拿石头，一次拿一堆，但是只能拿走最左边或者最右边的石头堆。
         所有石头被拿完后，谁拥有的石头多，谁获胜。
        
        石头的堆数可以是任意正整数，石头的总数也可以是任意正整数，这样就能打破先手必胜的局面了。
        比如有三堆石头 piles = [1,100,3]，先手不管拿 1 还是 3，
        能够决定胜负的 100 都会被后手拿走，后手会获胜。
        
        【假设两人都很聪明，请你设计一个算法，返回先手和后手的最后得分（石头总数）之差。】
        比如上面那个例子，先手能获得 4 分，后手会获得 100 分，你的算法应该返回 -96
        
  - [6.5 4键键盘问题](algo_dynamic_pro/src/main/java/otherclassicpro/FourkeyboardProblem.java)
  
        四种按键:
        A : 在屏幕打印一个'A'
        C-A : 选中整个屏幕
        C-C : 复制
        C-V : 粘贴
        
        假设按键可以按N次，那么屏幕最多可以显示几个'A'?
       
  - [6.6 团灭 LeetCode 股票买卖问题](algo_dynamic_pro/src/main/java/otherclassicpro/StockTradingProblem.java) 
        
        
# [algo_backtracking 回溯算法](algo_backtracking)

####[1.全排列任意数据](algo_backtracking/src/main/java/fullarray/FullArrayMode.java)

        回溯算法的基本框架
        
        for 选择 in 选择列表：
            排除重复选择 --》将该选择从选择列表中排除 --》因为每次选择都是从nums的第一个元素开始
            做选择 --》将该选择加入当前选择的路径列中
            backtrack(选择列表,路径)
            路径.remove(选择) --》取消选择



####[2.N皇后问题]()

# [algo_data_structure 数据结构](algo_data_structure)

    数据结构的存储方式只有两种：数组（顺序存储）和链表（链式存储）。
    
    比如说「队列」、「栈」这两种数据结构既可以使用链表也可以使用数组实现。用数组实现，
        就要处理扩容缩容的问题；用链表实现，没有这个问题，但需要更多的内存空间存储节点指针。
    
    「图」的两种表示方法，邻接表就是链表，邻接矩阵就是二维数组。邻接矩阵判断连通性迅速，并可以进行矩阵运算解决一些问题，但是如果图比较稀疏的话很耗费空间。
        邻接表比较节省空间，但是很多操作的效率上肯定比不过邻接矩阵。
    
    「散列表」就是通过散列函数把键映射到一个大数组里。而且对于解决散列冲突的方法，拉链法需要链表特性，
        操作简单，但需要额外的空间存储指针；线性探查法就需要数组特性，以便连续寻址，不需要指针的存储空间，
        但操作稍微复杂些。
    
    「树」，用数组实现就是「堆」，因为「堆」是一个完全二叉树，用数组存储不需要节点指针，
        操作也比较简单；用链表实现就是很常见的那种「树」，因为不一定是完全二叉树，所以不适合用数组存储。
        为此，在这种链表「树」结构之上，又衍生出各种巧妙的设计，
        比如二叉搜索树、AVL 树、红黑树、区间树、B 树等等，以应对不同的问题。
     
    【数组】由于是紧凑连续存储,可以随机访问，通过索引快速找到对应元素，而且相对节约存储空间。
        但正因为连续存储，内存空间必须一次性分配够，所以说数组如果要扩容，需要重新分配一块更大的空间，
        再把数据全部复制过去，时间复杂度 O(N)；而且你如果想在数组中间进行插入和删除，
        每次必须搬移后面的所有数据以保持连续，时间复杂度 O(N)。
     
    【链表】因为元素不连续，而是靠指针指向下一个元素的位置，所以不存在数组的扩容问题；
        如果知道某一元素的前驱和后驱，操作指针即可删除该元素或者插入新元素，时间复杂度 O(1)。
        但是正因为存储空间不连续，你无法根据一个索引算出对应元素的地址，所以不能随机访问；
        而且由于每个元素必须存储指向前后元素位置的指针，会消耗相对更多的储存空间。
#### [链表系列]()
#####[1.递归反转链表:如何拆解复杂问题](algo_data_structure/src/main/java/reverselinked)

   - [单链表递归反转](algo_data_structure/src/main/java/reverselinked/RecurReverseLinkedLists.java)
   - [反转链表前 N 个节点](algo_data_structure/src/main/java/reverselinked/RecurPreNLinked.java)
   - [反转链表的一部分](algo_data_structure/src/main/java/reverselinked/RecurPartLinked.java)
   
    递归操作链表并不高效。和迭代解法相比，虽然时间复杂度都是 O(N)，但是迭代解法的空间复杂度是 O(1)，
    而递归解法需要堆栈，空间复杂度是 O(N)。所以递归操作链表可以作为对递归算法的练习或者拿去和小伙伴装逼
    
#####[2.递归思维：k 个一组反转链表](algo_data_structure/src/main/java/reverselinked/ReverseKGroup.java)

        给出一个链表，每 k 个节点一组进行翻转，并返回翻转后的链表。
        k 是一个正整数，它的值小于或等于链表的长度。如果节点总数不是 k 的整数倍，
        那么将最后剩余节点保持原有顺序。
        示例 :
        给定这个链表：1->2->3->4->5
        当 k = 2 时，应当返回: 2->1->4->3->5
        当 k = 3 时，应当返回: 3->2->1->4->5
#####[3.递归思维：如何高效判断回文单链表？](algo_data_structure/src/main/java/reverselinked/)

        待定.....


#### [二叉树Binary Tree系列](algo_data_structure/src/main/java/binarytreeseries)
    二叉树的算法思想的运用广泛，甚至可以说，只要涉及递归，都可以抽象成二叉树的问题
    经典算法「快速排序」和「归并排序」，对于这两个算法，你有什么理解？
    --> 快速排序就是个二叉树的前序遍历，归并排序就是个二叉树的后续遍历
        快速排序的逻辑是，若要对nums[lo..hi]进行排序，我们先找一个分界点p，
        通过交换元素使得nums[lo..p-1]都小于等于nums[p]，且nums[p+1..hi]都大于nums[p]，
        然后递归地去nums[lo..p-1]和nums[p+1..hi]中寻找新的分界点，最后整个数组就被排序了
        快速排序的代码框架如下：
        
        void sort(int[] nums, int lo, int hi) {
            /****** 前序遍历位置 ******/
            // 通过交换元素构建分界点 p
            int p = partition(nums, lo, hi);
            /************************/
        
            sort(nums, lo, p - 1);
            sort(nums, p + 1, hi);
        }
        先构造分界点，然后去左右子数组构造分界点 --> 对比二叉树的前序遍历
     
    --> 归并排序的逻辑，若要对nums[lo..hi]进行排序，我们先对nums[lo..mid]排序，
        再对nums[mid+1..hi]排序，最后把这两个有序的子数组合并，整个数组就排好序
        归并排序的代码框架如下：
        
        void sort(int[] nums, int lo, int hi) {
            int mid = (lo + hi) / 2;
            sort(nums, lo, mid);
            sort(nums, mid + 1, hi);
        
            /****** 后序遍历位置 ******/
            // 合并两个排好序的子数组
            merge(nums, lo, mid, hi);
            /************************/
        }
        先对左右子数组排序，然后合并（类似合并有序链表的逻辑） --》对比二叉树的后序遍历
##### [pre:二叉树遍历](algo_data_structure/src/main/java/binarytreeseries)
    /* 二叉树遍历框架 */
    void traverse(TreeNode root) {
        // 前序遍历
        traverse(root.left)
        // 中序遍历
        traverse(root.right)
        // 后序遍历
    }
##### [1.翻转二叉树](algo_data_structure/src/main/java/binarytreeseries/FlipBinaryTree.java)
##### [2.填充二叉树节点的右侧指针](algo_data_structure/src/main/java/binarytreeseries/)

        有点不懂题目意思，先不看了
##### [3.将二叉树展开为链表](algo_data_structure/src/main/java/binarytreeseries/Tree2Linked.java)

        给定一个二叉树，原地将它展开为一个单链表。
        例如，给定二叉树
        
            1
           / \
          2   5
         / \   \
        3   4   6
        
        将其展开为：
        1
         \
          2
           \
            3
             \
              4
               \
                5
                 \
                  6
##### [4.相同的树](algo_data_structure/src/main/java/binarytreeseries/TheSameTree.java)

        给定两个二叉树，编写一个函数来检验它们是否相同。
        如果两个树在结构上相同，并且节点具有相同的值，则认为它们是相同的。
        
        输入:       1         1
                  / \       / \
                 2   3     2   3
        
                [1,2,3],   [1,2,3]
        
        输出: true

##### [5.对称二叉树](algo_data_structure/src/main/java/binarytreeseries/SymmetricBinaryTree.java)

        给定一个二叉树，检查它是否是镜像对称的。
        例如，二叉树 [1,2,2,3,4,4,3] 是对称的。
            1
           / \
          2   2
         / \ / \
        3  4 4  3
        
        ==》将树分成左右两个子树 ,然后错位对比
         
##### [6.二叉树的最大深度](algo_data_structure/src/main/java/binarytreeseries/MaxDepthTree.java)

##### [7.构造最大二叉树](algo_data_structure/src/main/java/binarytreeseries/ConstLargestBinTree.java)

        给定一个不含重复元素的整数数组 nums 。一个以此数组直接递归构建的 最大二叉树 定义如下：
        二叉树的根是数组 nums 中的最大元素。
        左子树是通过数组中 最大值左边部分 递归构造出的最大二叉树。
        右子树是通过数组中 最大值右边部分 递归构造出的最大二叉树。
        返回有给定数组 nums 构建的 最大二叉树 。

        示例 1：输入：nums = [3,2,1,6,0,5]
               输出：[6,3,5,null,2,0,null,null,1]
 
##### [8.从前序与中序遍历序列构造二叉树](algo_data_structure/src/main/java/binarytreeseries/ConstLargestBinTree.java)

        根据一棵树的前序遍历与中序遍历构造二叉树。
        注意:
        你可以假设树中没有重复的元素。
        
        例如，给出前序遍历 preorder = [3,9,20,15,7]
                中序遍历 inorder = [9,3,15,20,7]
        
##### [9.通过后序和中序遍历结果构造二叉树](algo_data_structure/src/main/java/binarytreeseries/ConstLargestBinTree.java)
##### [10.寻找重复子树](algo_data_structure/src/main/java/binarytreeseries/FindDuplicateSubTree.java)
  
#### [⼆叉搜索树系列Binary Search Tree，后文简写 BST](algo_data_structure/src/main/java/binarysearchtree)
    
    特性：
        1、对于 BST 的每一个节点node，左子树节点的值都比node的值要小，右子树节点的值都比node的值大。
        2、对于 BST 的每一个节点node，它的左侧子树和右侧子树都是 BST。
    它构建起了数据结构领域的半壁江山，直接基于 BST 的数据结构有 AVL 树，红黑树等等，拥有了自平衡性质，
        可以提供 logN 级别的增删查改效率；还有 B+ 树，线段树等结构都是基于 BST 的思想来设计的。
    从做算法题的角度来看 BST，除了它的定义，还有一个重要的性质：BST 的中序遍历结果是有序的（升序）。
    ---》BST 相关的问题，要么利用 BST 左小右大的特性提升算法效率，要么利用中序遍历的特性满足题目的要求

##### [1.寻找第 K 小的元素](algo_data_structure/src/main/java/binarysearchtree/kthSmallest.java)

    给定一个二叉搜索树，编写一个函数 kthSmallest 来查找其中第 k 个最小的元素。
    说明：你可以假设 k 总是有效的，1 ≤ k ≤ 二叉搜索树元素个数。
    输入: root = [5,3,6,2,4,null,null,1], k = 3
           5
          / \
         3   6
        / \
       2   4
      /
     1
    输出: 3

##### [2.BST 转化累加树](algo_data_structure/src/main/java/binarysearchtree/ConvertBST2Sum.java)

    给出二叉 搜索 树的根节点，该树的节点值各不相同，请你将其转换为累加树（Greater Sum Tree），使每个节点 node 的新值等于原树中大于或等于 node.val 的值之和。
    提醒一下，二叉搜索树满足下列约束条件：
        节点的左子树仅包含键 小于 节点键的节点。
        节点的右子树仅包含键 大于 节点键的节点。
        左右子树也必须是二叉搜索树。

##### [3.判断 BST 的合法性](algo_data_structure/src/main/java/binarysearchtree/JudgingBSTLegal.java)

##### [4.在BST中搜索一个数](algo_data_structure/src/main/java/binarysearchtree/FindXBST.java)
##### [5.在BST中插入一个数](algo_data_structure/src/main/java/binarysearchtree/InsertXBST.java)
##### [6.在BST中删除一个数](algo_data_structure/src/main/java/binarysearchtree/DeleteXBST.java)
##### [7.用Git来讲讲二叉树最近公共祖先](algo_data_structure/src/main/java/binarysearchtree/DeleteXBST.java)

    给定一个二叉树, 找到该树中两个指定节点的最近公共祖先。
    百度百科中最近公共祖先的定义为：“对于有根树 T 的两个结点 p、q，最近公共祖先表示为一个结点 x，
        满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。
    
    输入: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1
    输出: 3
    解释: 节点 5 和节点 1 的最近公共祖先是节点 3。
    
    输入: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 4
    输出: 5
    解释: 节点 5 和节点 4 的最近公共祖先是节点 5。因为根据定义最近公共祖先节点可以为节点本身。
##### [8.完全二叉树的节点个数](algo_data_structure/src/main/java/binarysearchtree/NumsNodeCompeletBinTree.java)

#### [⼆叉堆Binary Heap系列]()
    ⼆叉堆Binary Heap其主要操作就两个， sink （下沉）和 swim （上浮），⽤以维护⼆叉堆的性
    质.其主要应⽤有两个，⾸先是⼀种排序⽅法「堆排序」，第⼆是⼀种很有⽤的数据结构「优先级队列」
     
    ⼆叉堆其实就是⼀种特殊的⼆叉树（完全⼆叉树）
    ⼆叉堆还分为最⼤堆和最⼩堆。最⼤堆的性质是：每个节点都⼤于等于它的两个⼦节点。
    类似的，最⼩堆的性质是：每个节点都⼩于等于它的⼦节点。

##### [1.从优先级队列开始]()
##### [2.数据流的中位数](algo_data_structure/src/main/java/binaryheap/MedianDataStream.java)
    
    中位数是有序列表中间的数。如果列表长度是偶数，中位数则是中间两个数的平均值。
    例如，
    [2,3,4] 的中位数是 3
    [2,3] 的中位数是 (2 + 3) / 2 = 2.5
    设计一个支持以下两种操作的数据结构：
    void addNum(int num) - 从数据流中添加一个整数到数据结构中。
    double findMedian() - 返回目前所有元素的中位数。
    链接：https://leetcode-cn.com/problems/find-median-from-data-stream

#### [LRU缓存机制](algo_data_structure/src/main/java/lru)
    
    运用你所掌握的数据结构，设计和实现一个  LRU (最近最少使用) 缓存机制 。
    实现 LRUCache 类：
    LRUCache(int capacity) 以正整数作为容量 capacity 初始化 LRU 缓存
    int get(int key) 如果关键字 key 存在于缓存中，则返回关键字的值，否则返回 -1 。
    void put(int key, int value) 如果关键字已经存在，则变更其数据值；如果关键字不存在，
        则插入该组「关键字-值」。当缓存容量达到上限时，它应该在写入新数据之前删除最久未使用的数据值，从而为新的数据值留出空间。
    
    进阶：你是否可以在 O(1) 时间复杂度内完成这两种操作？
#### [LFU缓存机制](algo_data_structure/src/main/java/lfu/LFUCache.java)

    LFU 算法相当于是淘汰访问频次最低的数据，如果访问频次最低的数据有多条，需要淘汰最旧的数据。把数据按照访问频次进行排序，而且频次还会不断变化
    
#### [单调栈](algo_data_structure/src/main/java/monotonicstack)
    
    单调栈实际上就是栈，只是利用了一些巧妙的逻辑，使得每次新元素入栈后，栈内的元素都保持有序（单调递增或单调递减）。
##### [1.下一个更大元素 I](algo_data_structure/src/main/java/monotonicstack/NextGreaterNumber.java)

    给你一个数组，返回一个等长的数组，对应索引存储着下一个更大元素，如果没有更大的元素，就存 -1
    比如说，输入一个数组nums = [2,1,2,4,3]，你返回数组[4,2,4,-1,-1]。
##### [2.一月有多少天](algo_data_structure/src/main/java/monotonicstack/DailyTemperatures.java)

    给你一个数组T，这个数组存放的是近几天的天气气温，你返回一个等长的数组，
    计算：对于每一天，你还要至少等多少天才能等到一个更暖和的气温；如果等不到那一天，填 0。
    
##### [3.如何处理环形数组](algo_data_structure/src/main/java/monotonicstack/CircularArray.java)

    比如输入一个数组[2,1,2,4,3]，你返回数组[4,2,4,-1,4]。
    拥有了环形属性，最后一个元素 3 绕了一圈后找到了比自己大的元素 4。

#### [单调队列](algo_data_structure/src/main/java/monotonicqueue)
    
    一个「队列」，只是使用了一点巧妙的方法，使得队列中的元素全都是单调递增（或递减）的

##### [1.滑动窗口最大值](algo_data_structure/src/main/java/monotonicqueue/MaxSlidingWindow.java)
    
    给你输入一个数组nums和一个正整数k，有一个大小为k的窗口在nums上从左至右滑动，请你输出每次窗口中k个元素的最大值。
   
##### [2.详解二叉堆，实现优先级队列](algo_data_structure/src/main/java/monotonicqueue/PriorityQueueByBinHeap.java)

    二叉堆（Binary Heap）没什么神秘，性质比二叉搜索树 BST 还简单。
    其主要操作就两个，sink（下沉）和swim（上浮），用以维护二叉堆的性质。
    其主要应用有两个，首先是一种排序方法「堆排序」，第二是一种很有用的数据结构「优先级队列」