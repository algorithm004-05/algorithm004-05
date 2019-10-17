package com.geek.lee.leetcode.easy;
//给定一个数组，将数组中的元素向右移动 k 个位置，其中 k 是非负数。
//
// 示例 1:
//
// 输入: [1,2,3,4,5,6,7] 和 k = 3
//输出: [5,6,7,1,2,3,4]
//解释:
//向右旋转 1 步: [7,1,2,3,4,5,6]
//向右旋转 2 步: [6,7,1,2,3,4,5]
//向右旋转 3 步: [5,6,7,1,2,3,4]
//
//
// 示例 2:
//
// 输入: [-1,-100,3,99] 和 k = 2
//输出: [3,99,-1,-100]
//解释:
//向右旋转 1 步: [99,-1,-100,3]
//向右旋转 2 步: [3,99,-1,-100]
//
// 说明:
//
//
// 尽可能想出更多的解决方案，至少有三种不同的方法可以解决这个问题。
// 要求使用空间复杂度为 O(1) 的 原地 算法。
//
// Related Topics 数组

/**
 * 旋转数组
 */
public class Rotate189 {

    public void rotate(int[] nums, int k) {

        /**
         * 1. 暴力法
         * 看到题意想到的是,进行k次循环.
         * 在逐一遍历数组内元素,将数组右移
         * 时间复杂度：O(n*k)O(n∗k) 。每个元素都被移动 1 步（O(n)O(n)） k次（O(k)O(k)） 。
         * 空间复杂度：O(1)O(1) 。没有额外空间被使用。
         */

        if (k < 1) {
            return;
        }

        if (nums.length == 1) {
            return;
        }

//        for (int i = 0; i < k; i ++) {
//            // 首先获取到
//            int tail = nums[nums.length -1];
//            for (int j = 0; j < nums.length; j ++) {
//                int cur = nums[j];
//                nums[j] = tail;
//                tail = cur;
//            }
//        }

        /**
         * 2.反转法.
         * 当我们旋转数组 k 次， k%n 个尾部元素会被移动到头部，剩下的元素会被向后移动。
         * 首先将数组元素全部反转.
         * 再将前k个反转
         * 再将n-k反转
         */
//        k = k % nums.length;
//        reverse(nums, 0, nums.length -1);
//        reverse(nums, 0, k -1);
//        reverse(nums, k, nums.length -1);

        /**
         * 3. 成环法  还没搞清楚.
         */
        k = k % nums.length;
        int count = 0;
        for (int start = 0; count < nums.length; start++) {
            int current = start;
            int prev = nums[start];
            do {
                int next = (current + k) % nums.length;
                int temp = nums[next];
                nums[next] = prev;
                prev = temp;
                current = next;
                count++;
            } while (start != current);
        }


        for (int j = 0; j < nums.length; j ++) {
            System.out.println(nums[j]);
        }

    }

    private void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int tmp = nums[start];
            nums[start] = nums[end];
            nums[end] = tmp;
            start ++;
            end --;
        }
    }

    public static void main(String[] args) {
        new Rotate189().rotate(new int[] {1, 2, 3, 4, 5, 6, 7}, 3);
    }
}
