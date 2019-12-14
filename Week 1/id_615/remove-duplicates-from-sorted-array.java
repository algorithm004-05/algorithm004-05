/*
 *26. 删除排序数组中的重复项
 */
class Solution {
    public int removeDuplicates(int[] nums) {
        if(nums.length==0) return 0;
        int pre = 0;
        int next = 1;
        while(next < nums.length ){
           if(nums[pre] != nums[next]){
            if(next- pre > 1){
                nums[pre + 1] = nums[next];
            }
            pre ++;
          }
         next ++;
        }
        return pre + 1;
    }
}