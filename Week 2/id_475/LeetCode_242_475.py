# 异位词：1.字母次数一样；2.次序不同
# 我的思路：hash 先判断1.字母次数是否一样：不一样false；
#                                  一样进入2.基本情况1）s="",t="";2)s="a",t="a";3)一般情况比如：s="ab",t="ba"
# 我自己辣鸡代码：
class Solution:
    def isAnagram(self,s,t):
        # 空字符情况
        if len(s) == 0:
            return True
        # 判断字母次数一样
        num_s = {}
        for i in s:
            if i in num_s:
                num_s[i] += 1
            else:
                num_s[i] = 1
        num_t = {}
        for j in t:
            if j in num_t:
                num_t[j] += 1
            else:
                num_t[j] = 1
        if len(num_s) >= len(num_t):
            for s in num_s:
                if s in num_t and num_s[s] == num_t[s]:
                    continue
                else:
                    return False
        if len(num_s) < len(num_t):
            for s in num_t:
                if s in num_s and num_s[s] == num_t[s]:
                    continue
                else:
                    return False
        # 判断次序是否相同
        if len(s) == 1:
            return True
        else:
            count = 0
            for i in range(len(s)):
                if s[i] == t[i]:
                    count += 1
            if count == len(s):
                return False
            else:
                return True
# 我的辣鸡代码在国际站找到了简洁代码
class Solution(object):
    def isAnagram(self, s, t):
        maps = {}
        mapt = {}
        for c in s:
            maps[c] = maps.get(c,0)+1
        for c in t:
            mapt[c] = mapt.get(c,0)+1
        return maps == mapt
# PS:1.get的用法：dict.get(key, default=None)返回指定键的值
#    2.return maps == mapt判断两个字典是否键值都相等（与顺序无关），相等返回true
#    3.为什么不需要判断次序???

# 老师的方法：法一：先判断2：sort; 再判断1：是否相等
class Solution:
    def isAnagram(self,s,t):
        return sorted(s) == sorted(t)
# PS:没有str.sort(),有sorted(str)

# 法二：hash,map统计每个字符的频次
# 初始状态数组全为0，让s出现的字符都让数组对应index的值+1，t出现的字符都让数组对应的index的值-1，那么如果s和t是两个字母异位的字符串，最终遍历结束这个数组内的所有值都应该还是为0
class Solution:
    def isAnagram(self, s: str, t: str) -> bool:
        dic = {}
        
        for i in s:
            if i in dic:
                dic[i] += 1
            else:
                dic[i] = 1
                
        for i in t:
            if i not in dic or dic[i] <= 0:
                return False
            dic[i] -= 1
        
        for i in dic:
            if dic[i] != 0:
                return False
        return True
# PS:1.本质上也是先判断字母次数是否一样；2.为啥不需要看次序是否一样？？？

# 另一种写法  
class Solution:
    def isAnagram(self, s: str, t: str) -> bool:
        if len(s) != len(t): return False
        counts = [0] * 26
        for a in s:
            counts[ord(a) - ord("a")] += 1
        for b in t:
            # 说明两个不一样
            if counts[ord(b) - ord("a")] <= 0:
                return False
            counts[ord(b) - ord("a")] -= 1
        return True
# PS：没有细看


