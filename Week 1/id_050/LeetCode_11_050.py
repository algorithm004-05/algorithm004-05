class Solution(object):
    def maxArea(self, height):
        """
        :type height: List[int]
        :rtype: int
        """
        max_area, left, right = 0, 0, len(height) - 1
        while left < right:
            if height[left] < height[right]:
                max_area, left = max(max_area, height[left] * (right - left)), left + 1
            else:
                max_area, right = max(max_area, height[right] * (right - left)), right - 1
        return max_area
