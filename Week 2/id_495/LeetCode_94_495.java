import java.util.Stack;
import java.util.LinkedList;
import java.util.List;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) {
      val = x;
    }
}

/**
* 二叉树的中序遍历
*/
public class LeetCode_94_495 {

  public static void main(String[] args) {
    TreeNode aT = new TreeNode(1);
    TreeNode bT = new TreeNode(2);
    TreeNode cT = new TreeNode(3);
    aT.right = bT;
    bT.left = cT;
    System.out.println(inorderTraversal(aT));
  }

  public static List<Integer> inorderTraversal(TreeNode root) {
    List<Integer> list = new LinkedList<>();
    Stack<TreeNode> stack = new Stack<>();
    while (root != null || !stack.empty()) {
        if (root != null) {
            stack.push(root);
            root = root.left;
        } else {
            list.add(stack.peek().val);
            root = stack.pop().right;
        }
    }
    return list;
  }
}
