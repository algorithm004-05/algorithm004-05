# 接雨水问题
# 雨水出现的地方：中间比左右两边低，具有最近相关性的问题，考虑用栈方法
# 雨水容量的计算：等于左右两边最大高度的较小值减去当前高度的值
class Solution:
    def trap(self, height: List[int]) -> int:
        if not height: return 0
        n = len(height)
        stack = []
        res = 0
        for i in range(n):
            while stack and height[stack[-1]] < height[i]:
                tmp = stack.pop()
                if not stack: break
                res += (min(height[i], height[stack[-1]]) - height[tmp]) * (i-stack[-1] - 1)
            stack.append(i)
        return res