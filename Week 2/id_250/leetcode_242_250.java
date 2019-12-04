import java.util.Arrays;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    //暴力排序法 时间O(nlog(n)) 空间O(n)
    public  boolean isAnagram1(String s, String t) {
        if(s.length()!=t.length())  return false;
        char[] arr_s = s.toCharArray();
        char[] arr_t=t.toCharArray();
        Arrays.sort(arr_s);
        Arrays.sort(arr_t);
        return Arrays.equals(arr_s,arr_t);
    }
    //hash表法
    public  boolean isAnagram2(String s, String t) {
        if(s.length()!=t.length())  return false;
        int[] arr=new int[26];
        char a='a';
        for (int i = 0; i < s.length(); i++) {
            arr[s.charAt(i)-a]++;
            arr[t.charAt(i)-a]--;
        }
        for (int i = 0; i < arr.length; i++) {
            if(arr[i]!=0)   return false;
        }
        return true;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
