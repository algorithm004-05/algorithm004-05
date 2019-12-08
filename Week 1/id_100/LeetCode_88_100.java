/**
 * https://leetcode-cn.com/problems/merge-sorted-array/
 */
public class LeetCode_88_100 {

    /**
     * 从头开始的双指针，仿照solution21两个有序链表的组装迭代法
     * 时间复杂度为O(m+n),需要额外开辟长度为m的数组，空间复杂度为O(m)
     * @param nums1
     * @param m
     * @param nums2
     * @param n
     */
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] temp = new int[m];
        System.arraycopy(nums1, 0, temp, 0, m);
        int i = 0, j = 0;
        int cur = 0;
        while (i < m && j < n) {
            if (temp[i] < nums2[j]) {
                nums1[cur++] = temp[i++];
            } else {
                nums1[cur++] = nums2[j++];
            }
        }
        while (i < m) {
            nums1[cur++] = temp[i++];
        }
        while (j < n) {
            nums1[cur++] = nums2[j++];
        }
    }


    /**
     * 还是上述理论，如若指针从尾部遍历，我们就不会覆盖nums1数组中已有的元素了
     * 时间复杂度O(m+n)
     * 因为不需要额外空间，空间复杂度为O(1)
     * @param nums1
     * @param m
     * @param nums2
     * @param n
     */
    public void merge2(int[] nums1, int m, int[] nums2, int n) {
        int tail = m + n - 1;
        int i = m - 1,j = n - 1;
        while (i >= 0 && j >= 0) {
            if (nums1[i] > nums2[j]) {
                nums1[tail--] = nums1[i--];
            } else {
                nums1[tail--] = nums2[j--];
            }
        }
        while (i >= 0) {
            nums1[tail--] = nums1[i--];
        }
        while (j >= 0) {
            nums1[tail--] = nums2[j--];
        }
    }


}