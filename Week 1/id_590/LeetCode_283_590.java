package homework.week1;

//https://leetcode-cn.com/problems/move-zeroes/
public class LeetCode_283_590 {
    public void moveZeroes_One(int[] nums) {
        //解法一:
        //1.维护一个非0的索引,碰到非0元素,将其放入当前非0索引,并且非0索引++
        int notZeroIndex = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[notZeroIndex++] = nums[i];
            }
        }
        for (; notZeroIndex < nums.length; notZeroIndex++) {
            nums[notZeroIndex] = 0;
        }
    }

    public void moveZeroes_Two(int[] nums) {
        //解法二:在外面维护一个0元素的指针,当到了非0元素,则进行交换
        if (nums.length <= 1) {
            return;
        }
        int zeroIndex = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[zeroIndex] = nums[i];
                nums[i] = 0;
                if (zeroIndex != i) {
                    zeroIndex++;
                }
            }
        }
    }
}
