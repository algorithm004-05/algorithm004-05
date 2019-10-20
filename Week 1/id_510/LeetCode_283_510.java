package algorithm00405test.week1.job.done;

/**
 * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 *
 * 示例:
 *
 * 输入: [0,1,0,3,12]
 * 输出: [1,3,12,0,0]
 * 说明:
 *
 * 必须在原数组上操作，不能拷贝额外的数组。
 * 尽量减少操作次数。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/move-zeroes
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LeetCode_283_510 {

    /**
     *
     * @param nums
     */
    public void moveZeroes(int[] nums) {
        if (null == nums || nums.length<=1){
            return;
        }
        int index = 0;
        int index1 = 0;
        while (index < nums.length){
            if (nums[index] == 0){
                index++;
            }else {
                while (index < nums.length && nums[index] !=0){
                    nums[index1] = nums[index];
                    index++;
                    index1++;
                }
            }
        }

        // 补全后面的0
        for (int i = nums.length -1; i > index1; i--) {
            nums[i]=0;
        }
    }

    /**
     *
     * @param nums
     */
    public void moveZeroes1(int[] nums) {
        if (null == nums || nums.length<=1){
            return;
        }

        // 遇到不是0的值添加到数据的下一个位置
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            if (0!=nums[i]){
                nums[index] = nums[i];
                index++;
            }
        }

        // 补全后面的0
        for (int i = index; i <nums.length ; i++) {
            nums[i] = 0;
        }
    }
}
