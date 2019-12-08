

##
 #假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
 #
 # 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
 #
 # 注意：给定 n 是一个正整数。
 #
 # 示例 1：
 #
 # 输入： 2
 # 输出： 2
 # 解释： 有两种方法可以爬到楼顶。
 # 1.  1 阶 + 1 阶
 # 2.  2 阶
 # 示例 2：
 #
 # 输入： 3
 # 输出： 3
 # 解释： 有三种方法可以爬到楼顶。
 # 1.  1 阶 + 1 阶 + 1 阶
 # 2.  1 阶 + 2 阶
 # 3.  2 阶 + 1 阶
 #
 # 来源：力扣（LeetCode）
 # 链接：https://leetcode-cn.com/problems/climbing-stairs
 # 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 #
class LeetCode_70_510:
     def climbStairs(self, n: int) -> int:
         if n <= 2: return n
         res = [0 for i in range(n)]
         res[0],res[1] = 1,2
         for i in range (2,n):
             res[i] = res[i-1] + res[i-2]
         return res[n-1]


max_1 = LeetCode_70_510().climbStairs(10)
print(max_1)

