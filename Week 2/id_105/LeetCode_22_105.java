package id_105;

import java.util.ArrayList;
import java.util.List;

public class LeetCode_22_105 {

    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        generate(0, 0, n, "", result);
        return result;
    }


    private void generate(int left, int right, int n, String s , List<String> result) {
        if (n == left && n == right) {
            result.add(s);
            return;
        }

        if (left < n)
            generate(left + 1, right, n, s + "(", result);
        if (right < left)
            generate(left, right + 1, n, s + ")", result);
    }

    public static void main(String[] args) {
        LeetCode_22_105 leetCode_22_105 = new LeetCode_22_105();
        leetCode_22_105.generateParenthesis(3);
    }
}
