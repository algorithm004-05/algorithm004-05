import java.util.ArrayList;
import java.util.List;
import java.lang.Integer;

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
* N叉树的前序遍历
*/
public class LeetCode_589_495 {

  private static List<Integer> res = new ArrayList<Integer>();

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
    System.out.println(preorder(nr));
  }

  public static List<Integer> preorder(Node root) {
        inOrder(root);
        return res;
  }

  public static void inOrder(Node root) {
        if(root == null) {
            return;
        }
        res.add(root.val);
        int s = root.children.size();
        for(int i = 0; i < s; i++) {
            inOrder(root.children.get(i));
        }
  }

}
