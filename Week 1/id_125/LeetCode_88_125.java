import java.util.Arrays;

/**
 * @Auther: 封玉书 FYS
 * @Date: 2019.10.20 00:36
 * @Description:
 */
public class A88 {
    public static void main(String[] args) {
        int[] nums1 = new int[]{0};
        int[] nums2 = new int[]{1};
        merge(nums1, 3, nums2, 3);
        merge1(nums1, 0, nums2, 1);
    }

    /**
     * 拷贝之后直接排序
     * 时间复杂度?
     *
     * @param nums1
     * @param m
     * @param nums2
     * @param n
     */
    private static void merge(int[] nums1, int m, int[] nums2, int n) {
        System.arraycopy(nums2, 0, nums1, m, n);
        Arrays.sort(nums1);
    }

    /**
     * 比大小排序
     * 因为num1超过m的元素都是无效元素，所以，从nums1后面往前遍历，分配新元素。
     * 这样可以避免使用额外的数组，降低空间复杂度
     * 时间复杂度O(n+m)
     *
     * @param nums1
     * @param m
     * @param nums2
     * @param n
     */
    private static void merge1(int[] nums1, int m, int[] nums2, int n) {

        // nums1 指针
        int i = m - 1;

        // nums2 指针
        int j = n - 1;


        // 放入nums1元素的指针
        int index = nums1.length - 1;

        // 倒叙遍历nums1.从最后的位置依次插入新元素
        while (i >= 0 && j >= 0) {
            // 谁的数值更大，则放入谁，另一方不动
            if (nums1[i] > nums2[j]) {
                nums1[index--] = nums1[i--];
            } else {
                nums1[index--] = nums2[j--];
            }

        }

        // num1有可能没有元素，i-1会<0。
        if (i <= 0) {
            System.arraycopy(nums2, 0, nums1, 0, j + 1);
        }
        System.out.println();
    }
}
























