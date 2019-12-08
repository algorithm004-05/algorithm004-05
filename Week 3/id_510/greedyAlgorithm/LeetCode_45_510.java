
/**
 * 
 * 跳跃游戏 II
 * 
 * 给定一个非负整数数组，你最初位于数组的第一个位置。
 *
 * 数组中的每个元素代表你在该位置可以跳跃的最大长度。
 *
 * 你的目标是使用最少的跳跃次数到达数组的最后一个位置。
 *
 * 示例:
 *
 * 输入: [2,3,1,1,4] 输出: 2 解释: 跳到最后一个位置的最小跳跃数是 2。   从下标为 0 跳到下标为 1
 * 的位置，跳 1 步，然后跳 3 步到达数组的最后一个位置。 说明:
 *
 * 假设你总是可以到达数组的最后一个位置。
 *
 * 来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/jump-game-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LeetCode_45_510 {

    public int jump(int[] nums) {
        if (null == nums || 0 == nums.length) {
            return 0;
        }
        int farthest = 0; // 最大跳跃值 即最优解
        int end = 0; // 最远边界
        int jumps = 0; // 跳跃次数
        // 最后一个是目的地 不用处理
        for (int i = 0; i < nums.length - 1; i++) {
            farthest = Math.max(farthest, i + nums[i]);
            /**
             * 遍历到最远边界后 获取这段区间值的最大跳跃值 i + nums[i] 跳跃次数+1
             */
            if (i == end) {
                jumps++;
                end = farthest;
                // 如果当前节点的跳跃值 可以达到数组最后一个值 则结束
                if (end >= nums.length - 1) {
                    break;
                }
            }

        }
        return jumps;
    }

    public static void main(String[] args) {
        System.out.println(new LeetCode_45_510().jump1(new int[] { 2, 3, 1, 1, 4,1,1,1,1,1,1,1,1,1}));
    }

    public int jump1(int[] nums) {
        return helper(nums, 0, 0);
    }

    /**
     * 
     * 回溯  超时啊
     * 
     * @param nums    入参数
     * @param index   处理索引
     * @param preStep 上一轮的次数
     * @return
     */
    private int helper(int[] nums, int index, int preStep) {
        if (nums.length <= 1) {
            return 0;
        }
        
        if (nums[index] + index >= nums.length - 1) {
            return preStep + 1;
        }

        int temp = nums[index];
        int min = nums.length - 1; // 步数最少次数，默认数组长度-1，最后一个不用处理
        while (temp-- > 0) {
            // 可跳跃的下一步最少步数
            min = Math.min(min, helper(nums, ++index, preStep + 1));
        }
        return min;
    }
}
