package com.geek.lee.leetcode.hard;
//给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
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


/**
 * 42. 接雨水
 */
public class Trap42 {
    public int trap(int[] height) {

        /**
         * 1.暴力法
         * 看到题后第一想法,遍历数组.从第一个元素向后遍历
         * 直到碰到比自己高的.期间计算每一个元素之外的左右最大高度.
         * 计算当前元素与左右最大高度小者的差 即时面积
         * 时间复杂度: O(n^2) 嵌套遍历两次数组
         * 空间福再度: O(1) 使用常量数值空间
         */

        int area = 0;
        for (int i = 0; i <height.length; i ++) {

            int maxLeft = 0;
            for (int j = i - 1 ; j >= 0; j --) {
                maxLeft = Math.max(height[j], maxLeft);
            }

            int maxRight = 0;
            for (int j = i + 1; j < height.length; j++) {
                maxRight =Math.max(height[j], maxRight);
            }

            int min = Math.min(maxLeft, maxRight);
            if (height[i] < min) {
                area += (min - height[i]);
            }
        }

        return area;
    }

    public static void main(String[] args) {
        System.out.println(new Trap42().trap(new int[]{0,1,0,2,1,0,1,3,2,1,2,1}));

    }
}
