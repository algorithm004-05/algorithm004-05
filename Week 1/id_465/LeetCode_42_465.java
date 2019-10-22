package leetcode.jacf.tech;

public class TrappingRainWater {
    public static int trap(int[] height) {
        int leftPointer = 0;
        int rightPointer = height.length - 1;
        int leftMax = 0;//左边最高的柱子
        int rightMax = 0;//右边最高的柱子
        int area = 0;
        while (leftPointer < rightPointer) {
            if (height[leftPointer] < height[rightPointer]) {
                if (height[leftPointer] >= leftMax) {
                    leftMax = height[leftPointer];
                } else {
                    area += (leftMax - height[leftPointer]);
                }
                leftPointer++;
            } else {
                if (height[rightMax] >= rightMax) {
                    rightMax = height[rightPointer];
                } else {
                    area += (rightMax - height[rightPointer]);
                }
                rightPointer--;
            }
        }
        return area;
    }

}
