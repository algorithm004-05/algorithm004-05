public class LeetCode_151_100 {

    public String reverseWords(String s) {
        String[] words =s.trim().split(" +");
        int i = 0;
        int j = words.length - 1;
        while (i < j) {
            String temp = words[i];
            words[i++] = words[j];
            words[j--] = temp;
        }
        return String.join(" ", words);
    }

}