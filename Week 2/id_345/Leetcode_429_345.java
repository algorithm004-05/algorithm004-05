package xyz.isok.algorithm.leetcode.medium;

import xyz.isok.algorithm.tree.nAryTree.Node;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class No429NAryTreeLevelOrderTraversal {

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
        List<List<Integer>> list2 = Solution.levelOrder(root);
        System.out.println(list2);
//        for (Integer integer : list2) {
//            System.out.print(integer + " ");
//        }

    }

    static class Solution {

        public static List<List<Integer>> levelOrder(Node root) {
            List<List<Integer>> lists = new ArrayList<>();
            if (root == null){
                return lists;
            }

            int level = 0;
            Node cursor = root;
            recursive(cursor, level, lists);
            return lists;
        }

        private static void recursive(Node node, Integer level, List<List<Integer>> lists) {
            List<Integer> list = null;
            while (lists.size() < level + 1){
                list = new ArrayList<>();
                lists.add(list);
            }
            list = lists.get(level);
            list.add(node.val);
            List<Node> children = node.children;
            if (children != null && children.size() > 0) {
                for (Node child : children) {
                    recursive(child, level + 1, lists);
                }
            }
        }

        public static List<List<Integer>> levelOrder0(Node root) {
            if (root == null){
                return new ArrayList<>();
            }
            Map<Integer, List<Integer>> map = new HashMap<>();
            int level = 1;
            Node cursor = root;
            recursive0(cursor, level, map);
            return new ArrayList<>(map.values());
        }

        private static void recursive0(Node node, Integer level, Map<Integer, List<Integer>> map) {
            if (!map.containsKey(level)){
                map.put(level, new ArrayList<>());
            }
            List<Integer> list = map.get(level);
            list.add(node.val);
            List<Node> children = node.children;
            if (children != null && children.size() > 0) {
                for (Node child : children) {
                    recursive0(child, level + 1, map);
                }
            }
        }


        public static List<List<Integer>> levelOrder1(Node root) {
            List<List<Integer>> lists = new ArrayList<>();
            if (root == null){
                return lists;
            }
            boolean isContinue = true;
            int level = 1;
            Node cursor = root;
            do {
                int index = 1;
                List<Integer> list = new ArrayList<>();
                recursive1(cursor, list, level, index);
                isContinue = list.size() > 0;
                if (isContinue){
                    lists.add(list);
                    level++;
                }
            }while (isContinue);
            return lists;
        }

        private static void recursive1(Node node, List<Integer> list, int level, int index) {
            if (level == index){
                list.add(node.val);
            }else {
                List<Node> children = node.children;
                if (children != null && children.size() > 0){
                    for (Node child : children) {
                        recursive1(child, list, level, index + 1);
                    }
                }
            }
        }
    }
}
