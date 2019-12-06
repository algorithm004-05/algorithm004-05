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
class LeetCode_144_495 {

  public static void main(String[] args) {
    TreeNode aT = new TreeNode(1);
    TreeNode bT = new TreeNode(2);
    TreeNode cT = new TreeNode(3);
    aT.right = bT;
    bT.left = cT;
    System.out.println(preorderTraversal(aT));
  }

  public static List<Integer> preorderTraversal(TreeNode node) {
    List<Integer> list = new LinkedList<Integer>();
    Stack<TreeNode> rights = new Stack<TreeNode>();
    while(node != null) {
        list.add(node.val);
        if (node.right != null) {
	        rights.push(node.right);
        }
        node = node.left;
        if (node == null && !rights.isEmpty()) {
	        node = rights.pop();
        }
    }
    return list;
  }
}
