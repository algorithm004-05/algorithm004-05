class Solution {
    public boolean isAnagram(String s, String t) {
    // 长度不一样，肯定不是异位词
    if (s.length() != t.length()) {
        return false;
    }
    // 计数器
    int[] counter = new int[26];
    for (int i = 0; i < s.length(); i++) {
        counter[s.charAt(i) - 'a']++;
        counter[t.charAt(i) - 'a']--;
    }
    // 计数器有一个不为0，则不是
    for (int c : counter) {
        if (c != 0) {
            return false;
        }
    }
    return true;    
  }
}
