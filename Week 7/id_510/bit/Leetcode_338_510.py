"""
给定一个非负整数 num。对于 0 ≤ i ≤ num 范围中的每个数字 i ，计算其二进制数中的 1 的数目并将它们作为数组返回。

示例 1:

输入: 2
输出: [0,1,1]
示例 2:

输入: 5
输出: [0,1,1,2,1,2]
进阶:

给出时间复杂度为O(n*sizeof(integer))的解答非常容易。但你可以在线性时间O(n)内用一趟扫描做到吗？
要求算法的空间复杂度为O(n)。
你能进一步完善解法吗？要求在C++或任何其他语言中不使用任何内置函数（如 C++ 中的 __builtin_popcount）来执行此操作。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/counting-bits
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
"""
from typing import List
class Solution:
    def countBits(self, num: int) -> List[int]:
        dp = [0 for _ in range(num+1)]
        #dp[i] = dp[i>>1] + (i & 1)  i 的1的个数位 i>>1 值 左移动一位  最后一位补0或1  则i&1 值位1 则末位数位1 
        for i in range(1,num+1):
            dp[i] = dp[i>>1] + (i & 1)
        return dp


    def countBits2(self, num: int) -> List[int]:
        dp = [0 for _ in range(num+1)]
        #dp[i] = dp[i & (i-1)] + 1   y = i & (i-1) 清除i的最低位1  则获取了对应值y的1的个数  然后+1 刚刚去掉的最低位1
        for i in range(1,num+1):
            dp[i] = dp[i & (i-1)] + 1
        return dp
