class Solution:
    def firstUniqChar(self, s: str) -> int:
        # count = collections.Counter(s)
        # index = 0
        # for ch in s:
        #     if count[ch] == 1:
        #         return index
        #     else:
        #         index += 1       
        # return -1    
        chs='qwertyuiopasdfghjklzxcvbnm'
        return min([s.index(ch) for ch in chs if s.count(ch) == 1] or [-1])    