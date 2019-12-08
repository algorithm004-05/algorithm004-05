class Solution {
  //26. 删除排序数组中的重复项
  public int removeDuplicates(int[] nums) {
    int k = 0; // 最终显示数组中不同元素的索引
    int count = 0; // 重复元素的总数
    int len = nums.length; // 去重后数组的长度

    for (int i = 0; i < len - 1; i++) {
      if (i == 0) {
        // 边界处理
        nums[k] = nums[0];
        k++;
      }
      if (nums[i] == nums[i + 1]) {
        count++;
      } else if (nums[i] < nums[i + 1]) {
        nums[k] = nums[i + 1];
        k++;
      }
    }
    len = len - count;
    return len;
  }
}