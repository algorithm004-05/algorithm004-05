/*
 * @lc app=leetcode.cn id=208 lang=cpp
 *
 * [208] 实现 Trie (前缀树)
 */
#include <string>
// #include <stdlib.h>
#include <vector>
#include <cstring>
#include <iostream>
using namespace std;
// @lc code=start
const int MAXN=26;
class Trie {
    bool is_str;
    Trie *next[MAXN];

public:
    /** Initialize your data structure here. */
    Trie() {
    is_str=NULL;
    memset(next,0,sizeof(next));
    }
    
    /** Inserts a word into the trie. */
    void insert(string word) {
        Trie *cur=this;
        for(char w:word){
            if(cur->next[w-'a']==NULL){
                Trie *newNode=new Trie();
                cur->next[w-'a']=newNode;
            }
            cur=cur->next[w-'a'];
        }
        cur->is_str=true;
    }
    
    /** Returns if the word is in the trie. */
    bool search(string word) {
        Trie *cur=this;
        for(char w:word){
            if(cur!=NULL)
            cur=cur->next[w-'a'];
        }
        return (cur!=NULL && cur->is_str);
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    bool startsWith(string prefix) {
        Trie *cur=this;
        for(char w:prefix){
            if(cur!=NULL) cur=cur->next[w-'a'];
        }
        return (cur!=NULL);
    }
};

/**
 * Your Trie object will be instantiated and called as such:
 * Trie* obj = new Trie();
 * obj->insert(word);
 * bool param_2 = obj->search(word);
 * bool param_3 = obj->startsWith(prefix);
 */
// @lc code=end
int main(){
    Trie *t=new Trie();
t->insert("apple");
t->search("apple");
}
