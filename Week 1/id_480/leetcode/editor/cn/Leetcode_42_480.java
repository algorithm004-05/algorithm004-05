package leetcode.editor.cn;  //给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
//
// 
//
// 上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的高度图，在这种情况下，可以接 6 个单位的雨水（蓝色部分表示雨水）。 感谢 Marcos 贡献此图。 
//
// 示例: 
//
// 输入: [0,1,0,2,1,0,1,3,2,1,2,1]
//输出: 6 
// Related Topics 栈 数组 双指针

public class Leetcode_42_480 {
    public static void main(String[] args) {
        Solution solution = new Leetcode_42_480().new Solution();
        int trap = solution.trap(new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1});
        System.out.println(trap);
    }


    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int trap(int[] height) {
            int ans = 0;
            int size = height.length;
            for (int i = 1; i < size - 1; i++) {
                int max_left = 0, max_right = 0;
                for (int j = i; j >= 0; j--) { //Search the left part for max bar size
                    max_left = Math.max(max_left, height[j]);
                }
                for (int j = i; j < size; j++) { //Search the right part for max bar size
                    max_right = Math.max(max_right, height[j]);
                }
                ans += Math.min(max_left, max_right) - height[i];
            }
            return ans;
        }
    }

    /**
     * 动态规划
     */
    class Solution2 {
        public int trap(int[] height) {
            int sum = 0;
            int[] max_left = new int[height.length];
            int[] max_right = new int[height.length];

            for (int i = 1; i < height.length - 1; i++) {
                max_left[i] = Math.max(max_left[i - 1], height[i - 1]);
            }
            for (int i = height.length - 2; i >= 0; i--) {
                max_right[i] = Math.max(max_right[i + 1], height[i + 1]);
            }
            for (int i = 1; i < height.length - 1; i++) {
                int min = Math.min(max_left[i], max_right[i]);
                if (min > height[i]) {
                    sum = sum + (min - height[i]);
                }
            }
            return sum;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}