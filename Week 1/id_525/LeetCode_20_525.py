class Solution:
    def isValid(self, s: str) -> bool:
        d = {')': '(', ']': '[', '}': '{'}
        stack = []
        for i in s:
            if i in d:
                if len(stack) == 0: return False
                item = stack.pop()
                if item != d[i]: return False
            else:
                stack.append(i)
        return len(stack) == 0
