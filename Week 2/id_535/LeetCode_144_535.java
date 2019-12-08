import java.time.Instant;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * created by lchen on 2019/10/25
 */
public class LeetCode_144_535 {

    public static void main(String[] args) {
        Solution2 solution2 = new Solution2();
        TreeNode root = new TreeNode(1);
        TreeNode node1 = new TreeNode(2);
        TreeNode node2 = new TreeNode(3);
        root.left = node2;
        root.right = node1;
        List<Integer> integers = solution2.preorderTraversal(root);
        for (Integer integer : integers) {
            System.out.println(integer);
        }

    }
}

class Solution2 {
    public List<Integer> preorderTraversal(TreeNode root) {
        //前序 根-左-右
        Stack<TreeNode> nodes = new Stack<>();
        List<Integer> vals = new ArrayList<>();
        if (root == null) return vals;
        nodes.push(root);
        while (!nodes.isEmpty()) {
            TreeNode node = nodes.pop();
            vals.add(node.val);
            if (node.right != null) {
                nodes.push(node.right);
            }
            if (node.left != null) {
                nodes.push(node.left);
            }

        }
        return vals;

    }

}

