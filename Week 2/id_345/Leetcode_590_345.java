package xyz.isok.algorithm.leetcode.easy;

import xyz.isok.algorithm.tree.nAryTree.Node;

import java.util.ArrayList;
import java.util.List;

public class No590NAryTreePostorderTraversal {

    public static void main(String[] args) {
        List<Node> list = new ArrayList<>();
        Node node = new Node();
        node.val = 5;
        list.add(node);

        node = new Node();
        node.val = 6;
        list.add(node);

        node = new Node(3, list);
        list = new ArrayList<>();
        list.add(node);
        node = new Node();
        node.val = 2;
        list.add(node);
        node = new Node();
        node.val = 4;
        list.add(node);

        Node root = new Node(1, list);
        List<Integer> list2 = Solution.postorder(root);
        for (Integer integer : list2) {
            System.out.print(integer + " ");
        }

    }

    static class Solution {

        public static List<Integer> postorder(Node root) {
            List<Integer> list = new ArrayList<>();
            if (root == null) {
                return list;
            }
            recursive(root, list);
            return list;
        }

        private static void recursive(Node node, List<Integer> list) {
            List<Node> nodes = node.children;
            if (nodes != null && nodes.size() > 0) {
                for (Node child : nodes) {
                    recursive(child, list);
                }
            }
            list.add(node.val);
        }
    }



}
