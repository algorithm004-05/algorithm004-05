package id_535;

/**
 * created by lchen on 2019/10/20
 */
public class LeetCode_88_535 {

    public static void main(String[] args) {
        int[] nums1 = new int[]{1, 2, 3, 0, 0, 0};
        int[] nums2 = new int[]{2, 5, 6};
        Solution5 solution5 = new Solution5();
        solution5.merge(nums1, 3, nums2, 3);
        for (int i : nums1) {
            System.out.print(i + " ");
        }
    }
}

class Solution5 {
    //输入:
    //nums1 = [1,2,3,0,0,0], m = 3
    //nums2 = [2,5,6],       n = 3
    //
    //输出: [1,2,2,3,5,6]
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int p1 = m - 1;
        int p2 = nums1.length - 1;
        //指向数组nums2的末尾
        int p3 = n - 1;
        while (p3 >= 0) {
            if (p1 >= 0 && nums1[p1] >= nums2[p3]) {
                nums1[p2--] = nums1[p1--];
            }
            if (p1 >= 0 && nums1[p1] < nums2[p3]) {
                nums1[p2--] = nums2[p3--];
            }
            if (p1 < 0) {
                nums1[p2--] = nums2[p3--];
            }
        }
    }
}