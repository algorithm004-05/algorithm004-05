/*
 * @lc app=leetcode.cn id=42 lang=java
 *
 * [42] 接雨水
 */

// @lc code=start
class Solution {
    public int trap(int[] height) {
        if(null == height || height.length == 1){
            return 0;
        }
        int capacity = 0;
        Stack<Integer> stack = new Stack<Integer>();
        stack.push(-1);
        for(int i = 0; i < heights.length; i++){
            while(stack.peek() != -1 && heights[i] < heights[stack.peek()]){
                capacity = Math.max(capacity, heights[stack.pop()] * (i - stack.peek() - 1));
            }
            stack.push(i);
        }

        while(stack.peek() != -1){
            capacity = Math.max(capacity, heights[stack.pop()] * (heights.length- stack.peek() - 1));
        }
        

        return capacity;
    }
}
// @lc code=end

