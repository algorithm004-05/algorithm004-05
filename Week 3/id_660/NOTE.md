# NOTE

## 深度优先搜索与广度优先搜索

### 深度优先（DFS）
对每一个可能的分支路径深入到不能再深入为止，而且每个节点只能访问一次。

```java
    public void depthFirstSearch() {
        Stack<Map<String, Object>> nodeStack = new Stack<>();
        Map<String, Object> node = new HashMap<>();
        nodeStack.add(node);
        while (!nodeStack.isEmpty()) {
            node = nodeStack.pop();
            System.out.println(node);
            //获取节点的所有子节点
            List<Map<String, Object>> children = getChildren(node);
            if (children != null && !children.isEmpty()) {
                for (Map child : children) {
                    nodeStack.push(child);
                }
            }
        }
    }
```
### 广度优先（BFS）
对每一层节点依次访问，访问完一层进入下一层，而且每个节点只能访问一次。
```java
public void breadthFirst() {
    Deque<Map<String, Object>> nodeDeque = new ArrayDeque<>();
    Map<String, Object> node = new HashMap<>();
    nodeDeque.add(node);
    while (!nodeDeque.isEmpty()) {
        node = nodeDeque.peekFirst();
        System.out.println(node);
        List<Map<String, Object>> children = getChildren(node);
        if (children != null && !children.isEmpty()) {
            for (Map child : children) {
                nodeDeque.add(child);
            }
        }
    }
}
````

## 贪心算法
贪心算法是一种在每一步选择中都采取在当前状态下最好或最优（即最有 利）的选择，从而希望导致结果是全局最好或最优的算法。

贪心算法的实用场景较少，前提是：问题能够分解成子问题来解决，子问题的最优解能递推到最终问题的最优解。

与动态规划不同的地方在于：动态规划会保存之前的运算结果，有回退功能。


## 二分查找

```java
int left = 0;
int right = array.length - 1;
int mid = 0;
while ( left <= right) {
    mid = (left + right) / 2;
    if (array[mid] == target) {
        // 找到目标值
        return target;
    } else if (array[mid] < target) {
        left = mid + 1;
    } else {
        right = mid -1;
    }
}
```

使用二分查找，寻找一个半有序数组 [4, 5, 6, 7, 0, 1, 2] 中间无序的地方
``` java
    public static int findPoint(int[] array) {
        if (array == null) return -1;
        int left = 0;
        int right = array.length - 1;
        int mid;
        while (left < right) {
            mid = (left + right) / 2;
            if (array[mid] < array[right])
                right = mid;
            else
                left = mid + 1;
        }
        return array[left];
    }
```
