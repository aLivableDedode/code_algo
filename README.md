# code_algo
# [algo_dynamic_pro 动态规划](algo_dynamic_pro)

[1.斐波那契数列构建:](algo_dynamic_pro/src/main/java/fiponachi)

[1.1.通过递归的方式](algo_dynamic_pro/src/main/java/fiponachi/Level1Recursive.java) :可行但是计算的时间复杂度高(O(2^n))

[1.2.通过备忘录模式](algo_dynamic_pro/src/main/java/fiponachi/Level2AideMemoire.java)
    :将计算的结果放入缓存的备忘录中，如果下次计算再次用的则无需重新从头开始计算

[1.3.通过dpTabel模式自下而上](algo_dynamic_pro/src/main/java/fiponachi/Level3DpTable.java)
    :通过从头开始计算每一个值，然后逐步推导到第N个值的方式，构建了一个数组
