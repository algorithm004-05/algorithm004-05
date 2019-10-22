package algorithm00405test.week1.job.done;

/**
 *给定一个数组，将数组中的元素向右移动 k 个位置，其中 k 是非负数。
 *
 * 示例 1:
 *
 * 输入: [1,2,3,4,5,6,7] 和 k = 3
 * 输出: [5,6,7,1,2,3,4]
 * 解释:
 * 向右旋转 1 步: [7,1,2,3,4,5,6]
 * 向右旋转 2 步: [6,7,1,2,3,4,5]
 * 向右旋转 3 步: [5,6,7,1,2,3,4]
 * 示例 2:
 *
 * 输入: [-1,-100,3,99] 和 k = 2
 * 输出: [3,99,-1,-100]
 * 解释:
 * 向右旋转 1 步: [99,-1,-100,3]
 * 向右旋转 2 步: [3,99,-1,-100]
 * 说明:
 *
 * 尽可能想出更多的解决方案，至少有三种不同的方法可以解决这个问题。
 * 要求使用空间复杂度为 O(1) 的 原地 算法。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/rotate-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LeetCode_189_510 {

    /**
     * 暴力
     * 空间复杂度
     * 时间复杂度
     * @param nums
     * @param k
     */
    public void rotate(int[] nums, int k) {
        if (null == nums || nums.length < 1 ){
            return;
        }

        // 循环k次处理
        while (k > 0){
            // 将最后一个数临时存放
            int temp = nums[nums.length-1];
            // 把每个元素后移一位
            for (int i = nums.length-1; i >0; i--) {
                nums[i] = nums[i-1];
            }
            // 把最后一位值存放到第一位
            nums[0]=temp;
            // 处理一次减去一次
            k--;
        }

    }

    /**
     * 环状
     * 空间复杂度
     * 时间复杂度
     * @param nums
     * @param k
     */
    public void rotate1(int[] nums, int k) {
        if (null == nums || nums.length < 1){
            return;
        }


        int temp ;
        for (int i = 0; i < nums.length - k; i++) {
            int index = i+k;
             while (index < nums.length){
                 temp = nums[index];
                 nums[index]  = nums[i];
                 nums[i]  = temp;
                 index+=k;
             }
            index -= nums.length;
            while (index < i){
                temp = nums[index];
                nums[index]  = nums[i];
                nums[i]  = temp;
                index+=k;
            }
        }
    }

    /**
     * 反转
     * 空间复杂度
     * 时间复杂度
     * @param nums
     * @param k
     */
    public void rotate2(int[] nums, int k) {
        if (null == nums || nums.length < 1 ){
            return;
        }


    }

    /**
     *
     * 空间复杂度
     * 时间复杂度
     * @param nums
     * @param k
     */
    public void rotate3(int[] nums, int k) {
        if (null == nums || nums.length < 1 ){
            return;
        }
    }
}
