package xyz.isok.algorithm.leetcode.medium;

import xyz.isok.algorithm.tree.binaryTree.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class No144BinaryTreePreorderTraversal {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(4);
        root.left.left = new TreeNode(5);
        root.left.right = new TreeNode(6);
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(3);
        root.right.right = new TreeNode(7);

        List<Integer> list1 = Solution.preorderTraversal(root);
        for (Integer integer : list1) {
            System.out.print(integer + " ");
        }
        System.out.println();
        System.out.println("----------------");
        List<Integer> list2 = Solution.iterate(root);
        for (Integer integer : list2) {
            System.out.print(integer + " ");
        }
    }

    static class Solution {
        /**
         * 递归实现
         * @param root
         * @return
         */
        public static List<Integer> preorderTraversal(TreeNode root) {
            List<Integer> list = new ArrayList<>();
            if (root == null) {
                return list;
            }
            preorder(root, list);
            return list;
        }

        private static void preorder(TreeNode root, List<Integer> list) {
            list.add(root.val);
            if (root.left != null) {
                preorder(root.left, list);
            }
            if (root.right != null) {
                preorder(root.right, list);
            }
        }

        public static List<Integer> iterate(TreeNode root) {
            List<Integer> list = new ArrayList<>();
            Stack<TreeNode> stack = new Stack<>();
            if (null == root){
                return list;
            }
            TreeNode cursor = root;
            iterateRoot(cursor, stack, list);
            while (stack.size() > 0){
                TreeNode node = stack.pop();
                if (node.right != null){
                    iterateRoot(node.right, stack, list);
                }
            }
            return list;
        }

        private static void iterateRoot(TreeNode cursor, Stack<TreeNode> stack, List<Integer> list) {
            do {
                list.add(cursor.val);
                stack.push(cursor);
                cursor = cursor.left;
            }while (cursor != null);
        }
    }
}
