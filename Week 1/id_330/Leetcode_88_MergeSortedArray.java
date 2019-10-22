import java.util.Arrays;

public class Leetcode_88_MergeSortedArray {

    /**
     * 合并有序数组为一个有序数组
     * 1）将数组合并完后进行整体排序
     * 2）已经知道合并的数组是足够长的，所以可由大到小的方式进行合并避免了数组的移动，直接替换到index上的值即可。
     */
    public static void main(String[] args) {

        int[] aa = {1,2,3,0,0,0};
        int[] bb = {2,3,4};

        merge(aa, 3, bb, 3);
        merge1(aa, 3, bb, 3);
    }

    public static void merge(int[] nums1, int m, int[] nums2, int n) {

        System.arraycopy(nums2, 0, nums1, m, n);
        Arrays.sort(nums1);
        System.out.println(Arrays.toString(nums1));

    }

    /**
     * 巧妙运用 i-- 、i++ 运算符的特性，此处可google，i++、++i 和i--、--i的不同点。
     */
    public static void merge1(int[] nums1, int m, int[] nums2, int n) {
        int index1 = m - 1;
        int index2 = n - 1;
        int index3 = m + n -1;

        while ((index1 >= 0) && (index2 >=0)) {
            nums1[index3--] = (nums1[index1] < nums2[index2]) ? nums2[index2--] : nums1[index1--];
        }
        System.arraycopy(nums2, 0, nums1, 0, index2 + 1);

        System.out.println(Arrays.toString(nums1));
    }


}
