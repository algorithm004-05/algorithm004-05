//给定一个数组，将数组中的元素向右移动 k 个位置，其中 k 是非负数。 
//
// 示例 1: 
//
// 输入: [1,2,3,4,5,6,7] 和 k = 3
//输出: [5,6,7,1,2,3,4]
//解释:
//向右旋转 1 步: [7,1,2,3,4,5,6]
//向右旋转 2 步: [6,7,1,2,3,4,5]
//向右旋转 3 步: [5,6,7,1,2,3,4]
// 
//
// 示例 2: 
//
// 输入: [-1,-100,3,99] 和 k = 2
//输出: [3,99,-1,-100]
//解释: 
//向右旋转 1 步: [99,-1,-100,3]
//向右旋转 2 步: [3,99,-1,-100] 
//
// 说明: 
//
// 
// 尽可能想出更多的解决方案，至少有三种不同的方法可以解决这个问题。 
// 要求使用空间复杂度为 O(1) 的 原地 算法。 
// 
// Related Topics 数组



//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public void rotate(int[] nums, int k) {
        //解法一：递归 每次替换数组最后一个数到第一个 根据k的值来判定换几次
        if(k == 0)
            return;
        int target = nums[nums.length - 1];
        for(int i = nums.length - 2; i >= 0; i--) {
            nums[i+1] = nums[i];
        }
        nums[0] = target;
        rotate(nums,k-1);
        //解法二
        if(k == 0)
            return ;
        int t = k % nums.length;
        int[] temp = new int[t];
        int j = 0;
        for (int i = nums.length - t; i < nums.length; i++) {
            temp[j++] = nums[i];
        }
        int y = nums.length - 1;
        for(int i = nums.length - 1 - t ; i >= 0 ; i--) {
            nums[y--] = nums[i];
        }
        for (int i = 0 ; i < t ; i++) {
            nums[i] = temp[i];
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
