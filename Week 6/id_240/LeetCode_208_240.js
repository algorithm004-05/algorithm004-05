/**
 * Initialize your data structure here.
 */
var Trie = function() {
    this.nextLetter = {};
    this.isWord = false;
};

/**
 * Inserts a word into the trie. 
 * @param {string} word
 * @return {void}
 */
Trie.prototype.insert = function(word) {
    let cur = this;
    let arr = word.split('');
    for(let i = 0,len = arr.length;i<len;i++){
        if(!cur.nextLetter.hasOwnProperty(arr[i])){
            cur.nextLetter[arr[i]] = new Trie();
            cur = cur.nextLetter[arr[i]];
        }else{
            cur = cur.nextLetter[arr[i]];
        }
    }
    cur.isWord = true;
};

/**
 * Returns if the word is in the trie. 
 * @param {string} word
 * @return {boolean}
 */
Trie.prototype.search = function(word) {
    let cur = this;
    let arr = word.split('');
    for(let i = 0,len = arr.length;i<len;i++){
        if(cur.nextLetter.hasOwnProperty(arr[i])){
            cur = cur.nextLetter[arr[i]];
        }else{
            return false;
        }
    }
    return cur.isWord;
};

/**
 * Returns if there is any word in the trie that starts with the given prefix. 
 * @param {string} prefix
 * @return {boolean}
 */
Trie.prototype.startsWith = function(prefix) {
    let cur = this;
    let arr = prefix.split('');
    for(let i = 0,len = arr.length;i<len;i++){
        if(cur.nextLetter.hasOwnProperty(arr[i])){
            cur = cur.nextLetter[arr[i]];
        }else{
            return false;
        }
    }
    return true;
};