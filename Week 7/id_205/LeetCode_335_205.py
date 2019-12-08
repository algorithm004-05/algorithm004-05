class Solution:
    def countBits(self, num: int) -> List[int]:
        target = [0]
        n = len(target)
        while n<=num+1:
            for i in range(n):
                target.append(target[i]+1)     
            n = len(target)
        return target[0:num+1]  