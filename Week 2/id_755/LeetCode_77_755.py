class Solution:
    def combine(self, n: int, k: int) -> List[List[int]]:
        if k <= 0 or n < k:
            return []
        res_lst = []

        def dfs(i, curr_lst):
            if len(curr_lst) == k:
                res_lst.append(curr_lst)
            for value in range(i, n+1):
                dfs(value+1, curr_lst+[value])
        dfs(1, [])
        return res_lst

# time complexity : O(n!)
# space complexity : O(k)
