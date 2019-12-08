class Solution(object):
    def generateParenthesis(self, n):
        """
        :type n: int
        :rtype: List[str]
        """
        if n == 0:
            return []
        
        res = []
        self.helper(n, n, '', res)
        return res
        
    def helper(self, left, right, ans, res):
        # recursion terminator
        if left > right:
            return 
        # process logic in this level
        if left == 0 and right == 0:
            res.append(ans)
        # drill down
        if left > 0:
            self.helper(left - 1, right, ans + '(', res)
        if right > 0:
            self.helper(left, right - 1, ans + ')', res)
        # reverse current level status if needed
