//给定一个没有重复数字的序列，返回其所有可能的全排列。 
//
// 示例: 
//
// 输入: [1,2,3]
//输出:
//[
//  [1,2,3],
//  [1,3,2],
//  [2,1,3],
//  [2,3,1],
//  [3,1,2],
//  [3,2,1]
//] 
// Related Topics 回溯算法



//leetcode submit region begin(Prohibit modification and deletion)
// 1. 回溯法
class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> output = new ArrayList<>();
        List<Integer> num_arr = new ArrayList<>();
        for (int num : nums) {
            num_arr.add(num);
        }
        backtrack(0, nums.length, num_arr, output);
        return output;
    }
    private void backtrack (int first, int n, List<Integer> num, List<List<Integer>> output) {
        if (first == n) {
            output.add(new ArrayList<Integer>(num));
            return;
        }
        for (int i = first; i < n; i++) {
            Collections.swap(num, first, i);
            backtrack(first + 1, n, num, output);
            Collections.swap(num, first, i);
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
