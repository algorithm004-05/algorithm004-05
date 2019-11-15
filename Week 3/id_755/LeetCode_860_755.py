class Solution:
    def lemonadeChange(self, bills: List[int]) -> bool:
        money_had = collections.defaultdict(int)
        for b in bills:
            if b == 5:
                money_had[5] += 1
            elif b == 10:
                if money_had[5] >= 1:
                    money_had[5] -= 1
                    money_had[10] += 1
                else:
                    return False
            elif b == 20:
                if money_had[10] >= 1 and money_had[5] >= 1:
                    money_had[10] -= 1
                    money_had[5] -= 1
                    money_had[20] += 1
                # elif 10 not in money_had and money_had[5] >= 3:
                elif money_had[5] >= 3:
                    money_had[5] -= 3
                    money_had[20] += 1
                else:
                    return False
        return True
