/*
 94
  Given a binary tree, return the inorder traversal of its nodes' values.

  Example:

  Input: [1,null,2,3]
    1
     \
      2
     /
    3

  Output: [1,3,2]

  Follow up: Recursive solution is trivial, could you do it iteratively ?
*/

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class BinaryTreeInorderTraversal {

  private static class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    
    TreeNode(int x) {
      val = x;
    }
  }

  public List<Integer> inOrderTraversal0(TreeNode root) {
    if (root == null) {
      return new ArrayList<>();
    }
    List<Integer> result = new ArrayList<>();
    result.addAll(inOrderTraversal0(root.left));
    result.add(root.val);
    result.addAll(inOrderTraversal0(root.right));
    return result;
  }

  public List<Integer> inOrderTraversal1(TreeNode root) {
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
    result.add(root.val);
    if (root.right != null) {
        helper(result, root.right);
    }
  }

  public List<Integer> inOrderTraversal2(TreeNode root) {
    List<Integer> result = new ArrayList<>();
    Deque<TreeNode> stack = new ArrayDeque<>();
    TreeNode currentNode = root;
    while (currentNode != null || !stack.isEmpty()) {
      while (currentNode != null) {
        stack.addFirst(currentNode);
        currentNode = currentNode.left;
      }

      currentNode = stack.removeFirst();
      result.add(currentNode.val);
      currentNode = currentNode.right;
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
  
  public List<Integer> inOrderTraversal3(TreeNode root) {
    if (root == null) {
      return new ArrayList<>();
    }

    List<Integer> result = new ArrayList<>();
    Deque<coloredTreeNode> stack = new ArrayDeque<>();
    stack.addFirst(new coloredTreeNode(root, "GREEN"));

    while (!stack.isEmpty()) {
      coloredTreeNode rootOrLeaf = stack.removeFirst();

      if (rootOrLeaf.color.equals("GREEN")) {
        if (rootOrLeaf.node.right != null) {
          stack.addFirst(new coloredTreeNode(rootOrLeaf.node.right, "GREEN"));
        }
        stack.addFirst(new coloredTreeNode(rootOrLeaf.node, "RED"));
        if (rootOrLeaf.node.left != null) {
          stack.addFirst(new coloredTreeNode(rootOrLeaf.node.left, "GREEN"));
        }
      } else {
        result.add(rootOrLeaf.node.val);
      }
    }

    return result;
  }

  public List<Integer> inOrderTraversal4(TreeNode root) {
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

          // In-order traversal, got to left first
          // Construct more links
          currentNode = currentNode.left;
        } else {
          // Already have gone through the sub-left tree of current node
          // Unlink avoid infinite loops
          // Add root val to the list
          previousNode.right = null;
          result.add(currentNode.val);

          // Begin to explore the sub-right of current node
          currentNode = currentNode.right;
        }
      }
    }
    return result;
  }
}
