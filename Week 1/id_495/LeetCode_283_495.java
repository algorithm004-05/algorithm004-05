public class LeetCode_283_495 {

  public static void main(String[] args) {
    int[] nums = {0,1,0,3,12};
    moveZeroes(nums);
    for (int a: nums) {
      System.out.print(a);
      System.out.print(",");
    }
  }

  public static void moveZeroes(int[] nums) {

    int j = 0;
    for(int i = 0; i < nums.length; i++) {
        if(nums[i] != 0) {
            int temp = nums[j];
            nums[j] = nums[i];
            nums[i] = temp;
            j++;
        }
    }
  }
}
