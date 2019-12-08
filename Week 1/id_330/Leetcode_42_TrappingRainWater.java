
/**
 * 给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
 * 输入: [0,1,0,2,1,0,1,3,2,1,2,1]
 * 输出: 6
 */
public class Leetcode_42_TrappingRainWater {

    public static void main(String[] args) {
        int[] a = {0,1,0,2,1,0,1,3,2,1,2,1};
        int trap = trap1(a);
        System.out.println(trap);
    }

    /**
     * 方法一：穷举法、依次遍历每一个结点，求每一个索引值的左右两边最大值中最小的那个，高度差，切分成一条一条
     * 时间复杂度：O(n^2)、每一个结点都会左右遍历最大值。
     * @param height
     * @return int
     */
    public static int trap(int[] height) {
        int sum = 0;
        for (int i = 0; i < height.length; i++) {
//            定义左结点最高，右结点最高
            int leftMax = 0, rightMax = 0;
            for (int j = i; j > 0; j--) {
                // 向左找最大值
                leftMax = Math.max(leftMax, height[j]);
            }
            for (int j = i; j < height.length; j++) {
                // 向右找最大值
                rightMax = Math.max(rightMax, height[j]);
            }
            sum += Math.min(leftMax, rightMax) -height[i];
        }
        return sum;
    }
    /**
     * 既然在遍历的时候要遍历两边求最大值，那能不能在先把两边最大值存起来，先找到最大值再遍历
     * 时间复杂度：O(n)
     */
    public static int trap1(int[] height) {
        int sum = 0;

        int[] leftMaxs = new int[height.length];
        int[] rightMaxs = new int[height.length];

        leftMaxs[0] = height[0];
        for (int i = 1; i < height.length; i++) {
            leftMaxs[i] = Math.max(height[i], leftMaxs[i - 1]);
        }

        rightMaxs[height.length - 1] = height[height.length - 1];
        for (int i = height.length - 2; i >= 0; i--) {
            rightMaxs[i] = Math.max(rightMaxs[i + 1], height[i]);
        }

        for (int i = 0; i < height.length; i++) {
            sum += Math.min(rightMaxs[i], leftMaxs[i]) - height[i];
        }
        return sum;
    }



}
