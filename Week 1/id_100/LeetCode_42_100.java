import java.util.Stack;
/**
 * https://leetcode-cn.com/problems/trapping-rain-water/
 */
public class LeetCode_42_100 {
    /**
     * 利用栈存储数组索引进行操作
     * 实际上我们如果形成如下图这种形式，就表示有积水
     * ___
     * \  \   ____
     * \  \___\   \
     * \  \   \   \
     * ------------
     * 其成凹凸型，通俗的文字就是一旦坡度有升势，就会形成凹
     * 我们可在成升势的时候计算其面积即可
     *
     * 转化成栈操作的话就是，数组元素成降式时，直接push；如若是成升势时，
     * 取出栈顶元素，将其高度作为地基，计算当前元素与此刻栈顶元素之间所凹成的空间
     *
     * 时间复杂度为O(n),空间复杂度为O(n)
     * @param height
     * @return
     */
    static int trap(int[] height) {
        int maxArea = 0;
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < height.length; i++) {
            while (!stack.isEmpty() && height[i] > height[stack.peek()]) {
                int baseHeigth = height[stack.pop()];
                if (stack.isEmpty()) {
                    break;
                }
                int leftBound = height[stack.peek()];
                maxArea += (i - stack.peek() - 1) * (Math.min(height[i], leftBound) - baseHeigth);
            }
            stack.push(i);
        }
        return maxArea;
    }
}