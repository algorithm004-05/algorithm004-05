<?php
/**
 * 题目名称：implement-trie-prefix-tree 实现 Trie (前缀树)
 * 题目链接：https://leetcode-cn.com/problems/implement-trie-prefix-tree/
 */

class Trie {
    public $links;
    public $isEnd;
    public $word;

    /**
     * Initialize your data structure here.
     */
    function __construct() {
        $this->links = [];
        $this->isEnd = false;
        $this->word = ' ';
    }
  
    /**
     * Inserts a word into the trie.
     * @param String $word
     * @return NULL
     */
    function insert($word) {
        $node = $this;
        $wordArr = str_split($word);
        for ($i = 0; $i < count($wordArr); $i++) {
            $char = $wordArr[$i];
            if ($node->links[$char - 'a'] == null) {
                $node->links[$char - 'a'] = new Trie();
            }
            $node = $node->links[$char - 'a'];
            $node->word = $char;
            if ($i == count($wordArr) - 1) {
                $node->isEnd = true;
            }
        }
    }
  
    /**
     * Returns if the word is in the trie.
     * @param String $word
     * @return Boolean
     */
    function search($word) {
        $node = $this->searchPrefix($word);
        return $node != null && $node->isEnd;
    }
  
    /**
     * Returns if there is any word in the trie that starts with the given prefix.
     * @param String $prefix
     * @return Boolean
     */
    function startsWith($prefix) {
        $node = $this->searchPrefix($prefix);
        return $node != null;
    }

    function searchPrefix($prefix) {
        $node = $this;
        $wordArr = str_split($prefix);
        for ($i = 0; $i < count($wordArr); $i++) {
            $char = $wordArr[$i];
            if ($node->links[$char - 'a'] != null) {
                $node = $node->links[$char - 'a'];
            } else {
                return null;
            }  
        }
        return $node;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * $obj = Trie();
 * $obj->insert($word);
 * $ret_2 = $obj->search($word);
 * $ret_3 = $obj->startsWith($prefix);
 */