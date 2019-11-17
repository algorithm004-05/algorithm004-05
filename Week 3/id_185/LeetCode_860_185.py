class Solution:
    def lemonadeChange(self, bills: List[int]) -> bool:
        five_count, ten_count = 0, 0
        
        for bill in bills:
            if bill == 5:
                five_count += 1
            elif bill == 10:
                if five_count == 0: return False
                else:
                    five_count -= 1
                    ten_count += 1
            else:
                if ten_count > 0:
                    if five_count > 0:
                        five_count -= 1
                        ten_count -= 1
                    else: return False
                else:
                    if five_count >= 3:
                        five_count -= 3
                    else: return False
                    
        return True
