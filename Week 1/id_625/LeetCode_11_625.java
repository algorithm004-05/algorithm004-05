//给定 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。在坐标内画 n 条垂直线，垂直线 i 的两个端点分别为 (i, ai) 和 (i, 0)。找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。 
//
// 说明：你不能倾斜容器，且 n 的值至少为 2。 
//
// 
//
// 图中垂直线代表输入数组 [1,8,6,2,5,4,8,3,7]。在此情况下，容器能够容纳水（表示为蓝色部分）的最大值为 49。 
//
// 
//
// 示例: 
//
// 输入: [1,8,6,2,5,4,8,3,7]
//输出: 49 
// Related Topics 数组 双指针



//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int maxArea(int[] height) {
//        代码一：
//        左右边界，L, R，向中间收敛
//        int L = 0, R = height.length - 1, water = 0;
//        while (L < R){
//            water = height[L] < height[R] ?
//                    Math.max(water, (R - L) * height[L++]):
//                    Math.max(water, (R - L) * height[R--]);
//        }
//        return water;

//        代码二：
        int water = 0;
        for (int L = 0, R = height.length - 1; L < R) {
            int minHeight = height[L] < height[R] ? height[L ++]: height[R --];
            water = Math.max(water, minHeight * (R - L + 1));
        }
        return water

//        代码三：
//        枚举，O(n^2)
//        int water = 0;
//        for (int i = 0; i < height.length - 1; ++i) {
//            for (int j = i + 1; j < height.length; ++j) {
//                water = Math.max(water, (j - i) * Math.min(height[i], height[j]));
//            }
//        }
//        return water;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
