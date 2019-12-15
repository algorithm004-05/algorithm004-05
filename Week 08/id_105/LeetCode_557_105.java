public class LeetCode_557_105 {

    public String reverseWords(String s) {
        String[] strs = s.split(" ");
        StringBuffer b = new StringBuffer();
        for (String str : strs) {
            char[] chars = str.toCharArray();
            int start = 0;
            int end = chars.length - 1;
            while (start < end) {
                char tmp = chars[start];
                chars[start++] = chars[end];
                chars[end--] = tmp;
            }
            b.append(chars);
            b.append(" ");
        }
        return b.toString().trim();
    }

}
