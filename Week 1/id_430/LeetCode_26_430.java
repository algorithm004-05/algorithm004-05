package id_430;

class LeetCode_26_430 {
  public int removeDuplicates(int[] nums) {
    // 上一个已经修改好的位置
    int i = 0;
    // 跳过第一个，第一个不变
    for (int j = 1; j < nums.length; j++) {
      if (nums[i] != nums[j]) {
        // 新位置修改为第一个不重复的值
        nums[++i] = nums[j];
      }
    }
    return i + 1;
  }
}