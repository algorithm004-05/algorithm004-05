import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import javax.swing.tree.TreeNode;

/*
 * @lc app=leetcode.cn id=102 lang=java
 *
 * [102] 二叉树的层次遍历
 */

// @lc code=start
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
    //     //方法一，DFS，迭代
    //     List<List<Integer>> result = new ArrayList<>();
    //     levelHelper(result, root, 0);
    //     return result;
    // }

    // public void levelHelper(List<List<Integer>> result, TreeNode root, int height) {
    //     //terminator
    //     if (root == null) return;

    //     //process current logic
    //     if (height >= result.size()) {
    //         result.add(new ArrayList<Integer>());
    //     }
    //     result.get(height).add(root.val);
    //     levelHelper(result, root.left, height+1);
    //     levelHelper(result, root.right, height+1);

    // }

    //方法二，迭代，用队列完成
    Queue<TreeNode> queue = new LinkedList<TreeNode>();
    List<List<Integer>> result = new ArrayList<>();
    
    if (root == null) return result;

    queue.offer(root);
    while(!queue.isEmpty()) {
        int levelNum = queue.size();
        List<Integer> subList = new ArrayList<>();
        for(int i = 0; i<levelNum; i++) {
            if(queue.peek().left != null) queue.offer(queue.peek().left);
            if(queue.peek().right != null) queue.offer(queue.peek().right);
            subList.add(queue.poll().val);
        }
        result.add(subList);
    }
    return result;
}
}
// @lc code=end

