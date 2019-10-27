/*
  88
  Given two sorted integer arrays nums1 and nums2,
  merge nums2 into nums1 as one sorted array.

  Note:
    The number of elements initialized in nums1 and nums2 are m and n respectively.
    You may assume that nums1 has enough space
    (size that is greater or equal to m + n) to hold additional elements from nums2.

  Example:
    Input:
    nums1 = [1,2,3,0,0,0], m = 3
    nums2 = [2,5,6],       n = 3
    Output: [1,2,2,3,5,6]
*/

public class MergeSortedArray {

  public void merge0(int[] nums1, int m, int[] nums2, int n) {
    int[] nums1Copy = new int[m];
    System.arraycopy(nums1, 0, nums1Copy, 0, m);

    int i = 0, j = 0, k = 0;
    while (i < m && j < n) {
      nums1[k++] = nums1Copy[i] > nums2[j] ? nums2[j++] : nums1Copy[i++];
    }

    final int length = m + n - i - j;
    if (i < m) {
      System.arraycopy(nums1Copy, i, nums1, i + j, length);
    }

    if (j < n) {
      System.arraycopy(nums2, j, nums1, i + j, length);
    }
  }

  public void merge(int[] nums1, int m, int[] nums2, int n) {
    int i = m - 1, j = n - 1, k = m + n - 1;

    while (i >= 0 && j >= 0) {
      nums1[k--] = nums1[i] > nums2[j] ? nums1[i--] : nums2[j--];
    }

    System.arraycopy(nums2, 0, nums1, 0, j + 1);
  }
}
