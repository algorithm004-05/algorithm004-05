/**
 * 
 */
public class LeetCode_283_100 {
    public void moveZeroes(int[] nums) {
        //最终结果肯定是非零元素从下标0开始
        //我们只需要遍历一遍找到非零元素，放置到记录非零元素的下标处即可
        int  i = 0;
        for(int cur = 0; cur < nums.length; cur++) {
            if(nums[cur] != 0) {
                nums[i] = nums[cur];
                if(i != cur) {
                    nums[cur] = 0;
                }
                i++;
            }
        }
    }

    /**
     * 交换法
     * @param nums
     */
    public void moveZeroes2(int[] nums) {
        //记录第一个0的下标
        int first0 = -1;
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] == 0) {
                first0 = i;
                break;
            }
        }
        if(first0 != -1) {
            for(int i = first0+1; i < nums.length; i++) {
                if(nums[i] != 0) {
                    nums[first0++] = nums[i];
                    nums[i] = 0;
                }
            }
        }
    
    }
}