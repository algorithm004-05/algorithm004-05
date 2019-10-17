# 给定 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。在坐标内画 n 条垂直线，垂直线 i 的两个端点分别为 (i, ai) 和 (i, 0)。找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
#
# 说明：你不能倾斜容器，且 n 的值至少为 2。
#
#
#
# 图中垂直线代表输入数组 [1,8,6,2,5,4,8,3,7]。在此情况下，容器能够容纳水（表示为蓝色部分）的最大值为 49。
#
#
#
# 示例:
#
# 输入: [1,8,6,2,5,4,8,3,7]
# 输出: 49
# Related Topics 数组 双指针


# leetcode submit region begin(Prohibit modification and deletion)

class Solution:
    def maxArea1(self, height: list) -> int:
        """
        暴力求解，时间复杂度太高，leetcode提交未通过
        """

        areas = []
        m = 0
        for ii, i in enumerate(height):
            for ji, j in enumerate(height[ii + 1:], ii + 1):
                a = min(i, j) * abs(ii - ji)
                if a > m:
                    m = a
                areas.append(min(i, j) * abs(ii - ji))

        return m

    # 一维数组的坐标变换
    # 第一遍 2019年10月14日
    def maxArea2(self, height: list) -> int:
        """
        1. 从两边往中间收拢
        2. 如果靠外的高度小于靠内的高度，则不用计算了
        """
        max_area = 0
        i = 0
        j = len(height) - 1
        while i < j:
            h = 0
            if height[i] < height[j]:
                h = height[i]
                i += 1
            else:
                h = height[j]
                j -= 1

            area = h * (j - i + 1)
            if area > max_area:
                max_area = area

        return max_area


# leetcode submit region end(Prohibit modification and deletion)

if __name__ == '__main__':
    s = Solution()
    print(s.maxArea2([2, 3, 4, 5, 18, 17, 6]))
