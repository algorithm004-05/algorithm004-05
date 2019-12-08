class Trie {

    private class Node {
        Node[] next = new Node[26];
        boolean isLeaf;
    }
    
    private final Node dict;
    
    /** Initialize your data structure here. */
    public Trie() {
        this.dict = new Node();
    }
    
    /** Inserts a word into the trie. */
    public void insert(String word) {
        Node node = dict;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            int pos = c - 'a';
            node = set(node, pos, i == word.length() - 1);
        }
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        return search2(word, true);
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        return search2(prefix, false);
    }
    
    private boolean search2(String word, boolean wholeWord) {
        Node node = dict;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            int pos = c - 'a';
            node = node.next[pos];
            if (node == null) {
                return false;
            } else {
                if (i == word.length() - 1 && !node.isLeaf) {
                    return !wholeWord;
                }
            }
        }
        return true;
    }
    
    private Node set(Node node, int pos, boolean isLeaf) {
        Node newNode;
        if (node.next[pos] == null) {
            newNode = new Node();
            node.next[pos] = newNode;
        } else {
            newNode = node.next[pos];
        }
        if (isLeaf) {
            newNode.isLeaf = true;
        }
        return newNode;
    }

}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
