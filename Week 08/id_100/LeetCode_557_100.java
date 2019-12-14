public class LeetCode_557_100 {
    public String reverseWords(String s) {
        String[] strs = s.split(" ");
        String ret = "";
        for (int i = 0; i < strs.length; i++) {
            char[] chars = strs[i].toCharArray();
            int start = 0;
            int end = chars.length - 1;
            while (start < end) {
                char temp = chars[start];
                chars[start++] = chars[end];
                chars[end--] = temp;
            }
            ret += new String(chars) + " ";
        }
        return ret.trim();
    }
}