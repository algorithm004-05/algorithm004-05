import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @Auther: 封玉书 FYS
 * @Date: 2019.10.26 22:49
 * @Description:
 */
public class A144 {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }

        @Override
        public String toString() {
            return "TreeNode{" +
                    "val=" + val +
                    ", left=" + left +
                    ", right=" + right +
                    '}';
        }
    }

    /**
     * 二叉树前序遍历
     *
     * @param args
     */
    public static void main(String[] args) {

        TreeNode treeNode = new TreeNode(1);
        treeNode.right = new TreeNode(2);
        treeNode.right.left = new TreeNode(3);

        System.out.println(preorderTraversal1(treeNode));
        System.out.println(preorderTraversal2(treeNode));

    }

    private static List<Integer> preorderTraversal1(TreeNode treeNode) {
        List<Integer> res = new ArrayList<>();
        travel(treeNode, res);
        return res;
    }

    /**
     * 递归算法，与94题目一致
     * 复杂度O(n)
     *
     * @param treeNode
     * @param res
     */
    private static void travel(TreeNode treeNode, List<Integer> res) {

        if (treeNode == null) {
            return;
        }

        res.add(treeNode.val);

        if (treeNode.left != null) {
            travel(treeNode.left, res);
        }

        if (treeNode.right != null) {
            travel(treeNode.right, res);
        }
    }

    /**
     * stack算法，与94题目一致
     * 复杂度O(n)
     *
     * @param treeNode
     */
    private static List<Integer> preorderTraversal2(TreeNode treeNode) {

        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();

        TreeNode cur = treeNode;
        while (cur != null || !stack.isEmpty()) {

            while (cur != null) {
                res.add(cur.val);
                stack.push(cur);
                cur = cur.left;
            }

            cur = stack.pop();
            cur = cur.right;
        }


        return res;
    }
}
