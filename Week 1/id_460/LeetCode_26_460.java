package Question26RemoveDuplicates;

/**
 * 给定一个排序数组，你需要在原地删除重复出现的元素，使得每个元素只出现一次，返回移除后数组的新长度。
 * <p>
 * 不要使用额外的数组空间，你必须在原地修改输入数组并在使用 O(1) 额外空间的条件下完成。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * <p>
 * <p>
 * 数组有序，重复的元素一定会相邻
 * 删除重复元素，就是将不重复的元素移动到数组的左侧。
 * <p>
 * 用两个指针，一个在前记作p，一个在后记作q。
 * 1.比较nums[p]和nums[q]是否相等
 * 2.如果相等，q后移一位；如果不相等，q位置的元素复制到p+1的位置上，p后移一位，q后移一位；
 * 3.重复上述过程，直到q=nums.length
 * 4.返回p+1即为新数组长度
 *
 * 时间复杂度：O(n)，假设数组的长度是 n，那么 i 和 j 分别最多遍历 n 步。
 *
 * 空间复杂度：O(1)。
 */
public class RemoveDuplicates {
    public static void main(String[] args) {
        int nums[] = {0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        System.out.println(removeDuplicates(nums));
    }

    private static int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int p = 0;
        int q = 1;
        while (q < nums.length) {
            if (nums[p] != nums[q]) {
                nums[p + 1] = nums[q];
                p++;
            }
            q++;
        }
        return p+1;
    }
}
