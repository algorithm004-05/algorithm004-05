class Solution:
    def permute(self, nums: List[int]) -> List[List[int]]:
        # check whether nums is None or not
        res_lst = []
        def dfs(curr_lst):
            if len(curr_lst) == len(nums):
                res_lst.append(curr_lst)
                return
            for value in nums:
                if value not in curr_lst:
                    dfs(curr_lst+[value])
        dfs([])
        return res_lst
# time complexity : O(n!)
# space complexity : O(n!)
