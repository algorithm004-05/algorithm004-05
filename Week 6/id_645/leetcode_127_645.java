/*
 * @lc app=leetcode id=127 lang=java
 *
 * [127] Word Ladder
 */

// @lc code=start
class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if(!wordList.contains(endWord)){
            return 0;
        }
        HashSet<String> beginSet = new HashSet<>();
        HashSet<String> endSet = new HashSet<>();
        HashSet<String> visited = new HashSet<>();
        beginSet.add(beginWord);
        endSet.add(endWord);
        int len = 1;
        while(!beginSet.isEmpty() && !endSet.isEmpty()){
            if(beginSet.size()>endSet.size()){
                HashSet<String> temp = new HashSet<String>();
                temp = endSet;
                endSet = beginSet;
                beginSet = temp;
            }

            HashSet<String> temp = new HashSet<>();
            for(String word:beginSet){
                char[] chs = word.toCharArray();
                for(int i = 0;i< chs.length;i++){
                    char old = chs[i];
                    for(char c= 'a';c<='z';c++){
                        chs[i] = c;
                        String target = String.valueOf(chs);
                        if(endSet.contains(target)){
                            return len+1;
                        }
                        if(!visited.contains(target)&& wordList.contains(target)){
                            temp.add(target);
                            visited.add(target);
                        }
                    }
                    chs[i] = old;
                }
            }
            beginSet = temp;
            len++;
        }
        return 0;
    }
}
// @lc code=end

