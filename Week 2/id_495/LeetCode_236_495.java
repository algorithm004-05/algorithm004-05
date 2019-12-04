import java.util.LinkedList;

class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
     TreeNode(int x) { val = x; }
}

/**
* 二叉树的最近公共祖先
*/
public class LeetCode_236_495 {

  public static void main(String[] args) {
    TreeNode tn1 = new TreeNode(3);
    TreeNode tn2 = new TreeNode(5);
    TreeNode tn3 = new TreeNode(1);
    tn1.left = tn2;
    tn1.right = tn3;
    TreeNode tn4 = new TreeNode(6);
    TreeNode tn5 = new TreeNode(2);
    tn2.left = tn4;
    tn2.right = tn5;
    TreeNode tn6 = new TreeNode(0);
    TreeNode tn7 = new TreeNode(8);
    tn3.left = tn6;
    tn3.right = tn7;
    TreeNode tn8 = new TreeNode(7);
    TreeNode tn9 = new TreeNode(4);
    tn5.left = tn8;
    tn5.right = tn9;

    LeetCode_236_495 lc = new LeetCode_236_495();
    TreeNode result = lc.lowestCommonAncestor(tn1, tn2, tn3);
    System.out.println(result.val);
  }

  public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // 其中一个能深搜到另一个（直接祖先）
        if (DFS(p, q)) return p;
        if (DFS(q, p)) return q;
        TreeNode ret = root;
        int depth = 0, maxDepth = -1;
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        // 层序遍历
        while (!queue.isEmpty()) {
            TreeNode head = queue.poll();
            if (head.left != null) queue.offer(head.left);
            if (head.right != null) queue.offer(head.right);
            if (DFS(head, p) && DFS(head, q) && depth > maxDepth) {
                maxDepth = depth;
                ret = head;
            }
            depth += 1;
        }
        return ret;
    }

    public boolean DFS(TreeNode root, TreeNode target) {
        if (root == null) return false;
        if (root.val == target.val) return true;
        return DFS(root.left, target) || DFS(root.right, target);
    }

}
