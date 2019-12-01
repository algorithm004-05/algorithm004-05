# using disjoint set
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
    
# using dfs
class Solution:
    def findCircleNum(self, M: List[List[int]]) -> int:
        n = len(M)
        if n == 0:
            return 0
        m = len(M[0])
        visited = set()
        count = 0
        
        def dfs(index, value):
            if index in visited or value == 0:
                return
            visited.add(index)
            neighbor_lst = M[index]
            for neighbor, access in enumerate(neighbor_lst):
                if neighbor not in visited and access == 1:
                    dfs(neighbor, access)

        for i in range(n):
            if i not in visited:
                dfs(i, 1)
                count += 1
        return count

# using bfs
class Solution:
    def findCircleNum(self, M: List[List[int]]) -> int:
        n = len(M)
        if n == 0:
            return 0
        m = len(M[0])
        queue = collections.deque()
        visited = set()
        count = 0
        for i in range(n):
            if i not in visited:
                queue.append(i)
                while queue:
                    node = queue.popleft()
                    visited.add(node)
                    node_lst = M[node]
                    for neighbor, access in enumerate(node_lst):
                        if neighbor not in visited and access == 1:
                            queue.append(neighbor)
                count += 1
        return count