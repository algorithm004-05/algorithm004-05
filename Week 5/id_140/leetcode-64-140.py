#
# @lc app=leetcode.cn id=64 lang=python3
#
# [64] 最小路径和
#

# @lc code=start
class Solution:
    def minPathSum(self, grid):
        if(not grid):
            return 0
        m=len(grid)
        n=len(grid[0])
        for i in range(1,n):
            grid[0][i]+=grid[0][i-1]
        for j in range(1,m):
            grid[j][0]+=grid[j-1][0]
        for x in range(1,m):
            for y in range(1,n):
                grid[x][y]+=min(grid[x-1][y],grid[x][y-1])
        return grid[-1][-1]
if __name__ == '__main__':
	s = Solution()
	grid=[
 			[1,3,1],
			[1,5,1],
			[4,2,1]
		]	
	print(s.minPathSum(grid))