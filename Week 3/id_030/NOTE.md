# NOTE

  

本周学习了深度优先搜索、广度优先搜索、贪心算法、二分查找
深度优先搜索是基于递归的实现
/**********深度优先搜索代码模板start********/
递归写法


visited = set() 
def dfs(node, visited):
if node in visited: # terminator//所有的节点都已经访问过，停止循环
	# already visited 
	return 

	visited.add(node) //将当前访问节点加入已经访问过节点集合

	# process current node here. 
	...
	for next_node in node.children(): //查找当前节点的叶子节点并进入下一层
		if not next_node in visited: 
			dfs(next_node, visited)


非递归写法
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
/**********深度优先搜索代码模板end********/

广度优先搜索通过队列实现
/**********广度优先搜索代码模板start********/
def BFS(graph, start, end):

	queue = [] 
	queue.append([start]) //将第一个节点放到队列中
	visited.add(start)//记录访问过的节点信息

	while queue: //循环队列直到队列为空
		node = queue.pop() //取出节点
		visited.add(node)//记录到已经访问过的节点信息中

		process(node) 
		nodes = generate_related_nodes(node) //找到节点的子节点
		queue.push(nodes)//将子节点放入队列中

	# other processing work 
	...
  /**********广度优先搜索代码模板end********/
  
  贪心算法：在每一步选择中都采取在当前状态下最好或者最优的选择，从而希望导致结果是全局最好或者最有的算法
  得到的结果一般接近最优解，作为辅助算法
  
  二分查找
  前提
  1.目标函数具有单调性
  2.存在上下界
  3.能够通过索引访问
  查询数据中间点数据，根据条件，每次查询过滤掉一半的数据，简化查询次数
  
  
  
  /*************二分查找模板start****************/
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
  /*************二分查找模板start****************/
