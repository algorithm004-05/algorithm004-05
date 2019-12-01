class Union(object):
    def __init__(self, n):
        '''
        父亲：[0,1,2,3,4,5……]
        元素  0 1 2 3 4 5……
        使用数组实现并查集，元素为下标，父亲为下标对应元素
        :param n:
        '''
        self.p = [i for i in range(n)]

    def union(self, i, j):
        '''
        将并查集中的元素进行合并
        :param i:
        :param j:
        :return:
        '''
        p1 = self.parent(i)
        p2 = self.parent(j)
        self.p[p1] = p2

    def parent(self, i):
        root = i
        while root != self.p[root]:
            root = self.p[root]
        # 路径压缩
        while self.p[i] != i:
            i, self.p[i] = self.p[i], root
        return root


class Solution(object):
    def findCircleNum(self, M):
        """
        :type M: List[List[int]]
        :rtype: int
        """
        if not M: return 0
        u = Union(len(M))
        for i in range(len(M)):
            for j in range(len(M[0])):
                if M[i][j] == 1 and i != j:
                    u.union(i, j)
        return len(set([u.parent(i) for i in range(len(M))]))
