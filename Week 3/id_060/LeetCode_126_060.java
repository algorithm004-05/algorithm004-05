/*
  126
  Given two words (beginWord and endWord), and a dictionary's word list,
  find all shortest transformation sequence(s) from beginWord to endWord, such that:

  Only one letter can be changed at a time
  Each transformed word must exist in the word list.
  Note that beginWord is not a transformed word.

  Note:
    Return an empty list if there is no such transformation sequence.
    All words have the same length.
    All words contain only lowercase alphabetic characters.
    You may assume no duplicates in the word list.
    You may assume beginWord and endWord are non-empty and are not the same.

  Example 1:
    Input:
    beginWord = "hit",
    endWord = "cog",
    wordList = ["hot","dot","dog","lot","log","cog"]

    Output:
    [
      ["hit","hot","dot","dog","cog"],
      ["hit","hot","lot","log","cog"]
    ]

  Example 2:
    Input:
    beginWord = "hit"
    endWord = "cog"
    wordList = ["hot","dot","dog","lot","log"]

    Output: []

    Explanation: The endWord "cog" is not in wordList, therefore no possible transformation.
*/

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class WordLadderSecond {

  public List<List<String>> findLadders(String start, String end, List<String> wordList) {
    Set<String> words = new HashSet<>(wordList);
    Map<String, List<String>> nodeNeighbors = new HashMap<>();
    Map<String, Integer> distance = new HashMap<>();

    List<String> solution = new ArrayList<>();
    List<List<String>> result = new ArrayList<>();

    words.add(start);
    BFS(start, end, words, nodeNeighbors, distance);
    DFS(start, end, words, nodeNeighbors, distance, solution, result);

    return result;
  }

  private void BFS(String start, String end, Set<String> words, Map<String, List<String>> nodeNeighbors, Map<String, Integer> distance) {
    for (String node : words) {
      nodeNeighbors.put(node, new ArrayList<>());
    }

    Deque<String> queue = new ArrayDeque<>();
    queue.addLast(start);

    distance.put(start, 0);
    boolean found = false;

    while (!queue.isEmpty()) {
      int size = queue.size();

      while (size-- > 0) {
        String currentNode = queue.removeFirst();
        int currentDistance = distance.get(currentNode);
        List<String> neighborsOfCurrentNode = getNeighbors(currentNode, words);

        for (String neighbor : neighborsOfCurrentNode) {
          nodeNeighbors.get(currentNode).add(neighbor);

          if (!distance.containsKey(neighbor)) {
            distance.put(neighbor, currentDistance + 1);
            if (end.equals(neighbor)) {
              found = true;
            } else {
              queue.addLast(neighbor);
            }
          }
        }

        if (found) {
          break;
        }
      }

    }
  }

  private List<String> getNeighbors(String currentNode, Set<String> words) {
    List<String> neighbors = new ArrayList<>();
    char[] wordChar = currentNode.toCharArray();

    for (int i = 0; i < wordChar.length; i++) {
      for (char c = 'a'; c < 'z'; c++) {
        char old = wordChar[i];
        wordChar[i] = c;
        if (words.contains(String.valueOf(wordChar)) && !currentNode.equals(String.valueOf(wordChar))) {
          neighbors.add(String.valueOf(wordChar));
        }
        wordChar[i] = old;
      }
    }
    return neighbors;
  }

  private void DFS(String start, String end, Set<String> words, Map<String, List<String>> nodeNeighbors, Map<String, Integer> distance, List<String> solution, List<List<String>> result) {
    solution.add(start);

    if (start.equals(end)) {
      result.add(new ArrayList<>(solution));
    } else {
      for (String nextNode : nodeNeighbors.get(start)) {
        if (distance.get(start) + 1 == distance.get(nextNode)) {
          DFS(nextNode, end, words, nodeNeighbors, distance, solution, result);
        }
      }
    }

    solution.remove(solution.size() - 1);
  }
}
