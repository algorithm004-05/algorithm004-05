package Leetcode_11_470;

public class Solution {

    public static void main(String[] args) {
        System.out.println("asdasd");
    }

    public int maxArea(int[] height) {

        int maxCapacity = 0;
        for (int i = 0, j = height.length - 1; i < j; ) {

            int minHeight = height[i] < height[j] ? height[i++] : height[j--];

            maxCapacity = Math.max(maxCapacity, (j - i + 1) * minHeight);

        }
        return maxCapacity;
    }
}
