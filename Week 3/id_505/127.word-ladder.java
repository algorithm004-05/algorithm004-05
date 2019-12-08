/*
 * @lc app=leetcode id=127 lang=java
 *
 * [127] Word Ladder
 *
 * https://leetcode.com/problems/word-ladder/description/
 *
 * algorithms
 * Medium (25.92%)
 * Likes:    1965
 * Dislikes: 930
 * Total Accepted:    316.8K
 * Total Submissions: 1.2M
 * Testcase Example:  '"hit"\n"cog"\n["hot","dot","dog","lot","log","cog"]'
 *
 * Given two words (beginWord and endWord), and a dictionary's word list, find
 * the length of shortest transformation sequence from beginWord to endWord,
 * such that:
 * 
 * 
 * Only one letter can be changed at a time.
 * Each transformed word must exist in the word list. Note that beginWord is
 * not a transformed word.
 * 
 * 
 * Note:
 * 
 * 
 * Return 0 if there is no such transformation sequence.
 * All words have the same length.
 * All words contain only lowercase alphabetic characters.
 * You may assume no duplicates in the word list.
 * You may assume beginWord and endWord are non-empty and are not the same.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input:
 * beginWord = "hit",
 * endWord = "cog",
 * wordList = ["hot","dot","dog","lot","log","cog"]
 * 
 * Output: 5
 * 
 * Explanation: As one shortest transformation is "hit" -> "hot" -> "dot" ->
 * "dog" -> "cog",
 * return its length 5.
 * 
 * 
 * Example 2:
 * 
 * 
 * Input:
 * beginWord = "hit"
 * endWord = "cog"
 * wordList = ["hot","dot","dog","lot","log"]
 * 
 * Output: 0
 * 
 * Explanation: The endWord "cog" is not in wordList, therefore no possible
 * transformation.
 * 
 * 
 * 
 * 
 * 
 */

// @lc code=start
class Solution {
    //把问题抽象为通过BFS解决的问题
    //第一个字母为根节点，如何构造BFS访问路径，这个是关键，第一个字符通过替换26个字母和第二个字符对比，就可以知道
    //是否是BFS的访问路径
    //由于是BFS的访问，因此第一个访问到的endword返回访问的深度就是结果
    //记录已经访问过的节点，以防形成环
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {

        HashSet<String> set = new HashSet<String>(wordList), visted = new HashSet<String>();
        Queue<String> Q = new LinkedList<String>();
        Q.offer(beginWord);
        Integer ladder = 1;
        while (!Q.isEmpty()) {

            int n = Q.size();
            for (int i = n; i > 0; i--) {

                String current = Q.poll();
                if (current.equals(endWord)) return ladder;

                for (int j=0;j < current.length();j++ ) {
                    char[] arr = current.toCharArray();
                    for ( char c = 'a'; c <= 'z'; c++) {
                        if(arr[j] == c) continue;
                        arr[j] = c;
                        String newstr = String.valueOf(arr);
                        if(set.contains(newstr) && !visted.contains(newstr)) {
                            visted.add(newstr);
                            Q.offer(newstr);
                        }
                    }
                }
            }
            ladder++;
            
        }
        
        return 0;
    }


}
// @lc code=end

