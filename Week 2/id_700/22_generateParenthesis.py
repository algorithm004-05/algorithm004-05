# 给出 n 代表生成括号的对数，请你写出一个函数，使其能够生成所有可能的并且有效的括号组合。
#
# 例如，给出 n = 3，生成结果为：
#
# [
#   "((()))",
#   "(()())",
#   "(())()",
#   "()(())",
#   "()()()"
# ]
#
# 来源：力扣（LeetCode）
# 链接：https://leetcode-cn.com/problems/generate-parentheses
# 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

####  找最近重复性
####   递归模板

def generateParenthesis(level,n,s):
    #  terminal
    if level > 2 * n:
        return res
    ###  current logical level
    if level < 2 * n :
        s.append(level,"(",s1)
        s.append(level,")",s2)
    #### drill down
        generateParenthesis(level+1,s1)
        generateParenthesis(level+2,s2)
    ### reverse level


class Solution(object):
    def generateParenthesis(self, n):
        def generate(A = []):
            if len(A) == 2*n:
                if valid(A):
                    ans.append("".join(A))
            else:
                A.append('(')
                generate(A)
                A.pop()
                A.append(')')
                generate(A)
                A.pop()

        def valid(A):
            bal = 0
            for c in A:
                if c == '(': bal += 1
                else: bal -= 1
                if bal < 0: return False
            return bal == 0

        ans = []
        generate()
        return ans

class Solution(object):
    def generateParenthesis(self,n):
        def generate(A = []):
            if len(A) == 2 * n:
                if valid(A):
                    ans.append("".join(A))
            else:
                A.append('(')
                generate(A)
                A.pop()
                A.append(")")
                generate(A)
                A.pop()

        def valid(A):
            bal = 0
            for c in A :
                if c == '(':bal += 1
                else :
                    bal -= 1
                if bal < 0 :
                return Flase
            return bal == 0
        ans = []
        generate()
        return ans



#####  第二种解法，左右括号的数量判断


###  错误的写法
# class Solution(object):
#     def generateParenthesis(self,n):
#          A = []
#         def generate(S = '',left,right,n)
#         #### 终止条件 terminate
#             if left > n:
#                 A.append(S)
#                 return
#         if left < n:
#             A.append=(left,"(")
#         if right < left :
#             A.append=(right,")")
#             generate(left +1,right,"(")
#             generate(left,right +1,")")

class Solution(object):
    def generateParenthesis(self, N):
        ans = []
        def backtrack(S = '', left = 0, right = 0):
            if len(S) == 2 * N:
                ans.append(S)
                return
            if left < N:
                backtrack(S+'(', left+1, right)
            if right < left:
                backtrack(S+')', left, right+1)

        backtrack()
        return ans


class Solution:
    def generateParenthesis(self, n: int) -> List[str]:

        A = []

        def generate(S='', left=0, right=0):
            if len(S) == 2 * n:
                A.append(S)
                return
            if left < n:
                generate(S + '(', left + 1, right)
            if right < left:
                generate(S + ')', left, right + 1)

        generate()
        return A















