//实现一个 Trie (前缀树)，包含 insert, search, 和 startsWith 这三个操作。 
//
// 示例: 
//
// Trie trie = new Trie();
//
//trie.insert("apple");
//trie.search("apple");   // 返回 true
//trie.search("app");     // 返回 false
//trie.startsWith("app"); // 返回 true
//trie.insert("app");   
//trie.search("app");     // 返回 true 
//
// 说明: 
//
// 
// 你可以假设所有的输入都是由小写字母 a-z 构成的。 
// 保证所有输入均为非空字符串。 
// 
// Related Topics 设计 字典树

class Trie {

    TrieNode root;//记录前缀树的根
    public Trie() {
        root = new TrieNode();
    }

    public void insert(String word) {
        TrieNode ptr = root;//从根出发
        for(int i = 0;i < word.length();i++){
            char c = word.charAt(i);
            if(ptr.child[c - 'a'] == null){//如果c - 'a'为空，说明还没有存入
                ptr.child[c - 'a'] = new TrieNode();//存入节点
            }
            ptr = ptr.child[c - 'a'];//指向当前节点
        }
        ptr.is_end = true;//最后的节点为单词的最后一个单词，is_end设置为true
    }

    public boolean search(String word) {
        TrieNode ptr = root;//从根出发
        for(int i = 0;i < word.length();i++){
            char c = word.charAt(i);
            if(ptr.child[c - 'a'] == null){//如果不存在于前缀树中，返回false
                return false;
            }
            ptr = ptr.child[c - 'a'];
        }
        return ptr.is_end;//如果所有字符都在前缀树中，那么判断最后一个字母结束标志是否为true，
        // 为true，返回true，说明单词找到，否则，false，没找到
    }

    public boolean startsWith(String prefix) {
        TrieNode ptr = root;//从根出发
        for(int i = 0;i < prefix.length();i++){
            char c = prefix.charAt(i);
            if(ptr.child[c - 'a'] == null){//如果不存在于前缀树中，返回false
                return false;
            }
            ptr = ptr.child[c - 'a'];
        }
        return true;
    }
}

