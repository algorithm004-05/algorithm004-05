import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
*
 * 序列化是将一个数据结构或者对象转换为连续的比特位的操作，进而可以将转换后的数据存储在一个文件或者内存中，同时也可以通过网络传输到另一个计算机环境，采取相反方式重构得到原数据。
 *
 * 请设计一个算法来实现二叉树的序列化与反序列化。这里不限定你的序列 / 反序列化算法执行逻辑，你只需要保证一个二叉树可以被序列化为一个字符串并且将这个字符串反序列化为原始的树结构。
 *
 * 示例: 
 *
 * 你可以将以下二叉树：
 *
 *     1
 *    / \
 *   2   3
 *      / \
 *     4   5
 *
 * 序列化为 "[1,2,3,null,null,4,5]"
 * 提示: 这与 LeetCode 目前使用的方式一致，详情请参阅 LeetCode 序列化二叉树的格式。你并非必须采取这种方式，你也可以采用其他的方法解决这个问题。
 *
 * 说明: 不要使用类的成员 / 全局 / 静态变量来存储状态，你的序列化和反序列化算法应该是无状态的。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/serialize-and-deserialize-binary-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LeetCode_297_510 {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public static void main(String[] args) {
        LeetCode_297_510.TreeNode root = new LeetCode_297_510.TreeNode(1);
        root.left = new LeetCode_297_510.TreeNode(2);
        root.right = new LeetCode_297_510.TreeNode(3);
        root.right.left = new LeetCode_297_510.TreeNode(4);
        root.right.right = new LeetCode_297_510.TreeNode(5);
        LeetCode_297_510 aa = new LeetCode_297_510();
        String ss = aa.serialize(root);
        System.out.println(ss);
        LeetCode_297_510.TreeNode root1 = aa.deserialize(ss);
        System.out.println(root1);
    }
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuffer sb = new StringBuffer();
        helper(root, sb);
        return sb.toString();
    }
    private void helper(TreeNode node,StringBuffer s){
        if(null == node){
            s.append("null").append(",");
        } else {
            s.append(node.val).append(",");
            helper(node.left, s);
            helper(node.right, s);
        }
    }

    
    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(null == data || 0 == data.length()){
            return null;
        }
        String[] ss = data.split(",");
        Queue<String> queue = new LinkedList<>();
        for (int i = 0; i < ss.length; i++) {
            queue.offer(ss[i]);
        }
        return helper2(queue);
    }

    public TreeNode helper2(Queue<String> queue) {
        String s = queue.poll();
        if("null".equals(s) || null == s || "".equals(s)){
            return null;
        }
        TreeNode node = new TreeNode(Integer.parseInt(s));
        node.left = helper2(queue);
        node.right = helper2(queue);
        return node;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));
