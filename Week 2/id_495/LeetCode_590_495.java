import java.util.Stack;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        children = new ArrayList<Node>();
        val = _val;
    }

    public Node(int _val,List<Node> _children) {
        val = _val;
        children = _children;
    }
}

/**
* N插树的后序遍历
*/
public class LeetCode_590_495 {

  public static void main(String[] args) {
      Node n2 = new Node(2);
      Node n4 = new Node(4);
      Node n5 = new Node(5);
      Node n6 = new Node(6);
      List<Node> nl1 = new ArrayList<>();
      nl1.add(n5);
      nl1.add(n6);
      Node n3 = new Node(3,nl1);
      List<Node> nl2 = new ArrayList<>();
      nl2.add(n3);
      nl2.add(n2);
      nl2.add(n4);
      Node nr = new Node(1,nl2);
      System.out.println(postorder(nr));
  }

  public static List<Integer> postorder(Node root) {
      List<Integer> list = new ArrayList<>();
      if (root == null) return list;

      Stack<Node> stack = new Stack<>();
      stack.add(root);

      while(!stack.isEmpty()) {
          root = stack.pop();
          list.add(root.val);
          for(Node node: root.children)
              stack.add(node);
      }
      Collections.reverse(list);
      return list;
  }
}
