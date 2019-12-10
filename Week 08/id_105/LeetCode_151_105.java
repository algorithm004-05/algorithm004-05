public class LeetCode_151_105 {

    public String reverseWords(String s) {

        String[] strs = s.split(" ");
        StringBuffer b = new StringBuffer();
        for (int i = strs.length - 1; i >= 0; i--) {
            if (strs[i].equals("")) continue;
            b.append(strs[i].replaceAll(" ", "").trim() + " ");
        }
        return b.toString().trim();
    }

}
