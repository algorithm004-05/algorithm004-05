# 给定一个由 '1'（陆地）和 '0'（水）组成的的二维网格，计算岛屿的数量。
# 一个岛被水包围，并且它是通过水平方向或垂直方向上相邻的陆地连接而成的。
# 你可以假设网格的四个边均被水包围。
#
# 示例 1:
#
# 输入:
# 11110
# 11010
# 11000
# 00000
#
# 输出: 1
#
# 来源：力扣（LeetCode）
# 链接：https://leetcode-cn.com/problems/number-of-islands
# 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

#####   思路  flood  fill，遇到"1"的时候，将其与其周边所有上下左右方向的"1"都用"0"替代，执行完毕后count +=1，
#####   深度优先搜索  &&&  广度优先写法
#####   x,y = [[-1,0],[1,0],[0,-1],[0,1]]  表示相邻的四个方向



##### 深度优先搜索 递归写法
class Solution:
    def numIslands(self, grid: List[List[str]]) -> int:
        #####  边界条件不要忘记了 ！！！
        if not grid:
            return 0
        row = len(grid)     ######行列不要忘了
        col = len(grid[0])
        count = 0

        def dfs(i,j):
            grid[i][j] = "0"
            for x, y in [[-1, 0], [1, 0], [0, -1], [0, 1]]:
                tmp_i = i + x
                tmp_j = j + y
                if 0 <= tmp_i < row and 0 <= tmp_j < col and grid[tmp_i][tmp_j] == "1":  #### 边界限定，搜索栅格时不会溢出
                    dfs(tmp_i, tmp_j)
        for i in range(row):
            for j in range(col):
                if grid[i][j] == "1":
                    dfs(i, j)
                    count += 1
        return count


#####  广度优先搜索
class Solution:
    def numIslands(self, grid: List[List[str]]) -> int:
        #####  边界条件不要忘记了 ！！！
        if not grid:
            return 0
        row = len(grid)     ######行列不要忘了
        col = len(grid[0])
        count = 0


        from collections import deque
        def BFS(i,j):

            queue= deque()
            queue.append((i,j))   #### 这里传入的是坐标（i，j)
            grid[i][j] ="0"
            while queue:
                i,j = queue.popleft()
                for x, y in [[-1, 0], [1, 0], [0, -1], [0, 1]]:
                    tmp_i = i + x
                    tmp_j = j + y
                    if 0 <= tmp_i < row and 0 <= tmp_j < col and grid[tmp_i][tmp_j] == "1":
                        grid[tmp_i][tmp_j] = "0"
                        queue.append(tmp_i,tmp_j)
        for i in range(row):
            for j in range(col):
                if grid[i][j] == "1":
                    BFS(i, j)
                    count += 1
        return count
