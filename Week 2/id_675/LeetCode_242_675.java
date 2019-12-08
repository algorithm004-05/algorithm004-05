//给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。 
//
// 示例 1: 
//
// 输入: s = "anagram", t = "nagaram"
//输出: true
// 
//
// 示例 2: 
//
// 输入: s = "rat", t = "car"
//输出: false 
//
// 说明: 
//你可以假设字符串只包含小写字母。 
//
// 进阶: 
//如果输入字符串包含 unicode 字符怎么办？你能否调整你的解法来应对这种情况？ 
// Related Topics 排序 哈希表


import java.util.HashMap;
import java.util.Map;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()) return false;
        int[] charNum = new int[26];
        char[] sChar = s.toCharArray();
        char[] tChar = t.toCharArray();
        for(int i = 0;i<s.length();i++){
            charNum[sChar[i]-'a']++;
            charNum[tChar[i]-'a']--;
        }
        for (int num:charNum){
            if (num != 0 ){
                return false;
            }
        }
        return true;
    }

   /**  方法一：考虑问题复杂，时间复杂度是O（n）
    *  public boolean isAnagram(String s, String t) {
        if(s==null || t == null) return true;
        if(s.length() != t.length()) return false;
        char[] sArray = s.toCharArray();
        Map<Character,Integer> sMap = new HashMap<Character,Integer>();
        for (char a: sArray){

                sMap.put(a,sMap.getOrDefault(a,0)+1);
        }
        char[] tArray = t.toCharArray();
        for (char a: tArray){
            if (sMap.getOrDefault(a,0) > 1){
                sMap.put(a,sMap.get(a)-1);
            }else if(sMap.getOrDefault(a,0) == 1){
                sMap.remove(a);
            }
            else {
                return false;
            }
        }
        if(sMap.isEmpty()){
            return  true;
        } else{
            return false;
        }
   }**/
}
//leetcode submit region end(Prohibit modification and deletion)
