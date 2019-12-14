/**
 * @param {character[][]} board
 * @param {string[]} words
 * @return {string[]}
 */
var findWords = function(board, words) {
    class TrieNode{
        constructor(){
            this.END = false;
            this.children = {};
        }
    }
    let root = null;
    let Trie = function() {
        root  = new TrieNode();
    };
    Trie.prototype.insert = function(word) {
        let currNode = root;
        for(let i = 0;i < word.length;i++){
            if(currNode.children[word[i]] == undefined){
                currNode.children[word[i]] = new TrieNode();
            }
            currNode = currNode.children[word[i]];
        }
        currNode.END = true;
    };
    let m = board.length;
    let n = board[0].length;

