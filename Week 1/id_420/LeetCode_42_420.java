package geekbang.myleetcode.week01;

/**
 * lesson04
 */
public class LeetCode_42_420 {
    public static void main(String[] args) {
        int[] nums = new int[]{0,1,0,2,1,0,1,3,2,1,2,1};
        //int[] nums = new int[]{2,1};
        Solution solution = new LeetCode_42_420().new Solution();
        int amount = solution.trap(nums);
        System.out.println(amount);
    }

    class Solution {
        public int trap(int[] height) {
            if (null == height || 2 >= height.length) {
                return 0;
            }

            int water = 0;
            int leftIndex = 0;
            int rightIndex = height.length - 1;
            int leftMax = 0;
            int rightMax = 0;
            while (leftIndex <= rightIndex) {
                if (height[leftIndex] <= height[rightIndex]) {
                    if (height[leftIndex] >= leftMax) {
                        leftMax = height[leftIndex];
                    } else {
                        water += (leftMax - height[leftIndex]);
                    }
                    leftIndex ++;
                } else {
                    if (height[rightIndex] >= rightMax) {
                        rightMax = height[rightIndex];
                    } else {
                        water += (rightMax - height[rightIndex]);
                    }
                    rightIndex --;
                }
            }
            return water;
        }
    }
}
