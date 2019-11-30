package main

func main() {

}

const MAXCAP = 26

type Trie struct {
	next   map[rune]*Trie
	isWord bool
}

/** Initialize your data structure here. */
func Constructor() Trie {
	root := new(Trie)
	root.next = make(map[rune]*Trie, MAXCAP)
	root.isWord = false
	return *root
}

/** Inserts a word into the trie. */
func (this *Trie) Insert(word string) {
	for _, v := range word {
		if this.next[v] == nil {
			node := new(Trie)
			node.next = make(map[rune]*Trie, MAXCAP)
			this.next[v] = node
		}

		this = this.next[v]
	}

	this.isWord = true
}

/** Returns if the word is in the trie. */
func (this *Trie) Search(word string) bool {
	for _, v := range word {
		if this.next[v] == nil {
			return false
		}
		this = this.next[v]
	}

	return this.isWord
}

/** Returns if there is any word in the trie that starts with the given prefix. */
func (this *Trie) StartsWith(prefix string) bool {
	for _, v := range prefix {
		if this.next[v] == nil {
			return false
		}
		this = this.next[v]
	}

	return true
}
