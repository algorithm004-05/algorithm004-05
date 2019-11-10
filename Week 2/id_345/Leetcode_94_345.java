package xyz.isok.algorithm.leetcode.medium;

import xyz.isok.algorithm.tree.binaryTree.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class No94BinaryTreeInorderTraversal {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(3);

        List<Integer> list1 = Solution.inorderTraversal(root);
        for (Integer integer : list1) {
            System.out.print(integer + " ");
        }
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
        public static List<Integer> inorderTraversal(TreeNode root) {
            List<Integer> list = new ArrayList<>();
            if (root == null) {
                return list;
            }
            inorder(root, list);
            return list;
        }

        private static void inorder(TreeNode root, List<Integer> list) {
            if (root.left != null) {
                inorder(root.left, list);
            }
            list.add(root.val);
            if (root.right != null) {
                inorder(root.right, list);
            }
        }

        /**
         * 迭代实现
         */
        public static List<Integer> iterate(TreeNode root) {
            List<Integer> list = new ArrayList<>();
            Stack<TreeNode> stack = new Stack<>();
            if (root == null){
                return list;
            }
            TreeNode cursor = root;
            iterateLeft(cursor, stack);

            TreeNode node = null;
            while (stack.size() > 0){
                node = stack.pop();
                list.add(node.val);
                if (node.right != null){
                    iterateLeft(node.right, stack);
                }
            }
            return list;
        }
        private static void iterateLeft(TreeNode cursor, Stack<TreeNode> stack){
            do {
                stack.push(cursor);
                cursor = cursor.left;
            } while (cursor != null);
        }
    }
}
