/*
 * @lc app=leetcode.cn id=88 lang=c
 *
 * [88] 合并两个有序数组
 */
#include <stdlib.h>
#include <string.h>
// @lc code=start


void merge(int* nums1, int nums1Size, int m, int* nums2, int nums2Size, int n){
//solotion1
int i=m-1,j=n-1,k=0;
for ( k = 0; k <m+n ; k++)
{
    if(i>=0&&j>=0)
    if(nums1[i]>nums2[j]){
        nums1[m+n-k-1]=nums1[i];
        i--;
    }else
    {
        nums1[m+n-k-1]=nums2[j];
        j--;
    }
}
memcpy(nums1,nums2,sizeof(int)*(j+1));


}


// @lc code=end

