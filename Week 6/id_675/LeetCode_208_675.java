//给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。 
//
// 你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。 
//
// 示例: 
//
// 给定 nums = [2, 7, 11, 15], target = 9
//
//因为 nums[0] + nums[1] = 2 + 7 = 9
//所以返回 [0, 1]
// 
// Related Topics 数组 哈希表


import java.util.HashMap;
import java.util.Map;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    private TrieNode root = new TrieNode('/');

    public void insert(char[] text){
        TrieNode p = root;
        for(int i = 0;i<text.length;++i){
            int index = text[i] - 'a';
            if (p.children == null){
                TrieNode trieNode = new TrieNode(text[i]);
                p.children[index] = trieNode;
            }
            p = p.children[index];
        }
        p.isEndingChar = true;
    }

    public boolean search(char[] pattern){
        TrieNode p = root;
        for (int i = 0;i<pattern.length;++i){
            int index = pattern[i] - 'a';
            if (p.children == null){
                return false;
            }
            if (p.children[index] == null ){
                return false;
            }
            p = p.children[index];

            if (p.isEndingChar == false) return  false;
            else  return true;
        }

        return false;
    }
}

class TrieNode {
    public char data;
    public TrieNode[] children = new TrieNode[26];
    public boolean isEndingChar = false;

    TrieNode(char value){
        this.data = value;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
