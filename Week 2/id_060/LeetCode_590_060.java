/*
  590
  Given an n-ary tree, return the postorder traversal of its nodes' values.

  For example, given a 3-ary tree:
                 1
              /  |   \
             3   2   1
           /  \
          5   6

  Return its postorder traversal as: [5,6,3,2,4,1].

    Note:
      Recursive solution is trivial, could you do it iteratively?
*/

import java.util.ArrayList;
import java.util.List;

public class NaryTreePostOrderTraversal {

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

  public List<Integer> postOrder0(Node root) {
    if (root == null) {
      return new ArrayList<>();
    }

    List<Integer> result = new ArrayList<>();

    for (Node currentNode : root.children) {
      result.addAll(postOrder0(currentNode));
    }

    result.add(root.val);
    return result;
  }

  public List<Integer> postOrder1(Node root) {
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
    for (Node currentNode : root.children) {
      helper(currentNode, result);
    }
    result.add(root.val);
  }

  // TODO: iteratively
}
