package id_105;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 例如：
 * 给定二叉树 [3,9,20,null,null,15,7],
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 返回其自底向上的层次遍历为：
 *
 * [
 *   [15,7],
 *   [9,20],
 *   [3]
 * ]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/binary-tree-level-order-traversal-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LeetCode_102_105 {


    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> list = new ArrayList<List<Integer>>();
        revert(0, root, list);
        return list;
    }

    /**
     * 深度优先遍历，前序遍历
     * @param level
     * @param root
     * @param list
     */
    private void revert(int level, TreeNode root, List<List<Integer>> list) {
        if (root == null) {
            return;
        }
        List<Integer> levelList = null;
        if (list.size() < level + 1) {
            levelList = new ArrayList<Integer>();
            list.add(levelList);
        } else {
            levelList = list.get(level);
        }
        levelList.add(root.val);
        revert(level + 1, root.left, list);
        revert(level + 1, root.right, list);
    }


    /**
     * 广度优先遍历
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrder2(TreeNode root) {
        List<List<Integer>> list = new ArrayList<List<Integer>>();
        if (root == null) {
            return list;
        }
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        int level = 0;
        while (!queue.isEmpty()) {
            list.add(new ArrayList<Integer>());
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode cur = queue.remove();
                list.get(level).add(cur.val);
                if (cur.left != null) queue.add(cur.left);
                if (cur.right != null) queue.add(cur.right);
            }
            level++;
        }
        return list;
    }
}
