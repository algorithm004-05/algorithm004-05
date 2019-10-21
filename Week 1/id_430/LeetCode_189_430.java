// Copyright(c) 2019 Mobvoi Inc. All Rights Reserved.
class Solution {
  public void rotate(int[] nums, int k) {
    int n = nums.length;
    int count = 0;
    // 需要移动的第一个位置
    // 所有元素都移动过，移动结束
    for (int start = 0; count < n; start++) {
      // 当前元素值
      int value = nums[start];
      // 当前元素位置
      int curr = start;
      do {
        // 需要移动到的位置
        int next = (curr + k) % n;
        int temp = nums[next];
        nums[next] = value;
        value = temp;
        curr = next;
        count++;
        // 倒数第i个元素已经循环到第一个位置（移动步长刚好使本轮最后的元素移动到第一个元素的位置，本轮循环移动完成；或者本轮移动触发下一轮移动直到最后一轮移动结束）
      } while (start != curr);
    }
  }
}