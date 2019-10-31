class Solution:
    # 排序， 比较
    def isAnagram_1(self, s: str, t: str) -> bool:
        s = sorted(s)
        t = sorted(t)
        if s == t:
            return True
        else:
            return False

    # 纯haspmap 实现，先排除长度不等，元素不等的情况，再用hashmap记录，最后判断map中value是否为0
    def isAnagram_2(self, s: str, t: str) -> bool:
        if len(s) != len(t) or set(s) != set(t):
            return False
        Set = set(s)
        dict = {}

        for k in Set:
            dict[k] = 0
        for i in range(len(s)):
            dict[s[i]] += 1

        for i in range(len(t)):
            dict[t[i]] -= 1

        for key in dict.keys():
            if dict[key] != 0:
                return False
        return True

    # 用数组模拟hashmap 实现，将字母ascii 码转化为数组下标的方式作为 哈希函数，最后判读数组元素是否为0
    def isAnagram_3(self, s: str, t: str) -> bool:
        if len(s) != len(t):
            return False

        Counter = [0] * 26
        for i in range(len(s)):
            Counter[ord(s[i]) - ord('a')] += 1
            Counter[ord(t[i]) - ord('a')] -= 1

        for i, n in enumerate(Counter):
            if n != 0:
                return False
        return True

if __name__ == '__main__':
    testCase_s = "anagram"
    testCase_t = "nagaram"
    solution = Solution()
    print(solution.isAnagram_2(testCase_s, testCase_t))