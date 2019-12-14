import java.util.Arrays;

/*
  493
  Given an array nums, we call (i, j) an important reverse pair if i < j and nums[i] > 2*nums[j].

  You need to return the number of important reverse pairs in the given array.

  Example1:
    Input: [1,3,2,3,1]
    Output: 2

  Example2:
    Input: [2,4,3,5,1]
    Output: 3
    Note:
    The length of the given array will not exceed 50,000.
    All the numbers in the input array are in the range of 32-bit integer.
*/
public class ReversePairs {

  public int result;

  public int reversePairs0(int[] nums) {
    result = 0;
    mergeSort0(nums, 0, nums.length - 1);
    return result;
  }

  public void mergeSort0(int[] nums, int left, int right) {
    if (right <= left) {
      return;
    }
    int middle = (left + right) >>> 1;
    mergeSort0(nums, left, middle);
    mergeSort0(nums, middle + 1, right);

    // Count elements
    int count = 0;
    for (int leftComparatorIndex = left, rightComparatorIndex = middle + 1; leftComparatorIndex <= middle; ) {

      /*
       A number selected on the left as a benchmark
       There are two situations that change the benchmark
       AKA leftComparatorIndex++

       1. We have compared all the numbers on the right with the benchmark
       AKA rightComparatorIndex > right

       2. The benchmark is less than or equal to twice the current right number
       AKA (long) nums[leftComparatorIndex] <= 2 * (long) nums[rightComparatorIndex]
      */
      if (rightComparatorIndex > right || (long) nums[leftComparatorIndex] <= 2 * (long) nums[rightComparatorIndex]) {
        leftComparatorIndex++;
        result += count;
      } else {
        rightComparatorIndex++;
        count++;
      }
    }

    // Sort
    Arrays.sort(nums, left, right + 1);
  }

  public int reversePairs1(int[] nums) {
    if (nums == null || nums.length == 0) {
      return 0;
    }
    return mergeSort1(nums, 0, nums.length - 1);
  }

  private int mergeSort1(int[] nums, int left, int right) {
    if (left >= right) {
      return 0;
    }
    int middle = (left + right) >>> 1;
    int count = mergeSort1(nums, left, middle) + mergeSort1(nums, middle + 1, right);
    int[] cache = new int[right - left + 1];
    int leftComparatorIndex = left, leftMergeIndex = left, cacheIndex = 0;

    // A number selected on the right as a benchmark
    for (int rightComparatorIndex = middle + 1; rightComparatorIndex <= right; rightComparatorIndex++, cacheIndex++) {

      /*
       There are two cases where the while loop terminates
       1. We have compared all the numbers on the left with the benchmark
       AKA rightComparatorIndex > right

       2. We have found important reversal pairs that meet the requirements
       AKA nums[leftComparatorIndex] > 2 * (long) nums[rightComparatorIndex]

       In other cases, compare the next left number with the benchmark
      */
      while (leftComparatorIndex <= middle && nums[leftComparatorIndex] <= 2 * (long) nums[rightComparatorIndex]) {
        leftComparatorIndex++;
      }

      // Merge
      while (leftMergeIndex <= middle && nums[leftMergeIndex] < nums[rightComparatorIndex]) {
        cache[cacheIndex++] = nums[leftMergeIndex++];
      }
      cache[cacheIndex] = nums[rightComparatorIndex];

      /*
       'leftComparatorIndex' it is the position of the first number on the left that meets the requirements
       we are deal with a sorted array and
       based on the two cases where the FIRST while loop terminates
       we know all numbers on the left after the number meet the requirements
      */
      count += middle - leftComparatorIndex + 1;
    }

    // There are still numbers on the left that can be merged
    while (leftMergeIndex <= middle) {
      cache[cacheIndex++] = nums[leftMergeIndex++];
    }


    System.arraycopy(cache, 0, nums, left, right - left + 1);
    return count;
  }

}
