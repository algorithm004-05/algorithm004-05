import javafx.util.Pair;

import java.util.*;

/**
 * created by lchen on 2019/11/2
 */
public class LeetCode_127_535 {

    public static void main(String[] args) {

        Solution21 solution21 = new Solution21();
        System.out.println(solution21.ladderLength("hit", "cog", Arrays.asList("hot", "dot", "dog", "lot", "log", "cog")));
    }

}
class Solution21 {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {

        int L = beginWord.length();

        Map<String, ArrayList<String>> maps = new HashMap<>();

        for (String word : wordList) {
            for (int i = 0; i < L; i++) {
                String newWord = word.substring(0, i) + '*' + word.substring(i + 1, L);
                ArrayList<String> transformations =
                        maps.getOrDefault(newWord, new ArrayList<>());
                transformations.add(word);
                maps.put(newWord, transformations);
            }
        }

        Queue<Pair<String, Integer>> Q = new LinkedList<>();
        Q.add(new Pair(beginWord, 1));

        HashMap<String, Boolean> visited = new HashMap<>();
        visited.put(beginWord, true);

        while (!Q.isEmpty()) {
            Pair<String, Integer> node = Q.remove();
            String word = node.getKey();
            int level = node.getValue();
            for (int i = 0; i < L; i++) {
                String newWord = word.substring(0, i) + '*' + word.substring(i + 1, L);
                for (String adjacentWord : maps.getOrDefault(newWord, new ArrayList<>())) {
                    if (adjacentWord.equals(endWord)) {
                        return level + 1;
                    }
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
