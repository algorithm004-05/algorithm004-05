// #2 hash 表
class Solution {
    public boolean isAnagram(String s, String t) {
        
        if (s.length() != t.length()) {
            return false;
        }
        
        int[] str = new int[26];
        
        for (int i=0; i<s.length(); i++) {
            str[s.charAt(i) - 'a']++;
            str[t.charAt(i) - 'a']--;
        }
        
        for (int val: str) {
            if (val != 0) {
                return false;
            }
        }
        
        return true;
    }
}

// #1 排序
//    综合整体时间复杂度为 O(n*logn)
//    TODO: 简单看一下 Arrays 的常用方法实现，并整理复杂度
// class Solution {
//     public boolean isAnagram(String s, String t) {
//         // 当长度不一致时，直接返回
//         if (s.length() != t.length()) {
//             return false;
//         }
        
//         char[] str_s = s.toCharArray();
//         char[] str_t = t.toCharArray();
        
//         // 排序时间复杂度 O(n*logn)
//         Arrays.sort(str_s);
//         Arrays.sort(str_t);
        
//         // 时间复杂度为 O(n)
//         return Arrays.equals(str_s, str_t);
//     }
// }
