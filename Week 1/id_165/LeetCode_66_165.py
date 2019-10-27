# 给定一个由整数组成的非空数组所表示的非负整数，在该数的基础上加一。
#
# 最高位数字存放在数组的首位， 数组中每个元素只存储单个数字。
#
# 你可以假设除了整数 0 之外，这个整数不会以零开头。
#
# 示例 1:
#
# 输入: [1,2,3]
# 输出: [1,2,4]
# 解释: 输入数组表示数字 123。
#
#
# 示例 2:
#
# 输入: [4,3,2,1]
# 输出: [4,3,2,2]
# 解释: 输入数组表示数字 4321。
#
# Related Topics 数组


# leetcode submit region begin(Prohibit modification and deletion)
class Solution(object):
    def plus1(self, digits):
        """
        :type digits: List[int]
        :rtype: List[int]
        """

        digits.append(1)

        for i in range(len(digits) - 2, -1, -1):

            sum_digits = digits[i + 1] + digits[i]

            digits[i + 1] = sum_digits % 10
            digits[i] = sum_digits // 10

        return digits[1:] if digits[0] == 0 else digits


# 可支持加任意数
# class SolutionN(object):
#     def plusN(self, digits, n):
#         """
#         :type digits: List[int]
#         :rtype: List[int]
#         """
#
#         digits.append(n)
#
#         for i in range(len(digits) - 2, -1, -1):
#
#             sum_digits = digits[i + 1] + digits[i]
#
#             digits[i + 1] = sum_digits % 10
#             digits[i] = sum_digits // 10
#
#         return digits[1:] if digits[0] == 0 else digits


# leetcode submit region end(Prohibit modification and deletion)
