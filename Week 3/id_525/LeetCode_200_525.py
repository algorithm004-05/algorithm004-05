class Solution:
    directions = [(-1, 0), (0, -1), (1, 0), (0, 1)]

    def numIslands(self, grid):
        count = 0
        x_len = len(grid)
        if not x_len:
            return count
        y_len = len(grid[0])
        marked = [[False for _ in range(y_len)] for _ in range(x_len)]
        for x in range(x_len):
            for y in range(y_len):
                if not marked[x][y] and grid[x][y] == '1':
                    count += 1
                    self.dfs(x, y, x_len, y_len, marked, grid)
        return count

    def dfs(self, x, y, x_len, y_len, marked, grid):
        marked[x][y] = True
        for i in self.directions:
            new_x = i[0] + x
            new_y = i[1] + y
            if 0 <= new_x < x_len and 0 <= new_y < y_len and not marked[new_x][new_y] and grid[new_x][new_y] == '1':
                self.dfs(new_x, new_y, x_len, y_len, marked, grid)

