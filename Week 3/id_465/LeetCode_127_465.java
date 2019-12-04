package leetcode.jacf.tech;

import javafx.util.Pair;

import java.util.HashMap;
import java.util.List;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 127. 单词接龙
 * https://leetcode-cn.com/problems/word-ladder/
 *
 * @author jacf
 */
public class WordLadder {
    public static class Solution {
        public int ladderLength(String beginWord, String endWord, List<String> wordList) {
            // common length of each word
            int wordLength = beginWord.length();

            HashMap<String, LinkedList<String>> wordFormats = this.formatWordList(wordLength, wordList);

            // BFS
            // string -> word, integer -> level
            Queue<Pair<String, Integer>> wordQueue = new LinkedList<Pair<String, Integer>>();
            wordQueue.offer(new Pair<>(beginWord, 1));

            HashMap<String, Boolean> visited = new HashMap<>(wordList.size());
            visited.put(beginWord, true);

            while (!wordQueue.isEmpty()) {
                Pair<String, Integer> node = wordQueue.remove();
                String word = node.getKey();
                Integer level = node.getValue();

                for (int i = 0; i < wordLength; ++i) {
                    String format = word.substring(0, i) + "*" + word.substring(i + 1, wordLength);
                    for (String key : wordFormats.getOrDefault(format, new LinkedList<>())
                    ) {
                        if (key.equals(endWord)) {
                            return level + 1;
                        }
                        if (!visited.containsKey(key)) {
                            visited.put(key, true);
                            wordQueue.offer(new Pair<>(key, level + 1));
                        }
                    }
                }
            }
            return 0;
        }

        /**
         * transform wordlist to a hashmap
         * the key of hashmap is a word format, e.g. hit -> '*it', 'h*t', 'hi*'
         * the key will be '*it', 'h*t', 'hi*'
         * the value is the words with same format
         *
         * @param wordLength the length of each word in wordList
         * @param wordList   the word list
         * @return a hashmap
         */
        public HashMap<String, LinkedList<String>> formatWordList(int wordLength, List<String> wordList) {
            HashMap<String, LinkedList<String>> result = new HashMap<>(wordList.size() * wordLength);

            for (String word : wordList) {
                for (int i = 0; i < wordLength; ++i) {
                    String format = word.substring(0, i) + "*" + word.substring(i + 1, wordLength);
                    LinkedList<String> wordsWithSameFormat = result.getOrDefault(format, new LinkedList<>());
                    wordsWithSameFormat.addLast(word);
                    result.put(format, wordsWithSameFormat);
                }
            }

            return result;
        }
    }
}
