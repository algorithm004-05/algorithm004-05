/*
  102
  Given a binary tree, return the level order traversal of its nodes' values.
  (ie, from left to right, level by level).

  For example:
    Given binary tree [3,9,20,null,null,15,7],
       3
      / \
     9  20
       /  \
      15   7
    return its level order traversal as:
    [
      [3],
      [9,20],
      [15,7]
    ]
*/

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeLevelOrderTraversal {

  private static class TreeNode {

    int val;
    TreeNode left;
    TreeNode right;

    public TreeNode(int val) {
      this.val = val;
    }
  }

  private List<List<Integer>> res = new ArrayList<>();

  public List<List<Integer>> levelOrder0(TreeNode root) {
    helper(root, 0);
    return res;
  }

  private void helper(TreeNode node, int level) {

    // Auto add new level Smart IF statement
    if (res.size() == level) {
      res.add(new ArrayList<>());
    }

    // Add value at its level
    res.get(level).add(node.val);

    // PreOrder Travel
    if (node.left != null) {
      helper(node.left, level + 1);
    }
    if (node.right != null) {
      helper(node.right, level + 1);
    }
  }

  public static List<List<Integer>> levelOrder1(TreeNode root) {
    List<List<Integer>> res = new ArrayList<>();

    if (root == null) {
      return res;
    }

    Queue<TreeNode> queue = new LinkedList<>();
    queue.add(root);
    int level = 0;

    while (!queue.isEmpty()) {

      res.add(new ArrayList<>());

      // Use temp var Unless FOR Loop would not finished
      int length = queue.size();
      for (int i = 0; i < length; i++) {
        TreeNode curr = queue.remove();
        res.get(level).add(curr.val);

        if (curr.left != null) {
          queue.add(curr.left);
        }
        if (curr.right != null) {
          queue.add(curr.right);
        }
      }
      // Goto next level
      level++;
    }
    return res;
  }
}
