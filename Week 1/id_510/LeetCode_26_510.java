package algorithm00405test.week1.job.done;

/**
 * 给定一个排序数组，你需要在原地删除重复出现的元素，使得每个元素只出现一次，返回移除后数组的新长度。
 * <p>
 * 不要使用额外的数组空间，你必须在原地修改输入数组并在使用 O(1) 额外空间的条件下完成。
 * <p>
 * 示例 1:
 * <p>
 * 给定数组 nums = [1,1,2],
 * <p>
 * 函数应该返回新的长度 2, 并且原数组 nums 的前两个元素被修改为 1, 2。
 * <p>
 * 你不需要考虑数组中超出新长度后面的元素。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LeetCode_26_510 {


    /**
     * 空间复杂度
     * 时间复杂度
     *
     * @param nums
     * @return
     */
    public int removeDuplicates(int[] nums) {
        if (null == nums || 0 == nums.length) {
            return 0;
        }

        // 有序
        // 3：然后从被替换的位置开始处理 i++
        int j = 1;
        for (int i = 0; i < nums.length; i++) {
            while (j < nums.length) {
                // 1：与相邻元素比较 相同则跳过 寻找大于的值
                if (nums[i] < nums[j]) {
                    // 2：然后将较大的值替换到当前元素的下一个位置
                    nums[i + 1] = nums[j];
                    break;
                }
                // 继续寻找下一个元素
                j++;
            }
            // 4：如果比较到了最后一位数了 则直接返回结果
            // 由于执行力j++ 则j==nums.length
            if (j == nums.length) {
                // i从0开始需要+1
                return i + 1;
            }
        }

        return 0;
    }

    /**
     * 空间复杂度
     * 时间复杂度
     *
     * @param nums
     * @return
     */
    public int removeDuplicates1(int[] nums) {
        // 从第二位开始 与前一位比较
        // 如果不相等 则代表是一个新的数据
        if (null == nums || 0 == nums.length) {
            return 0;
        }
        int count = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[i - 1]) {
                nums[count++] = nums[i];
            }
        }
        return count;
    }

    /**
     * 空间复杂度
     * 时间复杂度
     *
     * @param nums
     * @return
     */
    public int removeDuplicates2(int[] nums) {

        return 0;
    }

    /**
     * 空间复杂度
     * 时间复杂度
     *
     * @param nums
     * @return
     */
    public int removeDuplicates3(int[] nums) {

        return 0;
    }
}
