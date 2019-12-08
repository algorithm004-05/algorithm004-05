package leetcode.editor.cn;  //给定一个非负整数数组，你最初位于数组的第一个位置。
//
// 数组中的每个元素代表你在该位置可以跳跃的最大长度。 
//
// 判断你是否能够到达最后一个位置。 
//
// 示例 1: 
//
// 输入: [2,3,1,1,4]
//输出: true
//解释: 我们可以先跳 1 步，从位置 0 到达 位置 1, 然后再从位置 1 跳 3 步到达最后一个位置。
// 
//
// 示例 2: 
//
// 输入: [3,2,1,0,4]
//输出: false
//解释: 无论怎样，你总会到达索引为 3 的位置。但该位置的最大跳跃长度是 0 ， 所以你永远不可能到达最后一个位置。
// 
// Related Topics 贪心算法 数组

public class Leetcode_55_480 {
    public static void main(String[] args) {
        Solution solution = new Leetcode_55_480().new Solution();
    }


    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean canJumpFromPosition(int position, int[] nums) {
            if (position == nums.length - 1) {
                return true;
            }

            int furthestJump = Math.min(position + nums[position], nums.length - 1);
            for (int nextPosition = position + 1; nextPosition <= furthestJump; nextPosition++) {
                if (canJumpFromPosition(nextPosition, nums)) {
                    return true;
                }
            }

            return false;
        }

        public boolean canJump(int[] nums) {
            return canJumpFromPosition(0, nums);
        }
    }

    enum Index {
        GOOD, BAD, UNKNOWN
    }

    class Solution2 {
        Index[] memo;

        public boolean canJumpFromPosition(int position, int[] nums) {
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

        public boolean canJump(int[] nums) {
            memo = new Index[nums.length];
            for (int i = 0; i < memo.length; i++) {
                memo[i] = Index.UNKNOWN;
            }
            memo[memo.length - 1] = Index.GOOD;
            return canJumpFromPosition(0, nums);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}