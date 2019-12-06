/**
 * 给定一个数组，将数组中的元素向右移动 k 个位置，其中 k 是非负数。
 */
class Solution {
  public void rotate(int[] nums, int k) {
        int lenth = nums.length;
        int md = k % lenth;//在nums数组中开始放入新数组中位置的起始值
        int[] mm = new int[lenth];//初始化一个新数组
         for(int i = 0 ; i < lenth ; i++){//循环nums数组
             if( i -md >= 0)//
                 mm[i] = nums[i - md];//不需要颠倒，并需要向后移动位置的值
             else
                 mm[i] = nums[lenth + i - md ];//获取需要颠倒移动的值
         }

         // 更改原数组的值
         for( int i = 0 ; i <lenth; i++)
             nums[i] = mm[i];
     }
}
