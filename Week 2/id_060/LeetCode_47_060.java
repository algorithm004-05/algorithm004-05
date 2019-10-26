/*
  47
  Given a collection of numbers that might contain duplicates,
  return all possible unique permutations.

  Example:
    Input: [1,1,2]
    Output:
    [
      [1,1,2],
      [1,2,1],
      [2,1,1]
    ]
*/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PermutationsSecond {

  public List<List<Integer>> permuteUnique(int[] nums) {
    List<List<Integer>> result = new ArrayList<>();
    Arrays.sort(nums);
    backtrack(nums, result, new ArrayList<>(), new boolean[nums.length]);
    return result;
  }

  private void backtrack(int[] nums, List<List<Integer>> result, List<Integer> tempList, boolean[] used) {
    if (tempList.size() == nums.length) {
      result.add(new ArrayList<>(tempList));
    } else {
      for (int i = 0; i < nums.length; i++) {
        if (used[i] || i > 0 && nums[i] == nums[i - 1] && !used[i - 1]) {
          continue;
        }
        used[i] = true;
        tempList.add(nums[i]);
        backtrack(nums, result, tempList, used);
        used[i] = false;
        tempList.remove(tempList.size() - 1);
      }
    }
  }
}
