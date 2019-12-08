import java.util.List;
import java.util.ArrayList;
import java.util.LinkedList;
import java.lang.Integer;
import java.util.Queue;


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
* N叉树的层序遍历
*/
public class LeetCode_429_495 {
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
    System.out.println(levelOrder(nr));
  }

  public static List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> ret = new LinkedList<>();

        if (root == null) return ret;

        Queue<Node> queue = new LinkedList<>();

        queue.offer(root);

        while (!queue.isEmpty()) {
            List<Integer> curLevel = new LinkedList<>();
            int len = queue.size();
            for (int i = 0; i < len; i++) {
                Node curr = queue.poll();
                curLevel.add(curr.val);
                for (Node c : curr.children)
                    queue.offer(c);
            }
            ret.add(curLevel);
        }

        return ret;
    }
}
