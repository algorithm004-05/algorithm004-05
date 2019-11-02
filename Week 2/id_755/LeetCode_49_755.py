class Solution:
    def groupAnagrams(self, strs: List[str]) -> List[List[str]]:
        # assume strs has n strings, each string has a length k
        # solution 1 : use tuple(sorted(string)) (immutable) as key
        # collections.Counter() is mutable!
        # time complexity O(n*k*logk)
        """res_lst = collections.defaultdict(list)
        for string in strs:
            res_lst[tuple(sorted(string))].append(string)
        return res_lst.values()"""
        # solution 2 : use abstract hashmap / hash map implemented by list
        # time complexity O(n*k)
        res_lst = collections.defaultdict(list)
        for string in strs:
            hashmap = [0] * 26
            for char in string:
                hashmap[ord(char) - ord("a")] += 1
            res_lst[tuple(hashmap)].append(string)
        return res_lst.values()