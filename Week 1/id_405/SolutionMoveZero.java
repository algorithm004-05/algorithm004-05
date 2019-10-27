package example;

public class SolutionMoveZero {
    public void moveZeroes(int[] nums) {
        int noZearoIndex = 0 ;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[noZearoIndex] = nums[i];
                if (i != noZearoIndex) {
                    nums[i] = 0;
                }
                noZearoIndex ++;
            }
        }
    }
}
