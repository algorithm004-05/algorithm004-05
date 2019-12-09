class Solution:
    def letterCombinations(self, digits: str) -> List[str]:
        if len(digits) == 0:
            return []
        digit_char_map = {
            "2" : "abc",
            "3" : "def",
            "4" : "ghi",
            "5" : "jkl",
            "6" : "mno",
            "7" : "pqrs",
            "8" : "tuv",
            "9" : "wxyz"
        }
        res_lst = []
        res_length = len(digits)

        def dfs(curr_index, curr_res):
            if curr_index == res_length:
                res_lst.append(curr_res)
                return
            for char in digit_char_map[digits[curr_index]]:
                dfs(curr_index+1, curr_res+char)
        dfs(0, "")
        return res_lst
