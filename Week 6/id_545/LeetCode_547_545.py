## 547. 朋友圈
class UnionSet:
    def __init__(self, n):
        self.parent = [i for i in range(n)]

    def find(self, i):
        root = i
        while self.parent[root] != root:
            root = self.parent[root]
        while self.parent[i] != i:
            x, i = i, self.parent[i]
            self.parent[x] = root
        return root

    def union(self, i, j):
        p1, p2 = self.find(i), self.find(j)
        self.parent[p1] = p2

class Solution:
    def findCircleNum(self, M: List[List[int]]) -> int:
        n = len(M)
        u = UnionSet(n)
        for i in range(n):
            for j in range(n):
                if M[i][j] == 1:
                    u.union(i, j)

        return len(set([u.find(i) for i in range(n)]))