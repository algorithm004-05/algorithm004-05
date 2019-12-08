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
        k = k % nums.length;
        int count = 0;// 用于记录交换了多少次
        for (int start = 0; count < nums.length; start++) {
            int current = start;// 记录当前的下标
            int pre = nums[current];// 记录当前下表的元素
            do {
                int next = (current+k) % nums.length;// 下一个替换元素的下标位置
                int temp = nums[next];// 下一个替换的元素
                nums[next] = pre;// 将对当前元素放到下一个位置
                pre = temp; // 将下一个元素转换当前元素
                current = next;// 将下一个元素下标转换当前元素下标
                count++;// 替换次数加1
            } while (start != current);//如果当前下标等于起始位置下标，推出循环
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
