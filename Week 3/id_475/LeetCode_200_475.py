# 输入：[["1","1","1","1","0"],["1","1","0","1","0"],["1","1","0","0","0"],["0","0","0","0","0"]]
# 目标是找到上下左右相连的1，即为连续岛屿
# 第一遍
class Solution:
    def numIslands(self, grid: List[List[str]]) -> int:
        if not grid: 
            return 0
        row = len(grid)
        col = len(grid[0])
        cnt = 0

        # 自顶向下编程
        def dfs(i, j):
            # terminator
            if grid[i][j] == "0":
                return 
            # process current logic
            grid[i][j] = "0"
            # drill down
            for x, y in [[-1, 0], [1, 0], [0, -1], [0, 1]]:  # 向此点的上下左右做深度搜索
                tmp_i = i + x
                tmp_j = j + y
                if 0 <= tmp_i < row and 0 <= tmp_j < col and grid[tmp_i][tmp_j] == "1":  # 边界条件
                    dfs(tmp_i, tmp_j)

        for i in range(row):           # 这段代码体现总体思路：dfs作用是把1以及上下左右连环炸平，斩草除根，执行dfs完毕之后cnt加1，记作岛的数量
            for j in range(col):
                if grid[i][j] == "1":
                    dfs(i, j)  
                    cnt += 1
        return cnt