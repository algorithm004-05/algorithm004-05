/*
  78
  Given a set of distinct integers, nums,
  return all possible subsets (the power set).

  Note:
  The solution set must not contain duplicate subsets.

  Example:
    Input: nums = [1,2,3]
    Output:
    [
      [3],
      [1],
      [2],
      [1,2,3],
      [1,3],
      [2,3],
      [1,2],
      []
    ]
*/

import java.util.ArrayList;
import java.util.List;

public class SubsetsFirst {

  public List<List<Integer>> subsets(int[] nums) {
    List<List<Integer>> result = new ArrayList<>();
    backTrack(nums, result, new ArrayList<Integer>(), 0);
    return result;

  }

  private void backTrack(int[] nums, List<List<Integer>> result, ArrayList<Integer> tempList, int starter) {
    result.add(new ArrayList<>(tempList));
    for (int j = starter; j < nums.length; j++) {
      tempList.add(nums[j]);
      backTrack(nums, result, tempList, starter + 1);
      tempList.remove(tempList.size() - 1);
    }
  }

}
