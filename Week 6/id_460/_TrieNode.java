package week6.Question208BuildTrie;

public class TrieNode {
    //字典树的每个节点里都是一个长度为26的数组。
    private TrieNode[] links;
    private final int R = 26;
    private boolean isEnd;
    private String val;

     TrieNode() {
        links = new TrieNode[R];
    }
     boolean containsKey(char ch){
        return links[ch-'a'] != null;
    }
     TrieNode get(char ch){
        return links [ch-'a'];
    }
     void put (char ch, TrieNode node){
        links[ch-'a'] = node;
    }
     void setEnd() {
        isEnd = true;
    }
     public boolean isEnd() {
        return isEnd;
    }

    public TrieNode[] getLinks() {
        return links;
    }

    public String getVal() {
        return val;
    }

    public void setVal(String val) {
        this.val = val;
    }
}
