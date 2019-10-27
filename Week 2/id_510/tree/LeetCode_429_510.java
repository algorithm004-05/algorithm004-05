

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import sun.net.www.content.text.plain;

/**
 *给定一个 N 叉树，返回其节点值的层序遍历。 (即从左到右，逐层遍历)。
 *
 * 例如，给定一个 3叉树 :
 *
 *           1
 *      /    ｜   \
 *     3     2    4
 *   /  \
 * 5    6
 *  
 *
 * 返回其层序遍历:
 *
 * [
 *      [1],
 *      [3,2,4],
 *      [5,6]
 * ]
 *  
 *
 * 说明:
 *
 * 树的深度不会超过 1000。
 * 树的节点总数不会超过 5000。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/n-ary-tree-level-order-traversal
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LeetCode_429_510 {
    class Node {
        public int val;
        public List<Node> children;
        public Node() {
        }
        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }

    public static void main(String[] args) {
        int i=1;
        int j = 6;
        //int y = 0;
        //y = i++ + ++i;
        //System.out.println(i);
        //System.out.println(y);
        System.out.println(i-- >=1);
        j-=3;
        i=1;
        System.out.println(--i >1);
        System.out.println(j > i);
        System.out.println(i);
        System.out.println(j);
    }
    /**
     * 队列
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> res = new ArrayList<>();
        if(null == root){
            return res;
        }
        Queue<Node> linkedList =  new LinkedList<>();
        Node node = root;
        int level = 0;
        int currentLevel = 0;  // 当前层队列里剩余节点数  第一层剩余为0 
        int nextLevel = 0;   // 下一层个数位置，默认0开始叠加
        res.add(new ArrayList<Integer>());
        while(null != node || !linkedList.isEmpty()){
            // 当前层节点个数为0时，表示当前层已处理结束
            if(currentLevel == -1){
                // 开始处理下一层 计数重置  当前节点是第一个 所以减一，则为剩下的个数
                currentLevel = nextLevel-1;
                // 新的下层开始0
                nextLevel = 0;
                // 下一层索引
                level++;
                res.add(new ArrayList<Integer>());
            }
            res.get(level).add(node.val);
            List<Node> nodes =  node.children;
            if(null != nodes && nodes.size() > 0){
                // 下一层叠加节点数
                nextLevel += nodes.size();
                for (int i = 0; i < nodes.size(); i++) {
                    linkedList.offer(nodes.get(i));
                }
            }
            // 取队列头节点
            node = linkedList.poll();
            // 当前层计数减1
            currentLevel--;
        }
        return res;
    }

    /**
     * 
     * 栈
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrder1(Node root) {
        List<List<Integer>> res = new ArrayList<>();
        if (null == root) {
            return res;
        }
        Queue<Node> linkedList = new LinkedList<>();
        // 跟节点
        linkedList.offer(root);
        while (!linkedList.isEmpty()) {
            // 当前层计数
            int size = linkedList.size();
            List<Integer> list = new ArrayList<>();
            // 等于0时 当前层处理结束，队列里的都是下一层，跳到外层继续读取队列大小 循环处理
            while (size-- > 0) {
                // 获取头节点
                Node node = linkedList.poll();
                list.add(node.val);
                // 处理子节点
                List<Node> nodes = node.children;
                if (null != nodes && nodes.size() > 0) {
                    for (int i = 0; i < nodes.size(); i++) {
                        if (null != nodes.get(i)) {
                            linkedList.offer(nodes.get(i));
                        }
                    }
                }
            }
            // 当前层处理结束 按顺序添加到结果集
            res.add(list);
        }
        return res;
    }

    /**
     * 递归
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrder2(Node root) {
        List<List<Integer>> res = new ArrayList<>();
        if (null == root) {
            return res;
        }
        helper(root, res, 0);
        return res;
    }

    private void helper(Node root,List<List<Integer>> res,int level){
        if (null == root) {
            return;
        }
        if (res.size() <= level) {
            res.add(new ArrayList<Integer>());
        }
        res.get(level).add(root.val);
        List<Node> nodes = root.children;
        if (null != nodes && nodes.size() > 0) {
            int nextLevel = level+1;
            for (int i = 0; i < nodes.size(); i++) {
                helper(nodes.get(i), res, nextLevel);
            }
        }
    }
}
