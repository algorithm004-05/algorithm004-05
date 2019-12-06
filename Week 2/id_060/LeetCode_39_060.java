/*
  39
  Given a set of candidate numbers (candidates) (without duplicates) and a target number (target),
  find all unique combinations in candidates where the candidate numbers sums to target.

  The same repeated number may be chosen from candidates unlimited number of times.

  Note:
    All numbers (including target) will be positive integers.
    The solution set must not contain duplicate combinations.

 Example 1:
    Input: candidates = [2,3,6,7], target = 7,

    A solution set is:
    [
      [7],
      [2,2,3]
    ]

  Example 2:
    Input: candidates = [2,3,5], target = 8,

    A solution set is:
    [
      [2,2,2,2],
      [2,3,3],
      [3,5]
    ]
*/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSumFirst {

  public List<List<Integer>> combinationSum(int[] nums, int target) {
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
        tempList.add(nums[i]);
        backTrack(nums, target - nums[i], result, tempList, i);
        tempList.remove(tempList.size() - 1);
      }
    }
  }
}
