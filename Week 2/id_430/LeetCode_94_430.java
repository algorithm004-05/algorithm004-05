package id_430;

import java.util.*;

public class LeetCode_94_430 {

  class Solution {

    public List<Integer> inorderTraversal(TreeNode root) {
      List<Integer> res = new ArrayList();
      if (root == null) {
        return Collections.emptyList();
      }
      res.addAll(inorderTraversal(root.left));
      res.add(root.val);
      res.addAll(inorderTraversal(root.right));
      return res;
    }
  }
}