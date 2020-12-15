# algo_backtracking
###由全排列演示回溯算法的基本框架

####[全排列任意数据](./fullarray/FullArrayMode.java)

```python
回溯算法的基本框架

for 选择 in 选择列表：
    排除重复选择 --》将该选择从选择列表中排除 --》因为每次选择都是从nums的第一个元素开始
    做选择 --》将该选择加入当前选择的路径列中
    backtrack(选择列表,路径)
    路径.remove(选择) --》取消选择

    
```

