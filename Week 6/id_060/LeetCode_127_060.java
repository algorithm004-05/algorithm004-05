/*
  127
  Given two words (beginWord and endWord), and a dictionary's word list,
  find the length of shortest transformation sequence
  from beginWord to endWord, such that:

  Only one letter can be changed at a time.

  Each transformed word must exist in the word list. Note that beginWord is not a transformed word.

  Note:
    Return 0 if there is no such transformation sequence.
    All words have the same length.
    All words contain only lowercase alphabetic characters.
    You may assume no duplicates in the word list.
    You may assume beginWord and endWord are non-empty and are not the same.

  Example 1:
    Input:
    beginWord = "hit",
    endWord = "cog",
    wordList = ["hot","dot","dog","lot","log","cog"]

    Output: 5

  Explanation:
    As one shortest transformation is "hit" -> "hot" -> "dot" -> "dog" -> "cog",
    return its length 5.

  Example 2:
    Input:
    beginWord = "hit"
    endWord = "cog"
    wordList = ["hot","dot","dog","lot","log"]

    Output: 0

  Explanation: 
    The endWord "cog" is not in wordList, therefore no possible transformation.
*/

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WordLadderFirst {

  // BFS
  public int ladderLength0(String beginWord, String endWord, List<String> wordList) {
    Set<String> words = new HashSet<>(wordList);

    Deque<String> queue = new ArrayDeque<>();
    queue.addLast(beginWord);

    int result = 0;

    while (!queue.isEmpty()) {
      int size = queue.size();

      while (size-- > 0) {
        String currentString = queue.removeFirst();
        if (currentString.equals(endWord)) {
          return ++result;
        }

        for (int i = 0; i < currentString.length(); i++) {
          char[] currentStringChar = currentString.toCharArray();
          char oldChar = currentStringChar[i];

          for (char c = 'a'; c <= 'z'; c++) {
            currentStringChar[i] = c;
            String tempString = String.valueOf(currentStringChar);

            if (!words.contains(tempString)) {
              continue;
            }

            queue.addLast(tempString);
            words.remove(tempString);
          }

          currentStringChar[i] = oldChar;
        }
      }

      result++;
    }

    return 0;
  }

  // ANOTHER BFS
  public int ladderLength1(String beginWord, String endWord, List<String> wordList) {
    Deque<String> queue = new ArrayDeque<>();
    Set<String> visited = new HashSet<>();
    queue.addLast(beginWord);
    visited.add(beginWord);
    int result = 0;
    while (!queue.isEmpty()) {
      int size = queue.size();
      while (size-- > 0) {
        String currentString = queue.removeFirst();

        for (String string : wordList) {
          if (visited.contains(string)) {
            continue;
          }
          if (!convertible(currentString, string)) {
            continue;
          }
          if (string.equals(endWord)) {
            return ++result;
          }
          queue.addLast(string);
          visited.add(string);
        }
      }

      result++;
    }

    return 0;
  }

  private boolean convertible(String currentString, String string) {
    char[] p = currentString.toCharArray();
    char[] q = string.toCharArray();
    int count = 0;
    for (int i = 0; i < p.length; i++) {
      if (p[i] != q[i]) {
        count++;
      }
    }
    return count == 1;
  }

  // DOUBLE BFS
  public int ladderLength2(String beginWord, String endWord, List<String> wordList) {
    Set<String> words = new HashSet<>(wordList);
    if (!words.contains(endWord)) {
      return 0;
    }

    Set<String> beginSet = new HashSet<>();
    Set<String> endSet = new HashSet<>();
    Set<String> visited = new HashSet<>();
    int length = 1;
    beginSet.add(beginWord);
    endSet.add(endWord);

    while (!beginSet.isEmpty() && !endSet.isEmpty()) {

      if (beginSet.size() > endSet.size()) {
        Set<String> temp = beginSet;
        beginSet = endSet;
        endSet = temp;
      }

      Set<String> temp = new HashSet<>();

      for (String word : beginSet) {
        char[] wordChar = word.toCharArray();

        for (int i = 0; i < wordChar.length; i++) {
          char old = wordChar[i];

          for (char c = 'a'; c < 'z'; c++) {
            wordChar[i] = c;
            String target = String.valueOf(wordChar);

            if (endSet.contains(target)) {
              return ++length;
            }

            if (visited.contains(target) || !words.contains(target)) {
              continue;
            }

            temp.add(target);
            visited.add(target);
          }

          wordChar[i] = old;
        }
      }

      beginSet = temp;
      length++;
    }

    return 0;
  }
}
