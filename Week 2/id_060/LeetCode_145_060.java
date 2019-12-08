/*
  145
  Given a binary tree, return the postorder traversal of its nodes' values.

  Example:
    Input: [1,null,2,3]
        1
         \
          2
         /
       3

    Output: [3,2,1]

  Follow up:
    Recursive solution is trivial, could you do it iteratively?
*/

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class BinaryTreePostOrderTraversal {

  private static class TreeNode {

    int val;
    TreeNode left;
    TreeNode right;

    public TreeNode(int val) {
      this.val = val;
    }
  }

  public List<Integer> postOrderTraversal0(TreeNode root) {
    if (root == null) {
      return new ArrayList<>();
    }

    List<Integer> result = new ArrayList<>();
    result.addAll(postOrderTraversal0(root.left));
    result.addAll(postOrderTraversal0(root.right));
    result.add(root.val);
    return result;
  }

  public List<Integer> postOrderTraversal1(TreeNode root) {
    if (root == null) {
      return new ArrayList<>();
    }
    List<Integer> result = new ArrayList<>();
    helper(result, root);
    return result;
  }

  private void helper(List<Integer> result, TreeNode root) {
    if (root == null) {
      return;
    }

    if (root.left != null) {
      helper(result, root.left);
    }
    if (root.right != null) {
      helper(result, root.right);
    }
    result.add(root.val);
  }

  public List<Integer> postOrderTraversal2(TreeNode root) {
    if (root == null) {
      return new ArrayList<>();
    }
    LinkedList<Integer> result = new LinkedList<>();
    Deque<TreeNode> stack = new ArrayDeque<>();
    stack.addFirst(root);
    while (!stack.isEmpty()) {
      TreeNode currentNode = stack.removeFirst();
      result.addFirst(currentNode.val);
      if (currentNode.left != null) {
        stack.addFirst(currentNode.left);
      }
      if (currentNode.right != null) {
        stack.addFirst(currentNode.right);
      }
    }
    return result;
  }

  private static class coloredTreeNode {

    TreeNode node;
    String color;

    public coloredTreeNode(TreeNode node, String color) {
      this.node = node;
      this.color = color;
    }
  }

  public List<Integer> postOrderTraversal3(TreeNode root) {
    if (root == null) {
      return new ArrayList<>();
    }

    List<Integer> result = new ArrayList<>();
    Deque<coloredTreeNode> stack = new ArrayDeque<>();
    stack.addFirst(new coloredTreeNode(root, "GREEN"));

    while (!stack.isEmpty()) {
      coloredTreeNode rootOrLeaf = stack.removeFirst();
      if (rootOrLeaf.color.equals("GREEN")) {
        stack.addFirst(new coloredTreeNode(rootOrLeaf.node, "RED"));
        if ((rootOrLeaf.node.right != null)) {
          stack.addFirst(new coloredTreeNode(rootOrLeaf.node.right, "GREEN"));
        }
        if ((rootOrLeaf.node.left != null)) {
          stack.addFirst(new coloredTreeNode(rootOrLeaf.node.left, "GREEN"));
        }
      } else {
        result.add(rootOrLeaf.node.val);
      }
    }
    return result;
  }
}
