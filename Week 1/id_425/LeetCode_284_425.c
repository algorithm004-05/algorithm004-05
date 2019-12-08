void moveZeroes(int* nums, int numsSize){
    //思路是，总用一个指针指向当前最前的0，另一个指针遍历，遇到非0，立即与指向0的指针换位置；
    //指向0的指针和遍历指针之间的不可能出现非0元素
    int j = 0;
    for (int i = 0;i<numsSize;++i){
        if (nums[i] != 0){
            nums[j] = nums[i];
            if (i != j){
                //（1）遇到第一个0元素后，慢指针指向0，快指针才和慢指针不等，即i,j不等。
                //（2）只有慢指针指向非0元素两者才可能相等
                nums[i] = 0;
            }
            ++j;
        }
    }
}