/*
  589
  Given an n-ary tree, return the preorder traversal of its nodes' values.

  For example, given a 3-ary tree:
                 1
              /  |   \
             3   2   1
           /  \
          5   6

  Return its preorder traversal as: [1,3,5,6,2,4].
  
  Note:
    Recursive solution is trivial, could you do it iteratively?
*/

import java.util.ArrayList;
import java.util.List;

public class NaryTreePreOrderTraversal {

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

  public List<Integer> preOrder0(Node root) {
    if (root == null) {
      return new ArrayList<>();
    }
    List<Integer> result = new ArrayList<>();
    result.add(root.val);
    for (Node currentNode : root.children) {
      result.addAll(preOrder0(currentNode));
    }
    return result;
  }

  public List<Integer> preOrder1(Node root) {
    if (root == null) {
      return new ArrayList<>();
    }

    List<Integer> result = new ArrayList<>();
    helper(root, result);
    return result;
  }

  private void helper(Node root, List<Integer> result) {
    if (root == null) {
      return;
    }

    result.add(root.val);

    for (Node currentNode : root.children) {
      helper(currentNode, result);
    }
  }

  // TODO: iteratively
}
