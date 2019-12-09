package id_105;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class GenerateParentheses {

    class Node {
        private String res;

        private int left;
        private int right;

        public Node(String res, int left, int right) {
            this.res = res;
            this.left = left;
            this.right = right;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "res='" + res + '\'' +
                    ", left=" + left +
                    ", right=" + right +
                    '}';
        }
    }

    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        if (n == 0) {
            return res;
        }

        Queue<Node> queue = new LinkedList<>();
        queue.offer(new Node("", n, n));

        n = 2 * n;
        while (n > 0) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Node curNode = queue.poll();
                if (curNode.left > 0) {
                    queue.offer(new Node(curNode.res + "(", curNode.left - 1, curNode.right));
                }
                if (curNode.right > 0 && curNode.left < curNode.right) {
                    queue.offer(new Node(curNode.res + ")", curNode.left, curNode.right - 1));
                }
            }
            n--;
        }

        while (!queue.isEmpty()) {
            res.add(queue.poll().res);
        }
        return res;

    }


    public List<String> generateParenthesis2(int n) {
        if (n == 0) {
            return new ArrayList<>();
        }
        List<List<String>> dp = new ArrayList<>();

        List<String> dp0 = new ArrayList<>();
        dp0.add("");
        dp.add(dp0);


        for (int i = 1; i <= n; i++) {
            List<String> cur = new ArrayList<>();
            for (int j = 0; j < i; j++) {
                List<String> str1 = dp.get(j);
                List<String> str2 = dp.get(i - 1 -j);
                for (String s1 : str1) {
                    for (String s2 : str2) {
                        cur.add("(" + s1 + ")" + s2);
                    }
                }
            }
            dp.add(cur);
        }
       return dp.get(n);
    }


    public static void main(String[] args) {
        GenerateParentheses g = new GenerateParentheses();
        List<String> res = g.generateParenthesis2(3);
        for (String re : res) {
            System.out.println(re);
        }
    }
}
