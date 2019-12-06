import java.util.Stack;

/*
 * @lc app=leetcode id=42 lang=java
 *
 * [42] Trapping Rain Water
 *
 * https://leetcode.com/problems/trapping-rain-water/description/
 *
 * algorithms
 * Hard (45.14%)
 * Likes:    4657
 * Dislikes: 82
 * Total Accepted:    364.6K
 * Total Submissions: 805.8K
 * Testcase Example:  '[0,1,0,2,1,0,1,3,2,1,2,1]'
 *
 * Given n non-negative integers representing an elevation map where the width
 * of each bar is 1, compute how much water it is able to trap after raining.
 * 
 * 
 * The above elevation map is represented by array [0,1,0,2,1,0,1,3,2,1,2,1].
 * In this case, 6 units of rain water (blue section) are being trapped. Thanks
 * Marcos for contributing this image!
 * 
 * Example:
 * 
 * 
 * Input: [0,1,0,2,1,0,1,3,2,1,2,1]
 * Output: 6
 * 
 */

// @lc code=start
//左边界为非0开始
//右边界为最小值开始升值的最大值
//面积计算 (右边界-左边界)*min(左边界，右边界)-sum(边界内数)
//最右边界为0，结束

class Solution {
    public int trap(int[] height) {
        if(height == null){
            return 0;
        }

        int sum = 0;
        Stack<Integer> stack = new Stack<Integer>();

        int current = 0;

        while (current < height.length) {
            while(!stack.empty() && height[current] > height[stack.peek()]){

                int h = height[stack.peek()];
                stack.pop();
                if(stack.isEmpty()){
                    break;
                }

                int distance = current - stack.peek() - 1;
                int min = Math.min(height[stack.peek()],height[current]);
                sum = sum + distance * (min - h);

            }
            stack.push(current);
            current++;
        }
        return sum;
    }
}
// @lc code=end

