/*
  226
  Invert a binary tree.

  Example:
    Input:
         4
       /   \
      2     7
     / \   / \
    1   3 6   9

    Output:
         4
       /   \
      7     2
     / \   / \
    9   6 3   1

    Trivia:
      This problem was inspired by this original tweet by Max Howell:

      Google: 90% of our engineers use the software you wrote (Homebrew),
      but you can’t invert a binary tree on a whiteboard so f*** off.
*/

import java.util.ArrayDeque;
import java.util.Deque;

public class InvertBinaryTree {

  private static class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) {
      val = x;
    }
  }

  public TreeNode invertTree0(TreeNode root) {
    if (root == null) {
      return null;
    }
    TreeNode right = invertTree0(root.right);
    TreeNode left = invertTree0(root.left);
    root.left = right;
    root.right = left;
    return root;
  }

  public TreeNode invertTree1(TreeNode root) {
    if (root == null) {
      return null;
    }
    final TreeNode left = root.left, right = root.right;
    root.left = invertTree1(right);
    root.right = invertTree1(left);
    return root;
  }

  public TreeNode invertTree2(TreeNode root) {
    if (root == null) {
      return null;
    }

    Deque<TreeNode> stack = new ArrayDeque<>();
    stack.addFirst(root);

    while(!stack.isEmpty()) {
      final TreeNode node = stack.removeFirst();
      final TreeNode left = node.left;
      node.left = node.right;
      node.right = left;

      if(node.left != null) {
        stack.addFirst(node.left);
      }
      if(node.right != null) {
        stack.addFirst(node.right);
      }
    }
    return root;
  }

  public TreeNode invertTree3(TreeNode root) {
    if (root == null) {
      return null;
    }

    Deque<TreeNode> queue = new ArrayDeque<>();
    queue.addLast(root);

    while (!queue.isEmpty()) {
      TreeNode current = queue.removeFirst();
      TreeNode temp = current.left;
      current.left = current.right;
      current.right = temp;

      if (current.left != null) {
        queue.addLast(current.left);
      }
      if (current.right != null) {
        queue.addLast(current.right);
      }
    }
    return root;
  }
}
