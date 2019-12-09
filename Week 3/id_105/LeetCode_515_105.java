package id_105;

import java.util.*;

/**
 * 您需要在二叉树的每一行中找到最大的值。
 *
 * 示例：
 *
 * 输入:
 *
 *           1
 *          / \
 *         3   2
 *        / \   \
 *       5   3   9
 *
 * 输出: [1, 3, 9]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/find-largest-value-in-each-tree-row
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LeetCode_515_105 {

    /**
     * 思路1： 宽度优先搜索
     *
     * @param root
     * @return
     */
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> list = new ArrayList<Integer>();
        if (root == null) {
            return list;
        }
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);

        Map<Integer,Integer> map = new HashMap<>();

        list.addAll(map.values());
        while (!queue.isEmpty()) {
            int max = Integer.MIN_VALUE;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode cur = queue.remove();
                if (cur.val > max) max = cur.val;
                if (cur.left != null) queue.add(cur.left);
                if (cur.right != null) queue.add(cur.right);
            }
            list.add(max);
        }
        return list;
    }


    /**
     *思路2：深度优先搜索,用map把每层的最大值存储起来。
     * 注意：new ArrayList<Integer>(Collection)
     */
    public List<Integer> largestValues2(TreeNode root) {
        List<Integer> list = new ArrayList<Integer>();
        if(root == null){
            return list;
        }
        Map<Integer,Integer> map = new HashMap<Integer,Integer>();
        revert(root, 0, map);

        list = new ArrayList<Integer>(map.values());
        return list;
    }

    private void revert(TreeNode root, int level, Map<Integer,Integer> map){
        if(root == null){
            return;
        }
        Integer max = map.get(level);
        if(max == null) max = Integer.MIN_VALUE;
        if(root.val >= max){
            map.put(level, root.val);
        }
        revert(root.left,level + 1, map);
        revert(root.right, level + 1, map);
    }
}
