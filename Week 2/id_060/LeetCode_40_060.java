/*
  40
  Given a collection of candidate numbers (candidates) and a target number (target),
  find all unique combinations in candidates where the candidate numbers sums to target.

  Each number in candidates may only be used once in the combination.

  Note:
    All numbers (including target) will be positive integers.
    The solution set must not contain duplicate combinations.

  Example 1:
    Input: candidates = [10,1,2,7,6,1,5], target = 8,
    A solution set is:
    [
      [1, 7],
      [1, 2, 5],
      [2, 6],
      [1, 1, 6]
    ]

  Example 2:
    Input: candidates = [2,5,2,1,2], target = 5,
    A solution set is:
    [
      [1,2,2],
      [5]
    ]
*/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSumSecond {

  public List<List<Integer>> combinationSum2(int[] nums, int target) {
    List<List<Integer>> result = new ArrayList<>();
    Arrays.sort(nums);
    backTrack(nums, target, result, new ArrayList<>(), 0);
    return result;

  }

  private void backTrack(int[] nums, int target, List<List<Integer>> result, ArrayList<Integer> tempList, int starter) {
    if (target < 0) {
      return;
    } else if (target == 0) {
      result.add(new ArrayList<>(tempList));
    } else {
      for (int i = starter; i < nums.length; i++) {
        if (i > starter && nums[i] == nums[i - 1]) {
          continue;
        } else {
          tempList.add(nums[i]);
          backTrack(nums, target - nums[i], result, tempList, i + 1);
          tempList.remove(tempList.size() - 1);
        }
      }
    }
  }
}
