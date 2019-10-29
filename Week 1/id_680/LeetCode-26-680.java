//给定一个排序数组，你需要在原地删除重复出现的元素，使得每个元素只出现一次，返回移除后数组的新长度。

//不要使用额外的数组空间，你必须在原地修改输入数组并在使用 O(1) 额外空间的条件下完成。
/**
 *  解题思路
 *  使用双指针方法，用一次循环进行比较
 */
class Solution {
    public int removeDuplicates(int[] nums) {
        int i= 0;
        for(int j=1;j<nums.length;j++){
            if(nums[] != nums[j]){
                i++;
                nums[i] = nums[j];
            }

        }
         return  i+1;
    }

}
