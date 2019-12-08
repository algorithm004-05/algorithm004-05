/*
 * @lc app=leetcode.cn id=283 lang=c
 *
 * [283] 移动零
 */

// @lc code=start


void moveZeroes(int* nums, int numsSize){
    int j=0;
    for(int i = 0; i < numsSize; ++i){
        if(nums[i] != 0){
            nums[j] = nums[i];
            if(i != j){
                nums[i] = 0;
            }
            ++j;
        }
    }
}


// @lc code=end

