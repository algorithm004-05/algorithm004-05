class Solution(object):

    def numIslands(self, grid):
        self.dx = [-1, 1, 0, 0]
        self.dy = [0, 0, -1, 1]
        if not grid: return 0
        self.x_max, self.y_max, self.grid = len(grid), len(grid[0]), grid
        self.visited = set()
        return sum([self.floodfill_dfs(i, j) for i in range(self.x_max) for j in range(self.y_max)])

    def floodfill_dfs(self, x, y):

        if not self.valid(x, y):
            return 0
        self.visited.add((x, y))
        for k in range(4):
            self.floodfill_dfs(x + self.dx[k], y + self.dy[k])
        return 1

    def valid(self, x, y):
        if x < 0 or x >= self.x_max or y < 0 or y >= self.y_max:
            return False
        if self.grid[x][y] == "0" or ((x, y) in self.visited):
            return False
        return True
