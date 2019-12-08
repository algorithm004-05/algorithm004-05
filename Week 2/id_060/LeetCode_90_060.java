/*
  90
  Given a collection of integers that might contain
  duplicates, nums, return all possible subsets (the power set).

  Note:
    The solution set must not contain duplicate subsets.

  Example:
    Input: [1,2,2]
    Output:
    [
      [2],
      [1],
      [1,2,2],
      [2,2],
      [1,2],
      []
    ]
*/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubsetsSecond {
  public List<List<Integer>> subsetsWithDup(int[] nums) {
    List<List<Integer>> result = new ArrayList<>();
    Arrays.sort(nums);
    backTrack(nums, result, new ArrayList<>(), 0);
    return result;
  }

  private void backTrack(int[] nums, List<List<Integer>> result, ArrayList<Integer> tempList, int starter) {
    result.add(new ArrayList<>(tempList));
    for (int i = starter; i < nums.length; i++) {
      if (i > starter && nums[i] == nums[i - 1]) {
        continue;
      }
      tempList.add(nums[i]);
      backTrack( nums, result, tempList, i + 1);
      tempList.remove(tempList.size() - 1);
    }
  }
}
