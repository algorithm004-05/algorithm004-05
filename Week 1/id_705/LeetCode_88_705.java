class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m - 1;
        int j = n - 1 ;
        int z = m + n - 1;
        while (i >= 0 && j >= 0) {
            if (nums1[i] < nums2[j]) {
                nums1[z] = nums2[j];
                j--;
            } else {
                nums1[z] = nums1[i];
                i--;
            }
            z--;
        }
        System.arraycopy(nums2, 0, nums1, 0, j + 1);
    }
}