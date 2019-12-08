
class Solution:
    def permuteUnique(self, nums: List[int]) -> List[List[int]]:
        res_lst = []
        def dfs(index_lst, curr_lst):
            if len(nums) == len(curr_lst) and curr_lst not in res_lst:
                res_lst.append(curr_lst)
                return
            for i, n in enumerate(nums):
                if i not in index_lst:
                    dfs(index_lst+[i], curr_lst+[n])
        dfs([], [])
        return res_lst
# time compelxity: ?
# space complexity: ?
