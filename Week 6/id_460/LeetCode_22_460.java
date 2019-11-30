package week6.Question22GenerateParenthesis;

import java.util.ArrayList;
import java.util.List;

/**
 *给出 n 代表生成括号的对数，请你写出一个函数，使其能够生成所有可能的并且有效的括号组合。
 *
 * 例如，给出 n = 3，生成结果为：
 *
 * [
 *   "((()))",
 *   "(()())",
 *   "(())()",
 *   "()(())",
 *   "()()()"
 * ]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/generate-parentheses
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * */
public class GenerateParenthesis {
    public static void main(String[] args) {
        int n = 3;
        List<String> strings = generateParenthesis(n);
        for (String s:strings) {
            System.out.println(s);
        }
    }
    /**
     *
     * */
    private static  List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        if (n==0){
            return res;
        }
        //执行深度优先遍历，搜索可能的结果
        dfs("",n,n,res);
        return res;
    }

    private static void dfs(String curStr, int left, int right, List<String> res) {
        //left 和 right 表示剩余可以拼接的左括号和右括号的个数
        //递归终止条件：left==0 && right==0
        if (left == 0 && right==0){
            res.add(curStr);
            return;
        }

        //如果左边有剩余，继续递归
        if (left>0){
            //结果字符串上拼接一个左括号，剩余的左括号个数减1
            dfs(curStr+"(",left-1,right,res);
        }

        //right>0;right>left 时可以拼右括号
        if (right>0 && right>left){
            //结果字符串上拼接一个右括号，剩余的右括号个数减1
            dfs(curStr+")",left,right-1,res);
        }
    }
}
