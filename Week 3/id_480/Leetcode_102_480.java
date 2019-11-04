package leetcode.editor.cn;//给定一个二叉树，返回其按层次遍历的节点值。 （即逐层地，从左到右访问所有节点）。
//
// 例如: 
//给定二叉树: [3,9,20,null,null,15,7], 
//
//     3
//   / \
//  9  20
//    /  \
//   15   7
// 
//
// 返回其层次遍历结果： 
//
// [
//  [3],
//  [9,20],
//  [15,7]
//]
// 
// Related Topics 树 广度优先搜索

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Leetcode_102_480 {
    public static void main(String[] args) {
        Solution2 solution = new Leetcode_102_480().new Solution2();
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        List<List<Integer>> lists = solution.levelOrder(root);
        System.out.println(lists);
    }


//leetcode submit region begin(Prohibit modification and deletion)

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    /**
     * 使用DFS，采用前序遍历，每一层一个List
     */
    class Solution1 {
        private List<List<Integer>> levelOrderItems = new ArrayList<>();

        public List<List<Integer>> levelOrder(TreeNode root) {
            preOrder(root, 0);
            return levelOrderItems;
        }

        private void preOrder(TreeNode node, int level) {
            if (node == null) {
                return;
            }
            List<Integer> currentLevel = null;
            if (levelOrderItems.size() < level + 1) {
                currentLevel = new ArrayList<>();
                levelOrderItems.add(currentLevel);
            } else {
                currentLevel = levelOrderItems.get(level);
            }
            currentLevel.add(node.val);

            if (node.left != null) {
                preOrder(node.left, level + 1);
            }
            if (node.right != null) {
                preOrder(node.right, level + 1);
            }
        }
    }

    /**
     * 采用BFS
     */
    class Solution2 {
        private List<List<Integer>> levelOrderItems = new ArrayList<>();

        private Queue<TreeNode> levelQueue = new LinkedList<>();

        public List<List<Integer>> levelOrder(TreeNode root) {
            if (root == null) {
                return levelOrderItems;
            }
            levelQueue.add(root);

            while (!levelQueue.isEmpty()) {
                //当前层的大小
                int size = levelQueue.size();
                List<Integer> levelItems = new ArrayList<>();
                for (int i = 0; i < size; i++) {
                    TreeNode tmp = levelQueue.poll();
                    if (tmp == null) {
                        continue;
                    }
                    levelItems.add(tmp.val);
                    if (tmp.left != null) {
                        levelQueue.add(tmp.left);
                    }
                    if (tmp.right != null) {
                        levelQueue.add(tmp.right);
                    }
                }
                levelOrderItems.add(levelItems);
            }

            return levelOrderItems;
        }


    }
//leetcode submit region end(Prohibit modification and deletion)

}