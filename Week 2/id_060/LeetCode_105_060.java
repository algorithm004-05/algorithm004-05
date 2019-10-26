/*
  105
  Given preorder and inorder traversal of a tree, construct the binary tree.

  Note:
    You may assume that duplicates do not exist in the tree.

  For example, given
    preorder = [3,9,20,15,7]
    inorder = [9,3,15,20,7]
    Return the following binary tree:F

      3
     / \
    9  20
      /  \
     15   7
*/

import java.util.HashMap;
import java.util.Map;

public class ConstructBinaryTreeFromPreorderAndInorderTraversal {

  private static class TreeNode {

    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int val) {
      this.val = val;
    }
  }

  private int[] preOrder;
  private int preOrderIndex = 0;
  private Map<Integer, Integer> inOrderHashMap = new HashMap<>();

  public TreeNode buildTree0(int[] preOrder, int[] inOrder) {
    this.preOrder = preOrder;

    int index = 0;
    for (int val : inOrder) {
      inOrderHashMap.put(val, index++);
    }

//    return helper0(0, inorder.length);
    return helper1(0, inOrder.length - 1);

  }

  // Note:
  // The difference between helper0() and helper1() in the following aspects:
  // The range at the very first call
  // Recursive stop condition
  // Sub-boundary
  // I prefer the later one
  private TreeNode helper0(int left, int right) {
    if (left == right) {
      return null;
    }

    int val = preOrder[preOrderIndex];
    int inOrderIndex = inOrderHashMap.get(val);
    TreeNode root = new TreeNode(val);

    preOrderIndex++;
    root.left = helper0(left, inOrderIndex);
    root.right = helper0(inOrderIndex + 1, right);

    return root;
  }

  private TreeNode helper1(int left, int right) {
    if (left > right) {
      return null;
    }

    int val = preOrder[preOrderIndex];
    TreeNode root = new TreeNode(val);

    preOrderIndex++;
    root.left = helper1(left, inOrderHashMap.get(val) - 1);
    root.right = helper1(inOrderHashMap.get(val) + 1, right);

    return root;
  }

  public TreeNode buildTree1(int[] preOrder, int[] inOrder) {
    return helper2(preOrder, inOrder, (long)Integer.MIN_VALUE + 1);
  }

  private int inOrderIndex = 0;

  private TreeNode helper2(int[] preOrder, int[] inOrder, long stopper) {
    if (preOrderIndex == preOrder.length) {
      return null;
    }

    if (inOrder[inOrderIndex] == stopper) {
      inOrderIndex++;
      return null;
    }

    int rootVal = preOrder[preOrderIndex++];
    TreeNode root = new TreeNode(rootVal);

    root.left = helper2(preOrder, inOrder, rootVal);
    root.right = helper2(preOrder, inOrder, stopper);

    return root;
  }

  public TreeNode buildTree2(int[] preOrder, int[] inOrder) {
    return helper3(preOrder, 0, preOrder.length - 1, inOrder, 0, inOrder.length - 1);
  }

  private TreeNode helper3(int[] preOrder, int preLeft, int preRight, int[] inOrder, int inLeft, int inRight) {
    if (preLeft > preRight || inLeft > inRight) {
      return null;
    }

    int rootVal = preOrder[preLeft];
    TreeNode root = new TreeNode(rootVal);

    int pivotIndexOfInOrder = inLeft;
    while (inOrder[pivotIndexOfInOrder] != rootVal) {
      pivotIndexOfInOrder++;
    }

    root.left = helper3(preOrder, preLeft + 1, pivotIndexOfInOrder - inLeft + preLeft, inOrder, inLeft, pivotIndexOfInOrder -1);
    root.right = helper3(preOrder, pivotIndexOfInOrder - inLeft + preLeft + 1, preRight, inOrder, pivotIndexOfInOrder +  1, inRight);

    return root;
  }
}
