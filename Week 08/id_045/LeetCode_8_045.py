# @author:leacoder
# @des:   字符串转换整数 (atoi)


class Solution:
    def myAtoi(self, str: str) -> int:
        if len(str) == 0:
            return 0
        ls = list(str.strip())  # 去掉空格

        sign = -1 if ls[0] == '-' else 1    # 正负数标记

        if ls[0] in ['-','+']:
            del ls[0]   # 处理符号位
        ret , i = 0, 0

        # 按下标处理数据
        while i < len(ls) and ls[i].isdigit():
            ret = ret * 10 + ord(ls[i]) - ord('0')  # ord 返回对应的 ASCII 数值
            i += 1

        # 最值处理
        return max(-2**31,min(sign*ret,2**31-1))
