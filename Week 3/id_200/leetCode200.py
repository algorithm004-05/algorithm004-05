#200. 岛屿数量

class Solution:
    dx=[-1,1,0,0]
    dy=[0,0,-1,1]
    def numIslands(self, grid: List[List[str]]) -> int:
        if not grid or not grid[0]:return 0
        self.max_x=len(grid);self.max_y=len(grid[0]);self.grid=grid;
        self.visited=set()
        return sum([self.BFS(i,j)for i in range(self.max_x)for j in range(self.max_y)])
    
    def BFS(self,x,y):
        if not self._is_valid(x,y):
            return 0
        self.visited.add((x,y))
        q=collections.deque()
        q.append((x,y))
        while q:
            cur_x,cur_y=q.popleft()
            for i in range(4):
                new_x,new_y=cur_x+self.dx[i],cur_y+self.dy[i]
                if self._is_valid(new_x,new_y):
                    self.visited.add((x,y))
                    q.append((x,y))
        return 1
    
    def _is_valid(self,x,y):
        if x<0 or x>=self.max_x or y<0 or y>=self.max_y:
            return False
        if self.grid[x][y]=="0" or ((x,y) in self.visited):
            return False
        return True