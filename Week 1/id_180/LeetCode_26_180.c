int removeDuplicates(int* nums, int numsSize){
    if (numsSize < 2) {
        return numsSize;
    }
    int i = 0, j = 0;
    while (j < numsSize - 1) {
        if (nums[j] != nums[j + 1]) {
            nums[i++] = nums[j];
        }
        j++;
    }
    if (i < j) {
        nums[i] = nums[j];
    }
    return i + 1;
}
