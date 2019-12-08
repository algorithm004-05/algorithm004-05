class Solution:
    def longestValidParentheses(self, s: str) -> int:
        stack = [0]
        longest = 0
        
        for p in s:
            if p == "(":
                stack.append(0)
            else:
                if len(stack) > 1:
                    val = stack.pop()
                    stack[-1] += val + 2
                    longest = max(longest, stack[-1])
                else:
                    stack = [0]
        return longest