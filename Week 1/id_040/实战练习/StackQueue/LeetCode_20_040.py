# 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
#
# 有效字符串需满足：
#
#
# 左括号必须用相同类型的右括号闭合。
# 左括号必须以正确的顺序闭合。
#
#
# 注意空字符串可被认为是有效字符串。
#
# 示例 1:
#
# 输入: "()"
# 输出: true
#
#
# 示例 2:
#
# 输入: "()[]{}"
# 输出: true
#
#
# 示例 3:
#
# 输入: "(]"
# 输出: false
#
#
# 示例 4:
#
# 输入: "([)]"
# 输出: false
#
#
# 示例 5:
#
# 输入: "{[]}"
# 输出: true
# Related Topics 栈 字符串


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def isValid1(self, s: str) -> bool:
        """
        暴力法   不断替换符合要求的括号对，直到无法替换为止
        :param s:
        :return:
        """
        r1 = "()"
        r2 = "[]"
        r3 = "{}"
        rs = [r1, r2, r3]

        can_replace = True
        while s != "" and can_replace:
            can_replace = False
            for r in rs:
                if r in s:
                    s = s.replace(r, "")
                    can_replace = True

        return s == ""

    def isValid2(self, s: str) -> bool:
        """
        栈
        :param s:
        :return:
        """
        if len(s) % 2 == 1:
            return False

        s_map = {
            ")": "(",
            "]": "[",
            "}": "{"
        }

        stack = []
        for i in s:
            if i in s_map:
                if len(stack) == 0:
                    return False
                j = stack.pop()
                if j != s_map.get(i):
                    return False
            else:
                stack.append(i)

        return len(stack) == 0


# leetcode submit region end(Prohibit modification and deletion)

if __name__ == '__main__':
    s = Solution()
    v = "(("
    print(s.isValid2(v))
