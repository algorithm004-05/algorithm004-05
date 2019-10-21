// Copyright(c) 2019 Mobvoi Inc. All Rights Reserved. 
class Solution {
  public void merge(int[] nums1, int m, int[] nums2, int n) {
    int i = m - 1;
    int j = n - 1;
    int r = m + n - 1;
    // 两个右指针，从后往前挑最大的元素，放在nums1尾端
    while (i >= 0 && j >= 0) {
      nums1[r--] = nums1[i] > nums2[j] ? nums1[i--] : nums2[j--];
    }
    // nums1用完，拷贝剩余nums2到nums1，如果nums2元素已用完，将拷贝0个；从nums2开头拷贝，拷贝到0处，拷贝nums2（当前位置+1）个元素
    // nums2用完，nums1不用拷贝，已在最前面
    System.arraycopy(nums2, 0, nums1, 0, j + 1);
  }
}