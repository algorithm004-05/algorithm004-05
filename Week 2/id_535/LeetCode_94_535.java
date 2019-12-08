import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * created by lchen on 2019/10/24
 */
public class LeetCode_94_535 {

    public static void main(String[] args) {
        Solution1 solution1 = new Solution1();
        TreeNode root = new TreeNode(1);
        TreeNode node1 = new TreeNode(2);
        TreeNode node2 = new TreeNode(3);
        root.left = node2;
        root.right = node1;
        List<Integer> integers = solution1.inorderTraversal(root);
        for (Integer integer : integers) {
            System.out.println(integer);
        }
    }

}

class Solution1 {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> vals = new ArrayList<>();
        if (root == null) return null;
        Stack<TreeNode> nodes = new Stack<>();
        TreeNode node = root;
        while (node != null || !nodes.isEmpty()) {
            while (node != null) {
                nodes.push(node);
                node = node.left;
            }
            node = nodes.pop();
            vals.add(node.val);
            node = node.right;
        }
        return vals;
    }

}
