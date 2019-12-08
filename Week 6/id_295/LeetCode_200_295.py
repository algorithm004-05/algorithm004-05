# 给定一个由 '1'（陆地）和 '0'（水）组成的的二维网格，计算岛屿的数量。一个岛被水包围，并且它是通过水平方向或垂直方向上相邻的陆地连接而成的。你可以假设网格的四个边均被水包围。
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
# 示例 2:
#
# 输入:
# 11000
# 11000
# 00100
# 00011
#
# 输出: 3
#
# 来源：力扣（LeetCode）
# 链接：https://leetcode-cn.com/problems/number-of-islands
# 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
from typing import List


# 时间复杂度: O(m*n) 其中 m 和 n 分别为行数和列数。注意当使用路径压缩和排名结合并实现并查集时，并操作只需要消耗常数时间。
# 空间复杂度: O(m*n) 并查集数据结构需要的空间
class Solution:
    def numIslands(self, grid: List[List[str]]) -> int:
        if len(grid) == 0: return 0
        row = len(grid);
        col = len(grid[0])
        self.count = sum(grid[i][j] == '1' for i in range(row) for j in range(col))
        parent = [i for i in range(row * col)]

        def find(x):
            if parent[x] != x:
                return find(parent[x])
            return parent[x]

        def union(x, y):
            xroot, yroot = find(x), find(y)
            if xroot == yroot: return
            parent[xroot] = yroot
            self.count -= 1

        for i in range(row):
            for j in range(col):
                if grid[i][j] == '0':
                    continue
                index = i * col + j
                if j < col - 1 and grid[i][j + 1] == '1':
                    union(index, index + 1)
                if i < row - 1 and grid[i + 1][j] == '1':
                    union(index, index + col)
        return self.count