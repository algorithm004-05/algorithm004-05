/**
 * 题目名称：reverse-only-letters 仅仅反转字母
 * 题目链接：https://leetcode-cn.com/problems/reverse-only-letters/
 */
class Solution {
    public String reverseOnlyLetters(String S) {
        char[] arr = S.toCharArray();
        int left = 0, right = arr.length - 1;
        while (left <= right) {
            while (left < arr.length && !Character.isLetter(arr[left])) left++;
            while (right >= 0 && !Character.isLetter(arr[right])) right--;
            if (left > right || left >= arr.length) break;
            char tmp = arr[left];
            arr[left++] = arr[right];
            arr[right--] = tmp;
        }

        return new String(arr);
    }

    // 使用Stack栈
    public String reverseOnlyLetters2(String S) {
        Stack<Character> letters = new Stack();
        for (char c : S.toCharArray()) {
            if (Character.isLetter(c)) {
                letters.push(c);
            }
        } 
        StringBuilder ans = new StringBuilder();
        for (char c : S.toCharArray()) {
            if (Character.isLetter(c)) {
                ans.append(letters.pop());
            } else {
                ans.append(c);
            }
        }

        return ans.toString();
    }
}