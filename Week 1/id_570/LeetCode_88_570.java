class ArrayMerge {

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int k = 0;
        int len = m;
        loop2:
        for (int i = 0; i < n; i++) {
            loop1:
            for (int j = k; j <= len; j++) {
                if (j < len && nums2[i] > nums1[j]) {
                    continue loop1;
                }

                nums1 = move(nums1, j, m + n - 2);
                k = j;
                nums1[j] = nums2[i];
                len++;
                break;

            }
        }
    }

    // k~n位，所有元素后移一位
    public int[] move(int[] nums, int k, int n) {
        for (int i = n; i >= k; i--) {
            nums[i + 1] = nums[i];
        }
        return nums;
    }
}