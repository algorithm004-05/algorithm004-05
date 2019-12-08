/*
  144
  Given a binary tree, return the preorder traversal of its nodes' values.

  Example:
    Input: [1,null,2,3]
       1
        \
        2
       /
      3

    Output: [1,2,3]

   Follow up:
      Recursive solution is trivial, could you do it iteratively?
*/

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

class BinaryTreePreOrderTraversal {

  private static class TreeNode {

    int val;
    TreeNode left;
    TreeNode right;

    public TreeNode(int val, TreeNode left, TreeNode right) {
      this.val = val;
      this.left = left;
      this.right = right;
    }
  }

  public List<Integer> preOrderTraversal0(TreeNode root) {
    List<Integer> result = new ArrayList<>();
    if (root == null) {
      return result;
    }
    result.add(root.val);
    result.addAll(preOrderTraversal0(root.left));
    result.addAll(preOrderTraversal0(root.right));
    return result;
  }

  public List<Integer> preOrderTraversal1(TreeNode root) {
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
    result.add(root.val);
    if (root.left != null) {
      helper(result, root.left);
    }
    if (root.right != null) {
      helper(result, root.right);
    }
  }

  public List<Integer> preOrderTraversal2(TreeNode root) {
    if (root == null) {
      return new ArrayList<>();
    }
    List<Integer> result = new ArrayList<>();
    Deque<TreeNode> stack = new ArrayDeque<>();
    stack.addFirst(root);
    while (!stack.isEmpty()) {
      TreeNode currentNode = stack.removeFirst();
      result.add(currentNode.val);
      if (currentNode.right != null) {
        stack.addFirst(currentNode.right);
      }
      if (currentNode.left != null) {
        stack.addFirst(currentNode.left);
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

  public List<Integer> preOrderTraversal3(TreeNode root) {
    if (root == null) {
      return new ArrayList<>();
    }

    List<Integer> result = new ArrayList<>();
    Deque<coloredTreeNode> stack = new ArrayDeque<>();
    stack.addFirst(new coloredTreeNode(root, "GREEN"));

    while (!stack.isEmpty()) {
      coloredTreeNode rootOrLeaf = stack.removeFirst();
      if (rootOrLeaf.color.equals("GREEN")) {
        if ((rootOrLeaf.node.right != null)) {
          stack.addFirst(new coloredTreeNode(rootOrLeaf.node.right, "GREEN"));
        }
        if ((rootOrLeaf.node.left != null)) {
          stack.addFirst(new coloredTreeNode(rootOrLeaf.node.left, "GREEN"));
        }
        stack.addFirst(new coloredTreeNode(rootOrLeaf.node, "RED"));
      } else {
        result.add(rootOrLeaf.node.val);
      }
    }
    return result;
  }

  public List<Integer> preOrderTraversal4(TreeNode root) {
    List<Integer> result = new ArrayList<>();
    TreeNode currentNode = root;
    while (currentNode != null) {
      // Left is null add node's val to the list, then go to right
      if (currentNode.left == null) {
        result.add(currentNode.val);
        currentNode = currentNode.right;
      } else {
        // Go to the sub-left tree of current node
        TreeNode previousNode = currentNode.left;

        // Find the current node's sub-left tree's most right node
        while (previousNode.right != currentNode && previousNode.right != null) {
          previousNode = previousNode.right;
        }

        if (previousNode.right == null) {
          // Link sub-tree's most right node to current node
          previousNode.right = currentNode;

          // Pre-order traversal, add root val to the list first
          // Go to the left, construct more links
          result.add(currentNode.val);
          currentNode = currentNode.left;
        } else {
          // Already have gone through the sub-left tree of current node
          // Unlink avoid infinite loops
          previousNode.right = null;

          // Begin to explore the sub-right of current node
          currentNode = currentNode.right;
        }
      }
    }
    return result;
  }

}
