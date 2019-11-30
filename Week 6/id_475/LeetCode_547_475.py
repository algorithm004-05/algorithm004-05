# 朋友圈
# 第一遍
# 并查集
class Solution:
    def findCircleNum(self, M: List[List[int]]) -> int:
        if not M: return 0

        n = len(M)
        p = [i for i in range(n)]  # 初始化并查集

        # 遍历矩阵
        for i in range(n):   
            for j in range(n):
                if M[i][j] == 1:  # 合并i,j
                    self._union(p, i, j)
        
        return len(set([self._parent(p, i) for i in range(n)])) # 遍历所有结点，看不同的parent有几个
    
    # 直接套用并查集模板
    def _union(self, p, i, j):
        p1 = self._parent(p, i)
        p2 = self._parent(p, j)
        p[p1] = p2
    
    def _parent(self, p, i):
        root = i
        while p[root] != root:
            root = p[root]
        while p[i] != i:
            x = i; i = p[i]; p[x] = root
        return root        