/*
  212
  Given a 2D board and a list of words from the dictionary,
  find all words in the board.

  Each word must be constructed from letters of sequentially adjacent cell,
  where "adjacent" cells are those horizontally or vertically neighboring.
  The same letter cell may not be used more than once in a word. 

  Example:
    Input:
      board =
        [
          ['o','a','a','n'],
          ['e','t','a','e'],
          ['i','h','k','r'],
          ['i','f','l','v']
        ]

      words = ["oath","pea","eat","rain"]

    Output: 
      ["eat","oath"]
*/

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WordSearchSecond {

  private Set<String> resultSet = new HashSet<>();

  public List<String> findWords(char[][] board, String[] words) {
    Trie trie = new Trie();
    for (String word : words) {
      trie.insert(word);
    }
    int rows = board.length;
    int columns = board[0].length;
    boolean[][] visited = new boolean[rows][columns];
    for (int row = 0; row < rows; row++) {
      for (int column = 0; column < columns; column++) {
        resultSetHelper(board, visited, trie.root, row, column);
      }
    }
    return new ArrayList<>(resultSet);
  }

  private void resultSetHelper(char[][] board, boolean[][] visited, TrieNode node, int row, int column) {
    if (row < 0 || row >= board.length || column < 0 || column >= board[0].length) {
      return;
    }
    if (visited[row][column]) {
      return;
    }
    TrieNode nodeNext = node.children[board[row][column] - 'a'];
    if (nodeNext == null) {
      return;
    }
    if (nodeNext.word != null) {
      resultSet.add(nodeNext.word);
    }
    visited[row][column] = true;
    resultSetHelper(board, visited, nodeNext, row - 1, column);
    resultSetHelper(board, visited, nodeNext, row + 1, column);
    resultSetHelper(board, visited, nodeNext, row, column - 1);
    resultSetHelper(board, visited, nodeNext, row, column + 1);
    visited[row][column] = false;
  }

  static class Trie {

    TrieNode root = new TrieNode();

    void insert(String word) {
      TrieNode node = root;
      for (int i = 0; i < word.length(); ++i) {
        int charNo = word.charAt(i) - 'a';
        if (node.children[charNo] == null) {
          node.children[charNo] = new TrieNode();
        }
        node = node.children[charNo];
      }
      node.word = word;
    }
  }

  static class TrieNode {
    TrieNode[] children = new TrieNode[26];
    String word = null;
  }
}
