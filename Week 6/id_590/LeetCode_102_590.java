package homework.week6;

import com.sun.jmx.remote.internal.ArrayQueue;

import java.util.*;
import java.util.concurrent.ArrayBlockingQueue;

//https://leetcode-cn.com/problems/binary-tree-level-order-traversal/
public class LeetCode_102_590 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    //BFS
    public List<List<Integer>> levelOrder_1(TreeNode root) {
        ArrayList<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return new ArrayList();
        }
        ArrayBlockingQueue<TreeNode> queue = new ArrayBlockingQueue<TreeNode>(1000);
        ArrayBlockingQueue<TreeNode> other_queue = new ArrayBlockingQueue<TreeNode>(1000);
        ArrayList<Integer> temp = new ArrayList<Integer>();
        queue.add(root);


        while (queue.size() != 0 || other_queue.size() != 0) {
            if (queue.size() == 0) {
                result.add((ArrayList) temp.clone());
                temp.clear();
                Iterator<TreeNode> iterator = other_queue.iterator();
                while (iterator.hasNext()) {
                    TreeNode next = iterator.next();
                    queue.offer(next);
                }
                other_queue.clear();
            } else {
                TreeNode peak = queue.poll();
                if (peak.left != null) {
                    other_queue.offer(peak.left);
                }

                if (peak.right != null) {
                    other_queue.offer(peak.right);
                }

                temp.add(peak.val);
            }
        }
        result.add(temp);
        return result;
    }

    public ArrayList<List<Integer>> _theResult = new ArrayList<>();

    //递归
    public List<List<Integer>> levelOrder_2(TreeNode root) {
        if (root == null) return _theResult;
        _drilldown(root, 0);
        return _theResult;
    }

    private void _drilldown(TreeNode node, int level) {
        if (level >= _theResult.size()) {
            _theResult.add(new ArrayList<Integer>());
        }

        List<Integer> _level = _theResult.get(level);

        _level.add(node.val);

        if (node.left != null) {
            _drilldown(node.left, level + 1);
        }

        if (node.right != null) {
            _drilldown(node.right, level + 1);
        }
    }


    //优化BFS
    public List<List<Integer>> levelOrder_3(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return new ArrayList();
        }
        Queue<TreeNode> queue = new LinkedList<>();

        queue.add(root);

        while (!queue.isEmpty()) {
            ArrayList<Integer> temp = new ArrayList<>();

            int level_length = queue.size();

            for (int i = 0; i < level_length; i++) {
                TreeNode peek = queue.poll();
                temp.add(peek.val);

                if (peek.left != null) {
                    queue.offer(peek.left);
                }

                if (peek.right != null) {
                    queue.offer(peek.right);
                }
            }

            result.add(temp);
        }
        return result;
    }
}
