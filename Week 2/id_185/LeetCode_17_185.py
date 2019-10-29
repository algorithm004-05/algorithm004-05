class Solution:
    def letterCombinations(self, digits: str) -> List[str]:
        
        phone_dict = {"2": ["a", "b", "c"],
                      "3": ["d", "e", "f"],
                      "4": ["g", "h", "i"],
                      "5": ["j", "k", "l"],
                      "6": ["m", "n", "o"],
                      "7": ["p", "q", "r", "s"],
                      "8": ["t", "u", "v"],
                      "9": ["w", "x", "y", "z"]}


        def _letterCombinations(left, right):
            # terminator
            if left == right:
                return phone_dict[digits[left]]

            # divide
            mid = (left + right) // 2
            left_str = _letterCombinations(left, mid)
            right_str = _letterCombinations(mid + 1, right)

            # conquer
            return [ left_item + right_item for left_item in left_str for right_item in right_str]

        if len(digits) == 0: return []
        else: return _letterCombinations(0, len(digits) - 1)
