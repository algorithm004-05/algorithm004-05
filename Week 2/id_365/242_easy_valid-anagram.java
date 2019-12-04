// 给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。

// 示例 1:

// 输入: s = "anagram", t = "nagaram"
// 输出: true
// 示例 2:

// 输入: s = "rat", t = "car"
// 输出: false
// 说明:
// 你可以假设字符串只包含小写字母。

// 进阶:
// 如果输入字符串包含 unicode 字符怎么办？你能否调整你的解法来应对这种情况？  使用HashCode进行查询与存储
class Solution {
    public boolean isAnagram(String s, String t) {
        return this.isAnagramHashMap(s,t);
    }
    //字母一共26个，创建一个长度为26的数组，先把S分成char 然后按照顺序放入数组
    //然后进行另外一个字符串的遍历，如果数组里包含字符就减少计数
    //如果计数小于0 则表示有不同字母
    boolean isAnagramHashMap(String s, String t) {
        if(s.length() != t.length()) {
            return false;
        }
        int[] table = new int[26];
        char[] str1 = s.toCharArray();
        char[] str2 = t.toCharArray();
        for (int i = 0; i<str1.length;i++)
        {
            table[str1[i] - 'a']++;
        }
        
        for(int i = 0 ; i<t.length();i++)
        {
            table[str2[i]-'a']--;
            if(table[str2[i]-'a']<0)
            {
                return false;
            }
        }
        
        return true;
    }
    
//     排序字符串，然后进行比较，相同则为ok
    boolean isAnagramOne(String s, String t) {
        if(s.length() != t.length()) {
            return false;
        }
        char[] str1 = s.toCharArray();
        char[] str2 = t.toCharArray();
        
        Arrays.sort(str1);
        Arrays.sort(str2);
        
        return Arrays.equals(str1,str2);
    }
}