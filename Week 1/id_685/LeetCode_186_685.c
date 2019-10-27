/*
 * @lc app=leetcode.cn id=189 lang=c
 *
 * [189] 旋转数组
 */

// @lc code=start


void rotate(int* nums, int numsSize, int k){

        if(numsSize <= 0)return numsSize;
        int *a  = malloc(sizeof(int)*numsSize) ;
        for( int i  = 0  ;  i < numsSize  ; i++) {
                a[( i + k ) % numsSize]= nums[i] ;
        }
        for(int i = 0 ; i < numsSize ; i++) {
            nums[i] = a[i];
        }
}


// @lc code=end

