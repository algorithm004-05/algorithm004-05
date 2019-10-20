public class MergeSortedArray {
    class Solution {
        public void merge(int[] nums1, int m, int[] nums2, int n) {
            int p1 = m - 1;
            int p2 = n - 1;
            int p = m + n - 1;
            while ((p1 >= 0) && (p2 >= 0)) {
                nums1[p--] = (nums1[p1] < nums2[p2]) ? nums2[p2--] : nums1[p1--];

            }
            System.arraycopy(nums2, 0, nums1, 0, p2 + 1);
        }
    }
}

//最后的 arraycopy 是为了防止只有一个元素的情况
//[0]
//0
//[1]
//1
//输出：
//[0]
//预期：
//[1]