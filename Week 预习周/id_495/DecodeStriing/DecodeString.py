#!/anaconda3/bin/python
# -*- coding: utf-8 -*-

class Solution(object):

    @staticmethod
    def decodeString(s):
        num = ""
        stack = [["", 1]]
        for c in s:
            if c in "0123456789":
                num += c
            elif c == "[":
                stack.append(["",int(num)])
                num = ""
            elif c == "]":
                ss, k = stack.pop()
                stack[-1][0] += ss * k
            else:
                stack[-1][0] += c
        return stack[-1][0]


if __name__ == '__main__':
    print(Solution.decodeString("3[ab]2[bc]"))
    print(Solution.decodeString("30[a2[c]]"))
