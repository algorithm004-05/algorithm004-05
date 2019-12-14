package algorithm00405test.week1.job.done;

import java.util.Arrays;

/**
 * 给定两个有序整数数组 nums1 和 nums2，将 nums2 合并到 nums1 中，使得 num1 成为一个有序数组。
 * <p>
 * 说明:
 * <p>
 * 初始化 nums1 和 nums2 的元素数量分别为 m 和 n。
 * 你可以假设 nums1 有足够的空间（空间大小大于或等于 m + n）来保存 nums2 中的元素。
 * 示例:
 * <p>
 * 输入:
 * nums1 = [1,2,3,0,0,0], m = 3
 * nums2 = [2,5,6],       n = 3
 * <p>
 * 输出: [1,2,2,3,5,6]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/merge-sorted-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LeetCode_88_510 {

    /**
     * 暴力
     * 空间复杂度
     * 时间复杂度
     *
     * @param nums1
     * @param m
     * @param nums2
     * @param n
     */
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        if (null == nums1 || null == nums2) {
            return;
        }

        // 合并数组
        int count = 0;
        while (n > count) {
            nums1[m + count] = nums2[count];
            count++;
        }

        // 选择排序
        int length = m + n;
        int min;
        for (int i = 0; i < length - 1; i++) {
            min = i;
            for (int j = i + 1; j < length; j++) {
                if (nums1[min] > nums1[j]) {
                    min = j;
                }
            }
            if (i != min) {
                int a = nums1[i];
                nums1[i] = nums1[min];
                nums1[min] = a;
            }
        }

    }


    /**
     * 无限制情况下 调用Java自带工具类
     * 空间复杂度
     * 时间复杂度
     *
     * @param nums1
     * @param m
     * @param nums2
     * @param n
     */
    public void merge1(int[] nums1, int m, int[] nums2, int n) {
        if (null == nums1 || null == nums2) {
            return;
        }
        System.arraycopy(nums2, 0, nums1, m, n);
        Arrays.sort(nums1);
    }

    /**
     * 双指针 从后开始比较
     * 空间复杂度
     * 时间复杂度
     *
     * @param nums1
     * @param m
     * @param nums2
     * @param n
     */
    public void merge2(int[] nums1, int m, int[] nums2, int n) {
        if (null == nums1 || null == nums2) {
            return;
        }

        int p1 = m - 1;
        int p2 = n - 1;
        int sum = m + n - 1;
        while (sum >= 0 && p1>=0 && p2>=0) {
            if (nums1[p1] > nums2[p2]){
                nums1[sum] = nums1[p1];
                p1--;
            } else {
                nums1[sum] = nums2[p2];
                p2--;
            }
            sum--;
        }

        if (p2 >= 0) {
            while (p2>=0){
                nums1[p2] = nums2[p2];
                p2--;
            }
        }
    }
}
