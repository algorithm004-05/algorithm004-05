class Solution:
    def isAnagram(self, s: str, t: str) -> bool:
        # solution 1: return sorted(s) == sorted(t), time complexity : O(nlogn)
        # return sorted(s) == sorted(t)
        # solution 2: return collections.Counter(s) == collections.Counter(t) or
        return collections.Counter(s) == collections.Counter(t)
        # loop s and t, count the frequency of each char respecitively.
        """s_hashmap = {} # or collections.defaultdict(int)
        t_hashmap = {}
        for char in s:
            if char not in s_hashmap:
                s_hashmap[char] = 0
            s_hashmap[char] += 1
        for char in t:
            if char not in t_hashmap:
                t_hashmap[char] = 0
            t_hashmap[char] += 1
        return t_hashmap == s_hashmap
        s_hashmap = collections.defaultdict(int)
        t_hashmap = collections.defaultdict(int)
        for char in s:
            s_hashmap[char] += 1
        for char in t:
            t_hashmap[char] += 1
        return t_hashmap == s_hashmap"""