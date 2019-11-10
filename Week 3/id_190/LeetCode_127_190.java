public class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {

        final int L = beginWord.length();

        //把每个单词改变一个字母后所得的单词保存起来
        HashMap<String, ArrayList<String>> dict = new HashMap<>();

        for (String word : wordList) {
            for (int i = 0; i < L; i++) {
                //key为模板:do*
                //value为所有可能: dot,dog
                String newWord = word.substring(0, i) + '*' + word.substring(i + 1, L);
                ArrayList<String> list =
                        dict.getOrDefault(newWord, new ArrayList<>());
                list.add(word);
                dict.put(newWord, list);
            }
        }

        //广度优先遍历 通过队列来完成
        Queue<Pair<String, Integer>> queue = new LinkedList<>();
        queue.add(new Pair<>(beginWord, 1));

        //保存已经访问过的节点
        HashMap<String, Boolean> visited = new HashMap<>();
        visited.put(beginWord, true);

        //广度优先遍历
        while (!queue.isEmpty()) {
            Pair<String, Integer> node = queue.remove();
            String key = node.getKey();
            int level = node.getValue();
            for (int i = 0; i < L; i++) {
                String newWord = key.substring(0, i) + '*' + key.substring(i + 1, L);
                for (String word : dict.getOrDefault(newWord, new ArrayList<>())) {
                    //找到 直接返回
                    if (word.equals(endWord)) {
                        return level + 1;
                    }
                    //未找到
                    if (!visited.containsKey(word)) {
                        visited.put(word, true);
                        queue.add(new Pair<>(word, level + 1));
                    }
                }
            }
        }
        return 0;
    }
}