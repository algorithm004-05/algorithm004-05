package geekbang.myleetcode.week02;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class LeetCode_94_420 {

    public static void main(String[] args) {
        TreeNode treeNode_3 = new TreeNode(3);
        TreeNode treeNode_2 = new TreeNode(2);
        treeNode_2.left = treeNode_3;
        TreeNode treeNode_1 = new TreeNode(1);
        treeNode_1.right = treeNode_2;

        Solution_2 solution = new LeetCode_94_420().new Solution_2();
        List<Integer> orders = solution.inorderTraversal(treeNode_1);
        System.out.println("main:");
        for (Integer order : orders) {
            System.out.println(order);
        }
    }

    /**
     * 基于颜色标记法-一种通用且简明的树遍历方法
     */
    class Solution_2 {
        public List<Integer> inorderTraversal(TreeNode root) {
            List<Integer> res = new ArrayList<Integer>();
            Stack<Tuple> stack = new Stack<Tuple>();
            stack.push(new Tuple(Color.WHITE, root));
            while (!stack.isEmpty()) {
                Tuple curr = stack.pop();
                if (null == curr.treeNode) {
                    continue;
                }
                if (Color.WHITE == curr.color) {
                    stack.push(new Tuple(Color.WHITE, curr.treeNode.right));
                    stack.push(new Tuple(Color.GRAY, curr.treeNode));
                    stack.push(new Tuple(Color.WHITE, curr.treeNode.left));
                } else {
                    res.add(curr.treeNode.val);
                }
            }
            return res;
        }
    }
    enum Color {
        /**
         * 未访问
         */
        WHITE((byte) 0),
        /**
         * 已访问
         */
        GRAY((byte) 1),
        ;

        private Byte code;

        public Byte getCode() {
            return code;
        }

        Color(Byte code) {
            this.code = code;
        }
    }
    class Tuple {
        Color color;
        TreeNode treeNode;

        Tuple(Color color, TreeNode treeNode) {
            this.color = color;
            this.treeNode = treeNode;
        }

        public Color getColor() {
            return color;
        }

        public TreeNode getTreeNode() {
            return treeNode;
        }
    }

    /**
     * 基于栈的遍历
     */
    class Solution_1 {
        public List<Integer> inorderTraversal(TreeNode root) {
            List<Integer> res = new ArrayList<Integer>();
            Stack<TreeNode> stack = new Stack<TreeNode>();
            TreeNode current = root;
            while (null != current || !stack.isEmpty()) {
                while (null != current) {
                    stack.push(current);
                    current = current.left;
                }
                current = stack.pop();
                res.add(current.val);
                current = current.right;
            }
            return res;
        }
    }

    /**
     * 递归
     */
    class Solution {
        public List<Integer> inorderTraversal(TreeNode root) {
            List<Integer> res = new ArrayList<Integer>();
            helper(root, res);
            return res;
        }

        private void helper(TreeNode root, List<Integer> res) {
            if (null == root) {
                return;
            }
            if (null != root.left) {
                helper(root.left, res);
            }
            res.add(root.val);
            if (null != root.right) {
                helper(root.right, res);
            }
        }
    }




    /**
     * Definition for a binary tree node.
     */
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
