class LeetCode_88_185 {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i1 = m - 1, i2 = n - 1, i = m + n - 1;
        
        while (i1 >= 0 && i2 >= 0) {
            if (nums1[i1] >= nums2[i2]) nums1[i--] = nums1[i1--];
            else nums1[i--] = nums2[i2--];
        }
        
        if (i2 >= 0) {
            for (int p = i; p >=0; p--) nums1[p] = nums2[i2--];
        }
    }
}
