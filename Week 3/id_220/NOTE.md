# NOTE

### 树、图查找

树/图的遍历查找本质上是依据节点之间的连接依次遍历  
关键在于每个节点仅遍历依次  
且特殊清情况下仅有一边节点时退化为链表（树/图 本质上是链表的升维）  
树的查找为递归过程

#### 深度优先 DFS

优先以节点继承链路进行遍历

#### 广度优先 BFS

更贴近人自然思考的查找方式  
通过逐层对每一层的节点进行遍历查找

### 贪心

以每步最优的考虑查找全局最优方案，不考虑上下文  
局限性较强，更重要的是对贪心方法有效的证明  
对一些特殊场景有效，需要考虑子问题的重复性与兼容性

### 二分查找

针对有序数据，算法本质为排非预期结果
通过折半收缩减小搜索区域

通用方式为计算中间位置，然后比较边界值来排除非预期区域

```Kotlin
fun search(result: IntArray, target: Int): Int {
    var startIndex = 0
    var endIndex = result.length().minus(1)
    while (start <= end) {
        val pivotIndex = startIndex.plus(endIndex).div(2)
        val pivotElement = result[pivotIndex]
        if (target == pivotElement) {
            return pivotIndex
        }

        if (target < pivotElement) {
            end = pivotIndex.minus(1)
        } else {
            start = pivotIndex.plus(1)
        }
    }
    return -1
}
```

