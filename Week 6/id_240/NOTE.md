### 字典树

1. 节点本身不存在完整单词
2. 从根节点到某一结点，路径上经过的字符连接起来，为该节点对应的字符串
3. 每个节点的所有子节点路径代表的字符都不相同
4. 字典树典型应用情景就是搜索提示词
5. javascript实现字典树

~~~javascript
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
~~~

  

