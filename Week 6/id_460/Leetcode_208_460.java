package week6.Question208BuildTrie;

public class Trie {
    private TrieNode root;
    /**
     * Initialize your data structure here.
     */
    public Trie() {
        root = new TrieNode();
    }

    public TrieNode getRoot() {
        return root;
    }

    /**
     * Inserts a word into the trie.
     */
    public void insert(String word) {
        TrieNode node = root;
        for (int i=0;i<word.length();i++){
            char currentChar = word.charAt(i);
            if (!node.containsKey(currentChar)){
                node.put(currentChar,new TrieNode());
            }
            node = node.get(currentChar);
        }
        node.setEnd();
        node.setVal(word);
    }

    /**
     * Returns if the word is in the trie.
     */
    public TrieNode searchPrefix(String word) {
        TrieNode node = root;
        for (int i = 0; i < word.length(); i++) {
            char curLetter = word.charAt(i);
            if (node.containsKey(curLetter)){
                node = node.get(curLetter);
            }else{
                return null;
            }
        }
        return node;
    }

    public boolean search(String word){
        TrieNode node = searchPrefix(word);
        return node != null && node.isEnd();
    }

    /**
     * Returns if there is any word in the trie that starts with the given prefix.
     */
    public boolean startsWith(String prefix) {
        TrieNode node = searchPrefix(prefix);
        return node != null;
    }

    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.insert("word");
        boolean param_2 = trie.search("apple");
        boolean param_3 = trie.startsWith("a");
    }
}
