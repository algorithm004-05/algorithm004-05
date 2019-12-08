//给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。 
//
// 你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。 
//
// 示例: 
//
// 给定 nums = [2, 7, 11, 15], target = 9
//
//因为 nums[0] + nums[1] = 2 + 7 = 9
//所以返回 [0, 1]
// 
// Related Topics 数组 哈希表


import java.util.HashMap;
import java.util.Map;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int longestValidParentheses(String s) {
        int maxArgs = 0;
        int dp[] = new int[s.length()];
        for (int i=1;i<s.length();i++){
            if(s.charAt(i) == ')'){
                if (s.charAt(i-1) == '('){
                    dp[i] = (i>=2 ? dp[i-2]:0) +2;
                }else if(i - dp[i-1]>0 && s.charAt(i - dp[i - 1] - 1) == '('){
                    dp[i] = dp[i - 1] + ((i - dp[i - 1]) >= 2 ? dp[i - dp[i - 1] - 2] : 0) + 2;
                }
                maxArgs = Math.max(maxArgs,dp[i]);
            }
        }
        return maxArgs;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
