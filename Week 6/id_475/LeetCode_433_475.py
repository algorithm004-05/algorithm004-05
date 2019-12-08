# 最小基因变化
# 法一：单项BFS
class Solution:
    def minMutation(self, start: str, end: str, bank: List[str]) -> int:
        # 广度优先搜索
        bank = set(bank)  # 转换为set, in判断只需O(1)时间
        if end not in bank:  # 目标不可行，直接返回-1
            return -1
        q = [(start, 0)]  # 初始结点以及当前步数
        change = {'A': 'TCG', 'T': 'ACG', 'C': 'ATG', 'G': 'ATC'}  # 每个基因对应的可变换基因
        while q:  # 用队列实现广度优先
            node, step = q.pop(0)
            temp = step
            if node == end:  # 已经到达目标
                return step
            for i, v in enumerate(node):  # 当前序列的每一个基因
                for j in change[v]:  # 该基因可以改变的方式
                    new = node[:i]+j+node[i+1:]  # 改变后的序列
                    if new in bank:  # 如果该序列可行
                        step = temp
                        q.append((new, step+1))  # 入队，继续广度搜索
                        bank.remove(new)  # 避免重复遍历
        return -1  # 队列空了说明不可达

# 法二：双向BFS
class Solution:
    def minMutation(self, start: str, end: str, bank: List[str]) -> int:
        bank = set(bank)
        if end not in bank: # end不在基因库中，不可达
            return -1
        change = {'A':'CTG','T':'ACG','C':'ATG','G':'ATC'}
        front = set([start])
        back = set([end])
        dist = 1
        while front:
            dist += 1
            next_front = set()
            for node in bank:
                for j in change[v]:
                    new = node[:i] + j + node[i+1:]
                    if new in back:
                        return dist
                    if new in bank:
                        next_front.add(new)
                        bank.remove(new)
            front = next_front
            
            if len(back) < len(front):
                front, back = back, front
        return -1