
// Copyright(c) 2019 Mobvoi Inc. All Rights Reserved.

import javafx.util.Pair;

import java.util.*;

/**
 * @Author Shuangshuang Wang, <shshwang@mobvoi.com>
 * @Date 2019/11/2
 */
public class LeetCode_127_430 {

  /**
   * BFS
   */
  class Solution {

    Map<String, List<String>> transformations;
    int n;

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
      if (!wordList.contains(endWord)) {
        return 0;
      }
      init(wordList, beginWord);
      Queue<Pair<String, Integer>> queue1 = new ArrayDeque(n);
      Queue<Pair<String, Integer>> queue2 = new ArrayDeque(n);
      Map<String, Integer> visited = new HashMap<>(n);
      Map<String, Integer> anotherVisited = new HashMap<>(n);
      queue1.add(new Pair<>(beginWord, 1));
      queue2.add(new Pair<>(endWord, 1));
      // queue和visited都要提前加入
      visited.put(beginWord, 1);
      anotherVisited.put(endWord, 1);
      while (!queue1.isEmpty() && !queue2.isEmpty()) {
        int s = visitNode(queue1, visited, anotherVisited);
        if (s != 0) {
          return s;
        }
        int t = visitNode(queue2, anotherVisited, visited);
        if (t != 0) {
          return t;
        }
      }
      return 0;
    }

    private int visitNode(Queue<Pair<String, Integer>> queue, Map<String, Integer> visited,
        Map<String, Integer> anotherVisited) {
      Pair<String, Integer> pair = queue.poll();
      String key = pair.getKey();
      Integer value = pair.getValue();
      // 子级入队
      for (int i = 0; i < n; i++) {
        String newWord = key.substring(0, i) + '*' + key.substring(i + 1);
        List<String> list = transformations.getOrDefault(newWord, new ArrayList());
        for (int j = 0; j < list.size(); j++) {
          String word = list.get(j);
          if (anotherVisited.containsKey(word)) {
            return value + anotherVisited.get(word);
          }
          if (!visited.containsKey(word)) {
            // queue和visited在循环内部及时设值
            queue.offer(new Pair(word, value + 1));
            visited.put(word, value + 1);
          }
        }
      }
      return 0;
    }

    private void init(List<String> wordList, String beginWord) {
      n = beginWord.length();
      transformations = new HashMap(n);
      wordList.forEach(x -> {
        for (int i = 0; i < n; i++) {
          String newWord = x.substring(0, i) + '*' + x.substring(i + 1);
          transformations.putIfAbsent(newWord, new ArrayList<>());
          transformations.get(newWord).add(x);
        }
      });

    }
  }
}
