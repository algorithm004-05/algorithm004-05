/*
  46
  Given a collection of distinct integers,
  return all possible permutations.

  Example:
    Input: [1,2,3]
    Output:
    [
      [1,2,3],
      [1,3,2],
      [2,1,3],
      [2,3,1],
      [3,1,2],
      [3,2,1]
    ]
*/


import java.util.ArrayList;
import java.util.List;

public class PermutationsFirst {

  public List<List<Integer>> permute(int[] nums) {
    List<List<Integer>> result = new ArrayList<>();
    backTrack(nums, result,new ArrayList<>());
    return result;
  }

  private void backTrack(int[] nums, List<List<Integer>> result, ArrayList<Integer> tempList) {
    if (tempList.size() == nums.length) {
      result.add(new ArrayList<>(tempList));
    } else {
      for (int i = 0; i < nums.length; i++) {
        if (tempList.contains(nums[i])) {
          continue;
        }
        tempList.add(nums[i]);
        backTrack(nums, result, tempList);
        tempList.remove(tempList.size() - 1);
      }
    }
  }
}
