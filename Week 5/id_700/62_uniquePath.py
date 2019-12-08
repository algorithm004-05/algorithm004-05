# 一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为“Start” ）。
#
# 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为“Finish”）。
#
# 问总共有多少条不同的路径？
#
# 来源：力扣（LeetCode）
# 链接：https://leetcode-cn.com/problems/unique-paths
# 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。


#####  一维数组 减少内存空间的使用


class Solution:
    def uniquePaths(self,m,n):
        cur = [1]*n #### 将最后一行的1值存储起来
        for i in range(1，m):
            for j in range(1,n):
                cur[j] += cur[j-1]
        return cur[-1]

