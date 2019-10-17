# 给定 n 个非负整数，用来表示柱状图中各个柱子的高度。每个柱子彼此相邻，且宽度为 1 。
#
# 求在该柱状图中，能够勾勒出来的矩形的最大面积。
#
#
#
#
#
# 以上是柱状图的示例，其中每个柱子的宽度为 1，给定的高度为 [2,1,5,6,2,3]。
#
#
#
#
#
# 图中阴影部分为所能勾勒出的最大矩形面积，其面积为 10 个单位。
#
#
#
# 示例:
#
# 输入: [2,1,5,6,2,3]
# 输出: 10
# Related Topics 栈 数组


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def largestRectangleArea1(self, heights: list) -> int:
        """
        暴力法  超时
        :param heights:
        :return:
        """
        max_area = 0
        for i in range(len(heights)):
            print("i", i)
            for j in range(i, len(heights)):
                print("\tj", j)
                area = (j - i + 1) * min(heights[i:j + 1])
                if area > max_area:
                    max_area = area
        return max_area

    def largestRectangleArea2(self, heights: list) -> int:
        """
        暴力法加速  还是超时
        :param heights:
        :return:
        """
        max_area = 0
        # min_left_i = 0
        for i in range(len(heights)):
            left_i = i
            right_i = i

            while left_i >= 0 and heights[left_i] >= heights[i]:
                left_i -= 1

            # if heights[i] < heights[min_left_i]:
            #     min_left_i = i

            while right_i < len(heights) and heights[right_i] >= heights[i]:
                right_i += 1

            max_area = max(max_area, (right_i - left_i - 1) * heights[i])

            # if max_area == 12:
            #     print(max_area)

        return max_area

    def largestRectangleArea3(self, heights: list) -> int:
        """
        栈
        :param heights:
        :return:
        """
        stack = [-1]
        max_area = 0
        for i in range(len(heights)):
            while stack[-1] != -1 and heights[stack[-1]] >= heights[i]:
                area = heights[stack.pop()] * (i - stack[-1] - 1)
                if area > max_area:
                    max_area = area

            stack.append(i)

        # 最后栈可能不为空，所有要再做一遍
        while stack[-1] != -1:
            area = heights[stack.pop()] * (len(heights) - stack[-1] - 1)
            if area > max_area:
                max_area = area
        return max_area




# leetcode submit region end(Prohibit modification and deletion)

if __name__ == '__main__':
    s = Solution()
    print(s.largestRectangleArea3([2, 1, 5, 6, 2, 3]))
