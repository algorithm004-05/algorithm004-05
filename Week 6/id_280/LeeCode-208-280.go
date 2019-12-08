type Trie struct {
  val  byte
  sons [26]*Trie
  end int
}

/** Initialize your data structure here. */
func Constructor() Trie {
    var t Trie
    return t
}

/** Inserts a word into the trie. */
func (this *Trie) Insert(word string)  {
    roott:=this
    for i:=0;i<len(word);i++{
        if roott.sons[int(word[i])-int('a')]==nil{
            var zz Trie
            zz.val=word[i]
            roott.sons[int(word[i])-int('a')]=&zz
        }else{
        }
        roott=roott.sons[int(word[i])-int('a')]
        if i==len(word)-1{
            (roott.end)++
        }
    }
}

/** Returns if the word is in the trie. */
func (this *Trie) Search(word string) bool {
    roott:=this
    for i:=0;i<len(word);i++{
        if roott.sons[int(word[i])-int('a')]==nil{
            return false
        }
        roott=roott.sons[int(word[i])-int('a')]
        if i==len(word)-1&&roott.end<=0{
            return false
        }
    }
    return true
}

/** Returns if there is any word in the trie that starts with the given prefix. */
func (this *Trie) StartsWith(prefix string) bool {
    roott:=this
    for i:=0;i<len(prefix);i++{
        if roott.sons[int(prefix[i])-int('a')]==nil{
            return false
        }
        roott=roott.sons[int(prefix[i])-int('a')]
    }
    return true
}