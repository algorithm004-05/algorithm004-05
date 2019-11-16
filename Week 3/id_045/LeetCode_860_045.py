# @author:leacoder
# @des:  贪心 柠檬水找零

'''
cash 记录手中零钱数（5 10 20美元数量）
按照贪心算法去找零
'''


class Solution:
    def lemonadeChange(self, bills: List[int]) -> bool:
        cash = {"5":0,"10":0,"20":0}
        for bill in bills:
            cash[str(bill)] = cash[str(bill)] + 1
            if bill==10: # 需要找零 5
                if cash["5"] == 0:
                    return False
                else:
                    cash["5"] = cash["5"] - 1
            elif bill == 20: # 需要找零 15
                # 10 + 5
                if cash["5"] > 0 and cash["10"] > 0:
                    cash["5"] = cash["5"] - 1
                    cash["10"] = cash["10"] - 1
                elif cash["5"] > 2:   # 5+5+5
                    cash["5"] = cash["5"] - 3
                else:
                    return False
        return True