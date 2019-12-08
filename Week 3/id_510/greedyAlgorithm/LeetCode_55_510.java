

/**
 * 
 * 跳跃游戏
 * 
 *   给定一个非负整数数组，你最初位于数组的第一个位置。
 *
 * 数组中的每个元素代表你在该位置可以跳跃的最大长度。
 *
 * 判断你是否能够到达最后一个位置。
 *
 * 示例 1:
 *
 * 输入: [2,3,1,1,4]
 * 输出: true
 * 解释: 我们可以先跳 1 步，从位置 0 到达 位置 1, 然后再从位置 1 跳 3 步到达最后一个位置。
 * 示例 2:
 *
 * 输入: [3,2,1,0,4]
 * 输出: false
 * 解释: 无论怎样，你总会到达索引为 3 的位置。但该位置的最大跳跃长度是 0 ， 所以你永远不可能到达最后一个位置。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/jump-game
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LeetCode_55_510 {

    public boolean canJump(int[] nums) {
        int end = 0;
        int farther = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            // 此范围跳跃最远距离
            farther = Math.max(farther, nums[i] + i);
            if(i == end){
                // 如果最远距离恰好是上一跳的最远索引位置 则不能继续向下跳跃
                if(i == farther){
                    return false;
                }
                end = farther;
            }
        }
        return true;
    }

    /**
     * 简化版
     * @param nums
     * @return
     */
    public boolean canJump1(int[] nums) {
        int farther = 0;
        for (int i = 0; i < nums.length; i++) {
            // 如果当前索引的值 大于前面的最远的跳跃 说明跳不到这个位置了
            if (i > farther) {
                return false;
            }
            // 此范围跳跃最远距离
            farther = Math.max(farther, nums[i] + i);
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new LeetCode_55_510().helper(new int[]{3,2,1,0,4}, 0));
    }


    /**
     * 回溯 超时
     * @param nums
     * @param index
     * @return
     */
    private boolean helper(int[] nums, int index){
        if(nums[index] + index >= nums.length -1){
            return true;
        }
        int temp = nums[index];
        while(temp-- > 0){
            if(helper(nums, ++index)){
                return true;
            }
        }
        return false;
    }

    /**
     * 回溯
     * @param position
     * @param nums
     * @return
     */
    public boolean canJumpFromPosition(int position, int[] nums) {
        if (position == nums.length - 1) {
            return true;
        }

        int furthestJump = Math.min(position + nums[position], nums.length - 1);
        // New
        // for (int nextPosition = furthestJump; nextPosition > position; nextPosition--)

        for (int nextPosition = position + 1; nextPosition <= furthestJump; nextPosition++) {
            if (canJumpFromPosition(nextPosition, nums)) {
                return true;
            }
        }

        return false;
    }
    
    public boolean canJump2(int[] nums) {
        memo = new Index[nums.length];
        for (int i = 0; i < memo.length; i++) {
            memo[i] = Index.UNKNOWN;
        }
        memo[memo.length - 1] = Index.GOOD;
        return canJumpFromPosition2(0, nums);
    }

    static enum Index {
        GOOD, BAD, UNKNOWN
    }

    Index[] memo;

    public boolean canJumpFromPosition2(int position, int[] nums) {
        if (memo[position] != Index.UNKNOWN) {
            return memo[position] == Index.GOOD ? true : false;
        }

        int furthestJump = Math.min(position + nums[position], nums.length - 1);
        for (int nextPosition = position + 1; nextPosition <= furthestJump; nextPosition++) {
            if (canJumpFromPosition(nextPosition, nums)) {
                memo[position] = Index.GOOD;
                return true;
            }
        }

        memo[position] = Index.BAD;
        return false;
    }

 
    

}
