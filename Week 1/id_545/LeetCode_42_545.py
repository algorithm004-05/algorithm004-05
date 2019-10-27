## 接雨水
# 栈 时间：O(n) 空间： O(n)
class Solution:
    def trap(self, height: List[int]) -> int:
        stack = []
        area = 0
        for i in range(0, len(height)):
            while stack and height[i] > height[stack[-1]]:
                h = height[stack[-1]]
                stack.pop()
                if not stack:
                    break
                area += (min(height[i], height[stack[-1]]) - h) * (i - stack[-1] - 1)
                
            stack.append(i)
                
        return area