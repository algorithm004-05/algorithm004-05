/*
 * @lc app=leetcode.cn id=189 lang=c
 *
 * [189] 旋转数组
 */

// @lc code=start

//方法一 暴力
/*
void rotate(int* nums, int numsSize, int k){
    k %= numsSize;
    for(int i = 0; i < k; i++){
        rotateOne(nums, numsSize);   
    }
}
void rotateOne(int* nums, int numsSize){
    int tem, pre = nums[numsSize - 1];
    for(int i = 0; i < numsSize; i++){
        tem = nums[i];
        nums[i] = pre;
        pre = tem;
    }

}
*/
//方法二 环状替换
/*
void rotate(int* nums, int numsSize, int k){
    int count = 0;
    k = k % numsSize;    //(a + b)%p = (a%p + b%p)%p
    for(int start=0; count < numsSize; start++){
        int previous = nums[start];
        int current = start;
        do{
            int next = (current + k) % numsSize;
            int temp = nums[next];
            nums[next] = previous;
            previous = temp;
            current = next;
            count++;
        }while(start != current);
    }
}
*/
//方法三 反转

void rotate(int* nums, int numsSize, int k){
    k = k % numsSize;
    reverse(0, numsSize-1, nums);
    reverse(0, k-1, nums);
    reverse(k, numsSize-1, nums);
}
void reverse(int start, int end, int* nums){
    int temp;
    while(start < end){
        temp = nums[start];
        nums[start] = nums[end];
        nums[end] = temp;
        start++;
        end--;
    }
}

// @lc code=end

