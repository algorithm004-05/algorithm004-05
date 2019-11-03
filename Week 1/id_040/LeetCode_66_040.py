#给定一个由整数组成的非空数组所表示的非负整数，在该数的基础上加一。
#
# 最高位数字存放在数组的首位， 数组中每个元素只存储单个数字。
#
# 你可以假设除了整数 0 之外，这个整数不会以零开头。
#
# 示例 1:
#
# 输入: [1,2,3]
#输出: [1,2,4]
#解释: 输入数组表示数字 123。
#
#
# 示例 2:
#
# 输入: [4,3,2,1]
#输出: [4,3,2,2]
#解释: 输入数组表示数字 4321。
#
# Related Topics 数组



#leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def plusOne(self, digits: list) -> list:
        """
        直接加
        :param digits:
        :return:
        """
        rdata = []
        plus_i = len(digits) - 1
        while plus_i >= 0:
            digits[plus_i] += 1
            if digits[plus_i] >= 10:
                digits[plus_i] = 0
                plus_i -= 1
                continue
            else:
                break

        if plus_i < 0:
            rdata.append(1)
            rdata.extend(digits)
        else:
            rdata = digits

        return rdata



#leetcode submit region end(Prohibit modification and deletion)
if __name__ == '__main__':
    s = Solution()

    digits = [9]

    print(s.plusOne(digits))
