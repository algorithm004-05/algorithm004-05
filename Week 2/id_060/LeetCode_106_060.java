/*
  106
  Given inorder and postorder traversal of a tree, construct the binary tree.

  Note:
    You may assume that duplicates do not exist in the tree.

  For example, given
    inorder = [9,3,15,20,7]
    postorder = [9,15,7,20,3]

    Return the following binary tree:

      3
     / \
    9  20
      /  \
     15   7
*/

import java.util.HashMap;
import java.util.Map;

public class ConstructBinaryTreeFromInorderAndPostorderTraversal {

  private static class TreeNode {

    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int val) {
      this.val = val;
    }
  }

  private int[] postOrder;
  private int postOrderIndex;
  Map<Integer, Integer> inOrderHashMap = new HashMap<>();

  public TreeNode buildTree0(int[] inOrder, int[] postOrder) {
    this.postOrder = postOrder;
    this.postOrderIndex = postOrder.length - 1;

    int index = 0;
    for (int i : inOrder) {
      inOrderHashMap.put(i, index++);
    }
    return helper0(0, inOrder.length - 1);
  }

  private TreeNode helper0(int left, int right) {
    if (left > right) {
      return null;
    }

    int rootVal = postOrder[postOrderIndex--];
    TreeNode root = new TreeNode(rootVal);
    int inOrderIndex = inOrderHashMap.get(rootVal);

    root.right = helper0(inOrderIndex + 1, right);
    root.left = helper0(left, inOrderIndex - 1);

    return root;
  }

  private int inOrderIndex;

  public TreeNode buildTree1(int[] inOrder, int[] postOrder) {
    this.inOrderIndex = inOrder.length - 1;
    this.postOrderIndex = postOrder.length - 1;
    return helper1(postOrder, inOrder, (long)Integer.MIN_VALUE);
  }

  private TreeNode helper1(int[] postOrder, int[] inOrder, long stopper) {
    if (postOrderIndex == 0) {
      return null;
    }

    if (inOrder[inOrderIndex] == stopper) {
      inOrderIndex--;
      return null;
    }

    int rootVal = postOrder[postOrderIndex--];
    TreeNode root = new TreeNode(rootVal);

    root.right = helper1(postOrder, inOrder, rootVal);
    root.left = helper1(postOrder, inOrder, stopper);

    return root;
  }

  private TreeNode helper2(int[] postOrder, int postLeft, int postRight, int[] inOrder, int inLeft, int inRight) {
    if (postLeft > postRight || inLeft > inRight)
      return null;

    int rootVal = postOrder[postRight];
    TreeNode root = new TreeNode(rootVal);

    int pivotIndexOfInOrder = inLeft;
    while (inOrder[pivotIndexOfInOrder] != rootVal) {
      pivotIndexOfInOrder++;
    }

    root.left = helper2(postOrder, postLeft, pivotIndexOfInOrder -1 - inLeft + postLeft, inOrder, inLeft, pivotIndexOfInOrder - 1);
    root.right = helper2(postOrder,pivotIndexOfInOrder -1 - inLeft + postLeft + 1, postRight, inOrder, pivotIndexOfInOrder + 1, inRight);

    return root;
  }
}
