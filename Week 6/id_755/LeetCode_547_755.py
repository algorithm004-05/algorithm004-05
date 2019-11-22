class disjoint_set:
    def __init__(self, num):
        self.array = [i for i in range(num)]
        
    def union(self, i, j):
        root_i = self.find(i)
        root_j = self.find(j)
        self.array[root_i] = root_j
        
    def find(self, i):
        root = i
        while root != self.array[root]:
            root = self.array[root]
        while i != root:
            tmp = i
            i = self.array[i]
            self.array[tmp] = root
        return root
        
class Solution:
    def findCircleNum(self, M: List[List[int]]) -> int:
        num = len(M)
        if num == 0:
            return 0
        dset = disjoint_set(num)
        
        n_row = len(M)
        n_col = len(M[0])
        for i in range(n_row):
            for j in range(n_col):
                if M[i][j] == 1:
                    dset.union(i, j)
        return len(set([dset.find(i) for i in dset.array]))