"""
你的赛车起始停留在位置 0，速度为 +1，正行驶在一个无限长的数轴上。（车也可以向负数方向行驶。）

你的车会根据一系列由 A（加速）和 R（倒车）组成的指令进行自动驾驶 。

当车得到指令 "A" 时, 将会做出以下操作： position += speed, speed *= 2。

当车得到指令 "R" 时, 将会做出以下操作：如果当前速度是正数，则将车速调整为 speed = -1 ；否则将车速调整为 speed = 1。  (当前所处位置不变。)

例如，当得到一系列指令 "AAR" 后, 你的车将会走过位置 0->1->3->3，并且速度变化为 1->2->4->-1。

现在给定一个目标位置，请给出能够到达目标位置的最短指令列表的长度。

示例 1:
输入:
target = 3
输出: 2
解释:
最短指令列表为 "AA"
位置变化为 0->1->3
示例 2:
输入:
target = 6
输出: 5
解释:
最短指令列表为 "AAARA"
位置变化为 0->1->3->7->7->6
说明:

1 <= target（目标位置） <= 10000。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/race-car
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
"""

import sys
class Solution:
    def racecar1(self, target: int) -> int:
        dp = [sys.maxsize for _ in range(target + 1)]
        for i in range(1, target + 1):
            f, j, _l = 1, 1, 2 * i
            while j < _l:
                if i == j:
                    dp[i] = f  # 一致加速A
                    break
                elif i < j:
                    dp[i] = min(dp[i], f + 1 + dp[j - i])  # 一致加速A  超过目的地+f次  R反向+1次  距离j-i   +dp[j-i]返回目的地操作
                elif i > j:  # 未到达目的地  刹车反向 然后刹车 正向
                    for b in range(f):
                        k = (1 << b) - 1  # +f   R +1 然后反向+b  再R+1正向  偏离目的距离i-j+k  +dp[i - j + k]次
                        dp[i] = min(dp[i], f + 1 + b + 1 + dp[i - j + k])
                f += 1
                j = (1 << f) - 1
        #print(dp)
        return dp[-1]

    def racecar(self, target: int) -> int:
        def race(t):
            if t not in dp:
                n = t.bit_length()
                print(t,n)
                if (1 << n) - 1 == t:  # 如果刚好是全A指令就能到达的，如1/3/7
                    dp[t] = n
                else:  # 先n次A到达2^n-1后再R，已操作n+1次，然后转换为从2^n-1到t的正向问题的指令次数
                    dp[t] = n + 1 + race((1 << n) - 1 - t)
                    for m in range(n - 1):  # 2^m < 2^(n-1)
                        # 先n-1次A到达2^(n-1)-1后再R，然后m次A往回走，再R变为正向，已指令n-1+2+m次，
                        # 接着转换为剩余差值即t-(2^(n-1)-1)+(2^m-1)的正向问题即可
                        dp[t] = min(dp[t], n + m + 1 + race(t - (1 << n - 1) + (1 << m)))
            #print(dp)
            return dp[t]

        dp = {0: 0}
        return race(target)


a = 43
print(Solution().racecar(a), Solution().racecar1(a))
