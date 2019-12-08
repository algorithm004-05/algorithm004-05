/*
  22
  Given n pairs of parentheses,
  write a function to generate all combinations of well-formed parentheses.

  For example, given n = 3。
  A solution set is:
    [
      "((()))",
      "(()())",
      "(())()",
      "()(())",
      "()()()"
    ]
*/

import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses {

  private List<String> res = new ArrayList<>();

  public List<String> generateParenthesis(int n) {
    helper(0, 0, "", n);
    return res;
  }

  private void helper(int left, int right, String sub, int n) {
    if (left == n && right == n) {
      res.add(sub);
    }
    if (left < n) {
      helper(left + 1, right, sub + "(", n);
    }
    if (left > right) {
      helper(left, right + 1, sub + ")", n);
    }
  }
}

