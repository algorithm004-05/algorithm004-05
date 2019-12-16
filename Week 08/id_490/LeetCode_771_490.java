/**
 * 题目名称：jewels-and-stones 宝石与石头
 * 题目链接：https://leetcode-cn.com/problems/jewels-and-stones/
 */
class Solution {
    // 暴力求解
    public int numJewelsInStones(String J, String S) {
        int num = 0;
        for (char s : S.toCharArray()) {
            for (char j : J.toCharArray()) {
                if (s == j) {
                    num++;
                    break;
                }
            }
        }
        return num;
    }

    // 使用哈希集合
    public int numJewelsInStones2(String J, String S) {
        int ans = 0;
        Set<Character> JSet = new HashSet();
        for (char j : J.toCharArray()) {
            JSet.add(j);
        }
        for (char s : S.toCharArray()) {
            if (JSet.contains(s)) {
                ans++;
            }
        }
        
        return ans;
    }
}