import javafx.util.Pair;

class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        
        int strLen = beginWord.length();
        
        HashMap<String, ArrayList<String>> allComboDict = new HashMap<String, ArrayList<String>>();
        
        // 预处理
        wordList.forEach(
            word -> {
                for (int i=0; i<strLen; i++) {
                    // 对匹配相同 通配字符串的输入字符串做归纳整理
                    String newWord = word.substring(0, i) + '*' + word.substring(i + 1, strLen);
                    ArrayList<String> transformations = allComboDict.getOrDefault(newWord, new ArrayList<String>());
                    transformations.add(word);
                    allComboDict.put(newWord, transformations);
                }
            });
        
        // 用于广度优先遍历的队列
        Queue<Pair<String, Integer>> Q = new LinkedList<Pair<String, Integer>>();
        Q.add(new Pair(beginWord, 1));
        
        // 记录节点是否已经被访问过
        HashMap<String, Boolean> visited = new HashMap<String, Boolean>();
        visited.put(beginWord, true);
        
        // 如果 Q 为空直接返回 0
        while (!Q.isEmpty()) {
            
            Pair<String, Integer> node = Q.remove();
            String word = node.getKey();
            int level = node.getValue();
            
            for (int i = 0; i < strLen; i++) {

                // 对当前从队列去除的单词进行处理
                String newWord = word.substring(0, i) + '*' + word.substring(i + 1, strLen);

                // 与输入模板进行匹配
                for (String adjacentWord : allComboDict.getOrDefault(newWord, new ArrayList<String>())) {
                    
                    // 如果找了 endWord，则直接返回即可
                    if (adjacentWord.equals(endWord)) {
                        return level + 1;
                    }
                    
                    // 如果是新的字符串，则重新加入队列
                    if (!visited.containsKey(adjacentWord)) {
                        visited.put(adjacentWord, true);
                        Q.add(new Pair(adjacentWord, level + 1));
                    }
                }
            }
        }

        return 0;
    }
}
