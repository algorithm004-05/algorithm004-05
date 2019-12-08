/*
 * @lc app=leetcode.cn id=26 lang=c
 *
 * [26] 删除排序数组中的重复项
 */

// @lc code=start

int removeDuplicates(int* nums, int numsSize){

//快慢指针
	if (numsSize == 0)
		return numsSize;
        int i = 0 ; 
        int j ;
        for ( j= 1; j < numsSize; j++)
        {
            if(nums[i] != nums[j]) {
                i++;
                nums[i] = nums[j];
            }

            /* code */
            
        }

        return i+1;
        
}