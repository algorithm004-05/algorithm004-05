class Solution:
    def findCircleNum(self, M: List[List[int]]) -> int:
        n = len(M)
        p = [i for i in range(n)]

        def _union(p, i, j):
            p1 = _parent(p, i)
            p2 = _parent(p, j)
            p[p1] = p2

        def _parent(p, i):
            root = i
            while p[root] != root:
                root = p[root]
            while p[i] != i:
                x = p[i];
                i = p[i];
                p[x] = root
            return root

        for i in range(n):
            for j in range(n):
                if M[i][j] == 1:
                    _union(p, i, j)

        return len(set([_parent(p, i) for i in range(n)]))

