/*
  77
  Given two integers n and k,
  return all possible combinations of k numbers out of 1 ... n.

  Example:
    Input: n = 4, k = 2
    Output:
    [
      [2,4],
      [3,4],
      [2,3],
      [1,2],
      [1,3],
      [1,4],
    ]
*/

import java.util.ArrayList;
import java.util.List;

public class Combinations {

  public List<List<Integer>> combine(int n, int k) {
    List<List<Integer>> result = new ArrayList<>();
    backTrack(n, k, result, new ArrayList<>(), 1);
    return result;
  }

  private void backTrack(int end, int size, List<List<Integer>> result, ArrayList<Integer> tempList, int stater) {
    if (tempList.size() == size) {
      result.add(new ArrayList<>(tempList));
    }
    for (int i = stater; i < end + 1; i++) {
      tempList.add(i);
      backTrack(end, size, result, tempList, i + 1);
      tempList.remove(tempList.size() - 1);
    }
  }
}
