## 深度优先搜索、广度优先搜索的实现和特性

### 深度优先搜索（DFS）
递归写法
```python
visited = set() 

def dfs(node, visited):
if node in visited: # terminator
	# already visited 
	return 

	visited.add(node) 

	# process current node here. 
	...
	for next_node in node.children(): 
		if not next_node in visited: 
			dfs(next_node, visited)
```

非递归写法
```python
def DFS(self, tree): 

	if tree.root is None: 
		return [] 

	visited, stack = [], [tree.root]

	while stack: 
		node = stack.pop() 
		visited.add(node)

		process (node) 
		nodes = generate_related_nodes(node) 
		stack.push(nodes) 

	# other processing work 
	...
```
### 广度优先搜索（BFS）
```python
def BFS(graph, start, end):

	queue = [] 
	queue.append([start]) 
	visited.add(start)

	while queue: 
		node = queue.pop() 
		visited.add(node)

		process(node) 
		nodes = generate_related_nodes(node) 
		queue.push(nodes)

	# other processing work 
	...
```

## 贪心算法

贪心算法： 当下做局部最优判断

回溯： 能够回退

动态规划： 最优判断 + 能够回退。

## 二分查找

条件： 
1. 输入数据为有序数组（递增或递减）
2. 输入数据有上下限
3. 可通过索引访问

模板
```python
left, right = 0, len(array) - 1 
while left <= right: 
	  mid = (left + right) / 2 
	  if array[mid] == target: 
		    # find the target!! 
		    break or return result 
	  elif array[mid] < target: 
		    left = mid + 1 
	  else: 
		    right = mid - 1
```

```java
    private boolean search(int[] array, int target) {
        int left = 0;
        int right = array.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (array[mid] == target) {
                //find the target!!
//                break or return result
                return true;
            } else if (array[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return false;
    }
```

### 牛顿迭代法

https://www.beyond3d.com/content/articles/8/

```java
package xyz.isok.algorithm.geek;

/**
 * 使用二分查找，寻找一个半有序数组 [4, 5, 6, 7, 0, 1, 2] 中间无序的地方
 * 说明：同学们可以将自己的思路、代码写在第 3 周的学习总结中
 */
public class FindUnsortedIndex {

    public static void main(String[] args) {
//        int[] nums = {4, 5, 6, 7, 0, 1, 2};
        int[] nums = { 1, 0};
        FindUnsortedIndex search = new FindUnsortedIndex();
        System.out.println(search.find(nums));

    }

    private int find(int[] nums){
        //数组为空或长度小于1，则不存在排序一说
        if (nums == null || nums.length <= 1){
            return -1;
        }
        int left = 0, right = nums.length - 1;
        while (left <= right){
            int mid = left + (right - left)/2;
            //计算得到mid索引后，判断以该索引为中心，左右相邻的数据是否符合条件
            if (mid < right && nums[mid] > nums[mid + 1]){
                return mid + 1;
            }
            if (mid > 0 && nums[mid] < nums[mid - 1]){
                return mid;
            }
            //因为mid为中心的临界情况已经判断过，left和right赋值时，可以直接跳过mid
            if (nums[mid] > nums[left]){
                left = mid + 1;
            }else {
                right = mid - 1;
            }
        }
        return -1;

    }
}
```