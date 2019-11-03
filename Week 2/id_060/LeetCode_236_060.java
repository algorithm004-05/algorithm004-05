/*
  236
  Given a binary tree, find the lowest common ancestor (LCA) of two given nodes in the tree.

  According to the definition of LCA on Wikipedia:
  “The lowest common ancestor is defined between two nodes
  p and q as the lowest node in T that has both p and q as descendants
  (where we allow a node to be a descendant of itself).”

  Given the following binary tree:  root = [3,5,1,6,2,0,8,null,null,7,4]

  Example 1:
    Input: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1
    Output: 3

  Explanation:
    The LCA of nodes 5 and 1 is 3.

  Example 2:
    Input: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 4
    Output: 5

  Explanation:
  The LCA of nodes 5 and 4 is 5,
  since a node can be a descendant of itself according to the LCA definition.
     

  Note:
    All of the nodes' values will be unique.
    p and q are different and both values will exist in the binary tree.
*/

import java.util.ArrayList;
import java.util.List;

public class LowestCommonAncestorOfABinaryTree {

  private static class TreeNode {

    int val;
    TreeNode left;
    TreeNode right;

    public TreeNode(int val) {
      this.val = val;
    }
  }

  public TreeNode lowestCommonAncestor0(TreeNode root, TreeNode p, TreeNode q) {
    if (root == null) {
      return null;
    }

    if (root == p || root == q) {
      return root;
    }

    TreeNode left = lowestCommonAncestor0(root.left, p, q);
    TreeNode right = lowestCommonAncestor0(root.right, p, q);

    if (left != null && right != null) {
      return root;
    }

    return left != null ? left : right;
  }

  public TreeNode lowestCommonAncestor1(TreeNode root, TreeNode p, TreeNode q) {
    if (root == null) {
      return null;
    }

    if (root == p || root == q) {
      return root;
    }

    List<TreeNode> path0 = new ArrayList<>();
    List<TreeNode> path1 = new ArrayList<>();
    path0.add(root);
    path1.add(root);
    getPath(root, p, path0);
    getPath(root, q, path1);

    TreeNode res = null;
    for (int i = 0; i < Math.max(path0.size(), path1.size()); i++) {
      if (path0.get(i) == path1.get(i)) {
        res = path0.get(i);
      }
    }

    return res;
  }

  private boolean getPath(TreeNode root, TreeNode target, List<TreeNode> path) {
    if (root == target) {
      return true;
    }

    if (root.left != null) {
      path.add(root.left);
      if (getPath(root.left, target, path)) {
        return true;
      }
      path.remove(root.left);
    }

    if (root.right != null) {
      path.add(root.right);
      if (getPath(root.right, target, path)) {
        return true;
      }
      path.remove(root.right);
    }

    return false;
  }
}
