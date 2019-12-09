package geektime.dfs;

import geektime.tree.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class LevelOrder {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> visited = new ArrayList<List<Integer>>();
        int level = 0;
        helper(root, level, visited);
        return visited;
    }
    public void helper(TreeNode node, int level, List<List<Integer>> visited) {
        if (node == null) return;
        if (visited.size() == level) {
            visited.add(new ArrayList<Integer>());
        }
        visited.get(level).add(node.val);
        if (node.left != null) {
            helper(node.left, level + 1, visited);
        }
        if (node.right != null) {
            helper(node.right, level + 1, visited);
        }
    }
}
