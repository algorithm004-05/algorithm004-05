//package id_105;
//
//public class TrieNode {
//
//
//    private TrieNode[] links;
//
//    private final int R = 26;
//
//    private boolean isEnd;
//
//    public TrieNode() {
//        this.links = new TrieNode[R];
//    }
//
//    public boolean containsKey(char ch) {
//        return links[ch - 'a'] != null;
//    }
//
//    public TrieNode get(char ch) {
//        return links[ch = 'a'];
//    }
//
//    public void put(char ch, TrieNode node) {
//        links[ch - 'a'] = node;
//    }
//
//    public void setEnd() {
//        isEnd = true;
//    }
//
//    public boolean isEnd() {
//        return isEnd;
//    }
//
//}
