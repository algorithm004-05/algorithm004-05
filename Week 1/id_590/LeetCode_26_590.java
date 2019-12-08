package homework.week1;

//https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array/
public class LeetCode_26_590 {
    public int removeDuplicates(int[] nums) {
        //1.设置一个变量记录长度
        int length = 1;
        //2.设置一个变量记录不重复元素的索引
        int notRepeatIndex = 1;
        //3.遍历数组,碰到与前一个元素相同的元素时,长度不变,索引位置也不变,否则长度+1,索引位置也+1
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[i - 1]) {
                length++;
                nums[notRepeatIndex] = nums[i];
                notRepeatIndex++;
            }
        }
        return length;
    }
}
