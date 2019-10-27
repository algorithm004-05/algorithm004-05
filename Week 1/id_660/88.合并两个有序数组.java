/*
 * @lc app=leetcode.cn id=88 lang=java
 *
 * [88] 合并两个有序数组
 *
 * https://leetcode-cn.com/problems/merge-sorted-array/description/
 *
 * algorithms
 * Easy (45.52%)
 * Likes:    330
 * Dislikes: 0
 * Total Accepted:    78.1K
 * Total Submissions: 171.4K
 * Testcase Example:  '[1,2,3,0,0,0]\n3\n[2,5,6]\n3'
 *
 * 给定两个有序整数数组 nums1 和 nums2，将 nums2 合并到 nums1 中，使得 num1 成为一个有序数组。
 * 
 * 说明:
 * 
 * 
 * 初始化 nums1 和 nums2 的元素数量分别为 m 和 n。
 * 你可以假设 nums1 有足够的空间（空间大小大于或等于 m + n）来保存 nums2 中的元素。
 * 
 * 
 * 示例:
 * 
 * 输入:
 * nums1 = [1,2,3,0,0,0], m = 3
 * nums2 = [2,5,6],       n = 3
 * 
 * 输出: [1,2,2,3,5,6]
 * 
 */

// @lc code=start
class Solution {

    // !! 根据 merge1中的方法，对空间进行优化：从长数组的空位开始塞数据
    public void merge(int A[], int m, int B[], int n) {
        int i = m - 1, j = n - 1, k = m + n - 1;
        while (i >= 0 && j >= 0) {
            A[k--] = A[i] > B[j] ? A[i--] : B[j--];
        }
        while (j >= 0) {
            A[k--] = B[j--];
        }
    }

    // 根据有序条件进行插入
    public void merge1(int[] nums1, int m, int[] nums2, int n) {

        int[] temp = new int[m];
        System.arraycopy(nums1, 0, temp, 0, m);

        int p1 = 0, p2 = 0, p = 0;

        while ((p1 < m) && (p2 < n))
            nums1[p++] = (temp[p1] < nums2[p2]) ? temp[p1++] : nums2[p2++];

        if (p1 < m)
            System.arraycopy(temp, p1, nums1, p1 + p2, m + n - p1 - p2);
        if (p2 < n)
            System.arraycopy(nums2, p2, nums1, p1 + p2, m + n - p1 - p2);
        }
    }

// @lc code=end
