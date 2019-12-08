package leetcode.jacf.tech;

import javafx.util.Pair;

import java.util.*;
import java.util.LinkedList;

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

    public static class SolutionUsingDaulBFS {

        private int L;
        private HashMap<String, ArrayList<String>> allComboDict;

        SolutionUsingDaulBFS() {
            this.L = 0;

            this.allComboDict = new HashMap<String, ArrayList<String>>();
        }

        private int visitWordNode(Queue<Pair<String, Integer>> Q,
                                  HashMap<String, Integer> visited,
                                  HashMap<String, Integer> othersVisited) {
            Pair<String, Integer> node = Q.remove();
            String word = node.getKey();
            int level = node.getValue();

            for (int i = 0; i < this.L; i++) {

                String newWord = word.substring(0, i) + '*' + word.substring(i + 1, L);

                for (String adjacentWord : this.allComboDict.getOrDefault(newWord, new ArrayList<String>())) {
                    if (othersVisited.containsKey(adjacentWord)) {
                        return level + othersVisited.get(adjacentWord);
                    }

                    if (!visited.containsKey(adjacentWord)) {

                        visited.put(adjacentWord, level + 1);
                        Q.add(new Pair(adjacentWord, level + 1));
                    }
                }
            }
            return -1;
        }

        public int ladderLength(String beginWord, String endWord, List<String> wordList) {

            if (!wordList.contains(endWord)) {
                return 0;
            }

            this.L = beginWord.length();

            wordList.forEach(
                    word -> {
                        for (int i = 0; i < L; i++) {
                            String newWord = word.substring(0, i) + '*' + word.substring(i + 1, L);
                            ArrayList<String> transformations =
                                    this.allComboDict.getOrDefault(newWord, new ArrayList<String>());
                            transformations.add(word);
                            this.allComboDict.put(newWord, transformations);
                        }
                    });

            Queue<Pair<String, Integer>> Q_begin = new LinkedList<Pair<String, Integer>>();

            Queue<Pair<String, Integer>> Q_end = new LinkedList<Pair<String, Integer>>();
            Q_begin.add(new Pair(beginWord, 1));
            Q_end.add(new Pair(endWord, 1));

            HashMap<String, Integer> visitedBegin = new HashMap<String, Integer>();
            HashMap<String, Integer> visitedEnd = new HashMap<String, Integer>();
            visitedBegin.put(beginWord, 1);
            visitedEnd.put(endWord, 1);

            while (!Q_begin.isEmpty() && !Q_end.isEmpty()) {


                int ans = visitWordNode(Q_begin, visitedBegin, visitedEnd);
                if (ans > -1) {
                    return ans;
                }


                ans = visitWordNode(Q_end, visitedEnd, visitedBegin);
                if (ans > -1) {
                    return ans;
                }
            }

            return 0;
        }
    }

}
