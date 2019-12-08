/*
  208
  Implement a trie with insert, search, and startsWith methods.

  Example:
    Trie trie = new Trie();
    trie.insert("apple");
    trie.search("apple");   // returns true
    trie.search("app");     // returns false
    trie.startsWith("app"); // returns true
    trie.insert("app");
    trie.search("app");     // returns true

  Note:
    You may assume that all inputs are consist of lowercase letters a-z.
    All inputs are guaranteed to be non-empty strings.
*/

public class ImplementTriePrefixTree {

  private static class TrieTreeNode {

    private TrieTreeNode[] links;
    private boolean isEnd;

    TrieTreeNode() {
      int r = 26;
      links = new TrieTreeNode[r];
    }

    boolean containsKey(char ch) {
      return links[ch - 'a'] != null;
    }

    TrieTreeNode get(char ch) {
      return links[ch - 'a'];
    }

    void put(char ch, TrieTreeNode node) {
      links[ch - 'a'] = node;
    }

    void setEnd() {
      isEnd = true;
    }

    boolean isEnd() {
      return isEnd;
    }
  }

  private TrieTreeNode root;

  /**
   * Initialize your data structure here.
   */
  public ImplementTriePrefixTree() {
    root = new TrieTreeNode();
  }

  /**
   * Inserts a word into the trie.
   */
  public void insert(String word) {
    TrieTreeNode node = root;
    for (int i = 0; i < word.length(); i++) {
      char currentChar = word.charAt(i);
      if (!node.containsKey(currentChar)) {
        node.put(currentChar, new TrieTreeNode());
      }
      node = node.get(currentChar);
    }
    node.setEnd();
  }

  private TrieTreeNode searchPrefix(String word) {
    TrieTreeNode node = root;
    for (int i = 0; i < word.length(); i++) {
      char currentChar = word.charAt(i);
      if (node.containsKey(currentChar)) {
        node = node.get(currentChar);
      } else {
        return null;
      }
    }
    return node;
  }

  /**
   * Returns if the word is in the trie.
   */
  public boolean search(String word) {
    TrieTreeNode node = searchPrefix(word);
    return node != null && node.isEnd();
  }

  /**
   * Returns if there is any word in the trie that starts with the given prefix.
   */
  public boolean startsWith(String prefix) {
    TrieTreeNode node = searchPrefix(prefix);
    return node != null;
  }
}
