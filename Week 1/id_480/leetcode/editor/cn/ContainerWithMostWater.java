package leetcode.editor.cn;
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

public class ContainerWithMostWater {
    public static void main(String[] args) {
        Solution2 solution1 = new ContainerWithMostWater().new Solution2();
        int[] heights = new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7};
        System.out.println(solution1.maxArea(heights));
    }


    /**
     * 暴力法
     */
    class Solution {
        public int maxArea(int[] height) {
            int maxArea = 0;
            for (int i = 0; i < height.length; i++) {
                for (int j = 0; j < height.length; j++) {
                    maxArea = Math.max(maxArea, (j - i) * Math.min(height[j], height[i]));
                }
            }
            return maxArea;
        }
    }

    /**
     * 双指针法
     */
    class Solution2 {
        public int maxArea(int[] height) {
            int maxArea = 0;
            int left = 0;
            int right = height.length - 1;
            while (left < right) {
                int lNum = height[left];
                int rNum = height[right];
                maxArea = Math.max(maxArea, Math.min(lNum, rNum) * (right - left));
                if (lNum < rNum) {
                    left++;
                } else {
                    right--;
                }
            }
            return maxArea;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}