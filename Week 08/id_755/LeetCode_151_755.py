class Solution:
    def reverseWords(self, s: str) -> str:
        s = s.strip()
        word_lst = s.split()
        if len(word_lst) == 0:
            return ""
        left = 0
        right = len(word_lst) - 1
        while left < right:
            word_lst[left], word_lst[right] = word_lst[right], word_lst[left]
            left += 1
            right -= 1
        return " ".join(word_lst)
