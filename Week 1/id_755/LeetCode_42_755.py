# time complexity: O(n)
# space complexity: O(n)


class Solution:
    def trap(self, height: List[int]) -> int:
        def left_scan(height):
            left_height = []
            max_height = 0
            for h in height:
                if h > max_height:
                    max_height = h
                left_height.append(max_height)
            return left_height

        def right_scan(height):
            right_height = []
            max_height = 0
            for h in height[::-1]:
                if h > max_height:
                    max_height = h
                right_height.insert(0, max_height)
            return right_height

        left_height = left_scan(height)
        right_height = right_scan(height)
        water = 0
        i = 0
        while i < len(height):
            water += max(0, min(left_height[i], right_height[i]) - height[i])
            i += 1
        return water
