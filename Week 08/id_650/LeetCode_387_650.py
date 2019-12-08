from collections import OrderedDict 
class Solution:
    def firstUniqChar(self, s: str) -> int:

        if not s: return -1

        str_map = OrderedDict()

        for i in range(len(s)):
            char = s[i]
            if char in str_map:
                str_map[char] = -1
            else:
                str_map[char] = i
        
        # if not str_map:return -1
        for char in str_map:
            if str_map[char] != -1:
                return str_map[char]
        return -1
        #return str_map[next(iter(str_map))]