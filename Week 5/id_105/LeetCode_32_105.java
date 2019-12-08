package id_105;

import java.util.Stack;

public class LeetCode_32_105 {


    public static int longestValidParentheses(String s) {

        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        int max = 0;
        for (int i = 0; i < s.length(); i++) {
           if (s.charAt(i) == '('){
               stack.push(i);
           }else{
              stack.pop();
              if (stack.isEmpty()){
                  stack.push(i);
              }else{
                  max = Math.max(max, i - stack.peek());
              }
           }
        }
        return max;
    }


    /**
     * time out .
     * @param s
     * @return
     */
    public static int forloop2(String s){
        int maxlen = 0;
        for (int i = 0; i < s.length(); i++) {
            for (int j = i + 2 ; j <= s.length(); j+=2) {
                if (isValid(s.substring(i,j))) {
                    maxlen = Math.max(maxlen, j - i);
                }
            }
        }
        return maxlen;
    }

    private static boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push('(');
            } else if (!stack.isEmpty() && stack.peek() == '(') {
                stack.pop();
            } else {
                return false;
            }
        }
        return stack.isEmpty();
    }

    /**
     * not ok while ()(()
     * @param s
     * @return
     */
    public static int forloop(String s) {
        Stack<Character> stack = new Stack<>();

        int total = 0;
        for (int i = 0; i < s.length(); i++) {
            Character ch = s.charAt(i);
            if (ch.equals('(')) {
                stack.push(ch);
            } else if (ch.equals(')')) {
                if (stack.size() > 0) {
                    stack.pop();
                    total++;
                }
            }
        }
        return total * 2;
    }


    public static void main(String[] args) {
        System.out.println(longestValidParentheses("(()"));
        System.out.println(longestValidParentheses(")()())"));
        System.out.println(longestValidParentheses("()(()"));
        System.out.println(longestValidParentheses("()())"));
    }
}
