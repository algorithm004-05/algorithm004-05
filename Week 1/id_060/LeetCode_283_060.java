/*
  283
  Given an array nums, write a function to move all 0's to the end of it
  while maintaining the relative order of the non-zero elements.

  Example:
    Input: [0,1,0,3,12]
    Output: [1,3,12,0,0]

  Note:
    You must do this in-place without making a copy of the array.
    Minimize the total number of operations.
*/

public class  MoveZeros {

  public void moveZeroes0(int[] nums) {
    int baseIndex = 0;
    for (int exploreIndex = 0; exploreIndex < nums.length; exploreIndex++) {
      if (nums[exploreIndex] != 0) {
        if (exploreIndex != baseIndex) {
          swap(nums, exploreIndex, baseIndex);
        }
        baseIndex++;
      }
    }
  }

  public void moveZeroes1(int[] nums) {
    int snowBallSize = 0;
    for (int i = 0; i < nums.length; i++) {
      if (nums[i] == 0) {
        snowBallSize ++;
      } else if (snowBallSize > 0) {
        swap(nums, i, i - snowBallSize);
      }
    }
  }

  private void swap(int[] nums, int exploreIndex, int baseIndex) {
    int temp = nums[exploreIndex];
    nums[exploreIndex] = nums[baseIndex];
    nums[baseIndex] = temp;
  }
}
