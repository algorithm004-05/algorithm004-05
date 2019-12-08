/*
 * @lc app=leetcode.cn id=189 lang=c
 *
 * [189] 旋转数组
 */
#include <stdlib.h>
#include <string.h>
// @lc code=start


void rotate(int* nums, int numsSize, int k){
    int * tempNums=malloc(sizeof(int)*numsSize);
    memcpy(tempNums,nums,sizeof(int)*numsSize);
int head=0,tail=numsSize-1;
k=k%numsSize;
for (int i = 0; i < k; i++)
{
    head=(head-1+numsSize)%numsSize;
}
for (int i = 0; i < numsSize; i++)
{
   nums[i]=tempNums[(head+i)%numsSize];
}

free(tempNums);

}


// @lc code=end

