package array;

import java.util.Arrays;

/**
 * Leetcode: https://leetcode.com/problems/remove-duplicates-from-sorted-array/
 *
 * @author Ethan L H LIANG
 * @since 2019.10.19
 */
public class RemoveDuplicatesFromSortedArray {

  public static void main(String[] args) {
    int[] array = new int[]{0, 0, 1, 1, 2, 2, 4};
    int len = removeDuplicates(array);
    assert len == 4;
    System.out.println(Arrays.toString(array));
  }


  public static int removeDuplicates(int[] nums) {
    if (nums.length == 0) {
      return 0;
    }
    int newLength = 1;
    int lastNumber = 0;
    for (int i = 0; i < nums.length; i++) {
      if (i == 0) {
        lastNumber = nums[i];
      }
      if (lastNumber != nums[i]) {
        nums[newLength++] = nums[i];
        lastNumber = nums[i];
      }
    }
    return newLength;
  }


}
