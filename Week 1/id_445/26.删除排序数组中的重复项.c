/*
 * @lc app=leetcode.cn id=26 lang=c
 *
 * [26] 删除排序数组中的重复项
 */
#include <stdlib.h>
// @lc code=start


int removeDuplicates(int* nums, int numsSize){
    if (numsSize==0) return 0;
    int i=1,j=0;
for (int i = 0; i < numsSize-1; i++)
{

    if(nums[i]!=nums[i+1]){
        if(i!=j){
            nums[j+1]=nums[i+1];
            
        }
        j++;
    }
}
return j+1;

}


// @lc code=end

