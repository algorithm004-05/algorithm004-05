package xyz.isok.algorithm.leetcode.medium;

import xyz.isok.algorithm.tree.binaryTree.TreeNode;

/**
 * https://leetcode-cn.com/problems/lowest-common-ancestor-of-a-binary-tree/
 *
 * 没有调完
 */
public class No236LowestCommonAncestorOfABinaryTree {

    public static void main(String[] args) {

        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(5);
        root.left.left = new TreeNode(6);
        root.left.right = new TreeNode(2);
        root.left.right.left = new TreeNode(7);
        root.left.right.right = new TreeNode(4);
        root.right = new TreeNode(1);
        root.right.left = new TreeNode(0);
        root.right.right = new TreeNode(8);

//        TreeNode root = new TreeNode(1);
//        root.left = new TreeNode(2);

//        TreeNode target = new Solution().lowestCommonAncestor(root, root, root.left);
        TreeNode target = new Solution().lowestCommonAncestor(root, root.left, root.left.right.right);
        System.out.println(target.val);

    }

    static class Solution {
        private TreeNode ans;
        public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
            int num = 0;
            router(root, p, q, num);
            return ans;
        }

        private int router(TreeNode node, TreeNode p, TreeNode q, int num) {
            if (node == null){
                return num;
            }
            if (node.val == p.val || node.val == q.val){
                num++;
            }
            num = router(node.left, p, q, num);
            num = router(node.right, p, q, num);
            if (num == 2) {
                ans = node;
            }
            return num;
        }

//        public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
//            Map<Integer, Set<TreeNode>> map = new HashMap<>();
//            router(root, p, map);
//            router(root, q, map);
//            boolean flag = map.get(q.val).size() > map.get(p.val).size();
//            Set<TreeNode> more = flag ? map.get(q.val) : map.get(p.val);
//            Set<TreeNode> less = !flag ? map.get(q.val) : map.get(p.val);
//            for (TreeNode treeNode : more) {
//                for (TreeNode node : less) {
//                    if (treeNode.equals(node)){
//                        return node;
//                    }
//                }
//            }
//            return null;
//        }
//
//        private static boolean router(TreeNode node, TreeNode target, Map<Integer, Set<TreeNode>> map) {
//            if (node.val == target.val){
//                if (map.get(target.val) == null){
//                    map.put(target.val, new HashSet());
//                }
//                map.get(target.val).add(node);
//                return true;
//            }
//            if (node.left != null){
//                if (!map.containsKey(target.val) && router(node.left, target, map)){
//                    map.get(target.val).add(node);
//                    return true;
//                }
//            }
//            if (node.right != null){
//                if (!map.containsKey(target.val) && router(node.right, target, map)){
//                    map.get(target.val).add(node);
//                    return true;
//                }
//            }
//            return false;
//        }
    }




}
