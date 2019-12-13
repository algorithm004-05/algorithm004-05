public class LeetCode_541_105 {

    public String reverseStr(String s, int k) {
        char[] chars = s.toCharArray();
        for(int i = 0; i < s.length(); i += 2 * k){
            int start = i;
            int end = Math.min(s.length()-1, i + k - 1);
            while (start < end) {
                char tmp = chars[start];
                chars[start++] = chars[end];
                chars[end--] = tmp;
            }
        }

        return new String(chars);

    }

    public static void main(String[] args) {
        LeetCode_541_105 l = new LeetCode_541_105();
        System.out.println(l.reverseStr("abcdefg", 2));
        System.out.println(l.reverseStr("abcdef", 3));

    }
}
