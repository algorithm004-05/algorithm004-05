/*
  429
  Given an n-ary tree, return the level order traversal of its nodes' values. (ie, from left to right, level by level).

  For example, given a 3-ary tree:
                 1
              /  |   \
             3   2   1
           /  \
          5   6

  We should return its level order traversal:
    [
      [1],
      [3,2,4],
      [5,6]
    ]
     
  Note:
    The depth of the tree is at most 1000.
    The total number of nodes is at most 5000.
*/

import java.util.ArrayList;
import java.util.List;

public class NaryTreeLevelOrderTraversal {

  private static class Node {

    int val;
    List<Node> children;

    public Node() {
    }

    public Node(int val, List<Node> children) {
      this.val = val;
      this.children = children;
    }
  }

  public List<List<Integer>> levelOrder(Node root) {
    if (root == null) {
      return new ArrayList<>();
    }

    List<List<Integer>> result = new ArrayList<>();
    helper(root, result, 0);
    return result;
  }

  private void helper(Node root, List<List<Integer>> result, int level) {
    if (root == null) {
      return;
    }

    if (level + 1 > result.size()) {
      result.add(new ArrayList<>());
    }

    result.get(level).add(root.val);

    for (Node currentNode : root.children) {
      if (currentNode != null) {
        helper(currentNode, result, level + 1);
      }
    }
  }

  // TODO: iteratively
}
