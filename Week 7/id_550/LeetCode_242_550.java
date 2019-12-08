public class Solution {
    public boolean isAnagram(String s, String t) {
        char[] sc = s.toCharArray();
        char[] tc = t.toCharArray();
        Arrays.sort(sc);
        Arrays.sort(tc);
        String sortedS = new String(sc);
        String sortedT = new String(tc);
        
        return sortedS.equals(sortedT);
    }
}
