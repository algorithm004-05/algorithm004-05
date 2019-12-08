# 一条包含字母 A-Z 的消息通过以下方式进行了编码：
#
# 'A' -> 1
# 'B' -> 2
# ...
# 'Z' -> 26
# 给定一个只包含数字的非空字符串，请计算解码方法的总数。
#
####  思路  第一反应 好像斐波那契数列啊.... 是逆推，或者1个字符，或者2个字符
##### 状态 ： 最后一个字母 或者由倒数第一个数字，或者由倒数两个数字来代替 f(n) = f(n-1)+f(n-2)，但是当f(n-2) > 2时，就不是字母了,需要考虑吗？。

###  斐波那契的写法： x,y = y,x+y

class Solution:
    def numDecodings(self,s):
        dp = [0]*len(s)
        if s[0] == "0"
            return 0
        else:
            dp[0] =1
        if len(s) == 1:
            return dp[-1]
        if s[1] != "0"
            dp[1] += 1
        if 10 <= int*s[:2]) <= 26:
            dp[1] +=1
        for i in range(2,len(s)):
            if s[i-1]+s[i] == "00":
                return 0
            if s[i] != "0":
                dp[i] += dp[i-1]
            if 10 <= int(s[i-1]+s[i]) <= 26:
                dp[i] += dp[i-2]
        return dp[-1]

class Solution:
    def numDecodings(self, s: str) -> int:
        dp = [0] * len(s)
        # 考虑第一个字母
        if s[0] == "0":
            return 0
        else:
            dp[0] = 1
        if len(s) == 1: return dp[-1]
        # 考虑第二个字母
        if s[1] != "0":
            dp[1] += 1
        if 10 <= int(s[:2]) <= 26:
            dp[1] += 1
        for i in range(2, len(s)):
            # 当出现连续两个0
            if s[i - 1] + s[i] == "00": return 0
            # 考虑单个字母
            if s[i] != "0":
                dp[i] += dp[i - 1]
            # 考虑两个字母
            if 10 <= int(s[i - 1] + s[i]) <= 26:
                dp[i] += dp[i - 2]
        return dp[-1]


####  看起来很高级的写法...

class Solution:
    def numDecodings(self, s: str) -> int:
        pp, p = 1, int(s[0] != '0')
        for i in range(1, len(s)):
            pp, p = p, pp * (9 < int(s[i-1:i+1]) <= 26) + p * (int(s[i]) > 0)
        return p
#
# 作者：QQqun902025048
# 链接：https://leetcode-cn.com/problems/decode-ways/solution/4-xing-python-dp-onshi-jian-o1kong-jian-by-qqqun90/
# 来源：力扣（LeetCode）
# 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。



###  可怕的光头哥的代码...
###  一行解决
def numDecodings(self, s):
    return reduce(lambda(v,w,p),d:(w,(d>'0')*w+(9<int(p+d)<27)*v,d),s,(0,s>'',''))[1]*1