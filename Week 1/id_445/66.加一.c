/*
 * @lc app=leetcode.cn id=66 lang=c
 *
 * [66] 加一
 */
#include <stdlib.h>
// @lc code=start


/**
 * Note: The returned array must be malloced, assume caller calls free().
 */
//solution 1
// int* plusOne(int* digits, int digitsSize, int* returnSize){

// int * res;
// *returnSize=digitsSize;
// int c=0,temp=digits[digitsSize-1]+1;
// if (temp!=10)
// {
//     digits[digitsSize-1]=digits[digitsSize-1]+1;
//     return digits;
// }
// c=1;
// digits[digitsSize-1]=0;

// for (int i = digitsSize-2; i >= 0; i--)
// {
  
//     temp=digits[i]+c; 
//     if (temp==10)
//     {
//         c=1;
//         digits[i]=0;
//     }else
//     {
//         c=0;
//         digits[i]=temp;
//         return digits;
//     }
    
// }
// if(c==1){
//      res= malloc(sizeof(int)*(digitsSize+1));
//      digitsSize++;
//      *returnSize=digitsSize;
//      res[0]=1;
//      for (int i = 1; i < digitsSize; i++)
//      {
//         res[i]=0;
//      }
     
// }
// return res;

// }

//solution2

int* plusOne(int* digits, int digitsSize, int* returnSize){
    for (int i = digitsSize-1; i >= 0; i--)
    {
        (digits[i])++;
        if (digits[i]==10)
        {
            digits[i]=0;
        }else
        {
            *returnSize=digitsSize;
            return digits;
        }
        
    }
    digitsSize++;
    int *res=malloc(sizeof(int)*(digitsSize));
    res[0]=1;
    *returnSize=digitsSize;
    for (int i = 1; i < digitsSize; i++)
    {
        res[i]=0;
    }
    return  res;
    
    
}
// @lc code=end

