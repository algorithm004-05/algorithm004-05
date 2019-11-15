# DFS & BFS
搜索算法包括
* 层优先
* 深度优先
* 优先级优先（更适合现实业务场景e.g.推荐系统） / 启发式（heuristic）
本门课程中所讨论的搜索算法不包括启发式搜索算法。而层优先和深度优先所要做到的就是
* 访问每个点
* 每个点访问一次
## DFS
模版1（将是否visited条件判断置于循环之后，进入下一层递归之前）
```python
visited = set()
def dfs(node, visited):
	visited.add(node)
	# process current node here
	...
	for next_node in node.children():
		if not next_node in visted:
			dfs(next_node, visited)
```
模版2（两次判断是否visited）
```python
visited = set()
def dfs(node, visited):
	if node in visited:
		return
	visited.add(node)
	# process current node here
	...
	for next_node in node.children():
		if not next_node in visited:
			dfs(next_node, visited)
```
模版3（stack）
```python
def dfs(tree):
	if tree.root is None:
		return []
	visited, stack = [], [tree.root]
	while stack:
		node = stack.pop()
		visited.add(node)
		process(node)
		nodes = generate_related_nodes(node)
		stack.push(nodes)
```
## BFS
```python
def bfs(graph, start, end):
	queue = []
	queue.append(start)
	visited.add(start)
	while queue:
		node = queue.pop()
		visited.add(node)
		process(node)
		nodes = generated_related_nodes(node)
		queue.push(nodes)
```
# 贪心
贪心和动态规划比较：
* 贪心：当下做局部最优解判断，不能回退
*高效，辅助办法（原因在于不需要考虑次优，无需递归/回溯）*
* 回溯：能够回退
* 动态规划：最优判断+回退 （保存之前结果并根据以前结果对当前进行选择，有回退功能）
想使用贪心则
* 保证能够得到全局最优解
* 巧妙构建贪心，从前往后，从后往前，或者从中间开始。

# 二分查找
二分查找的前提
* 目标函数单调 (monotonic)
* 存在上下届 (bounded)
* 能够通过索引访问（index accessible）# NOTE

## 寻找一个半有序数组[4, 5, 6, 7, 0, 1, 2]中间无序的地方
思路：找无序的地方其实就是找半有序数组的最小值，其实就是leetcode 153。
```python
class Solution:
    def findMin(self, nums: List[int]) -> int:
        left, right = 0, len(nums) - 1
        while left < right:
            mid = left + (right - left) // 2
            if nums[mid] < nums[right]:
                right = mid
            else:
                left = mid + 1
        return nums[left]
```
