from collections import OrderedDict

class Solution:
    def firstUniqChar(self, s: str) -> int:
        if not s:
            return -1

        char_count = OrderedDict()
        for index, char in enumerate(s):
            if char in char_count:
                char_count[char] = -1
            else:
                char_count[char] = index

        for key, val in char_count.items():
            if val != -1:
                return val

        return -1
