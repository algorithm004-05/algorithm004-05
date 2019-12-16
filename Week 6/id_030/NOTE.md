# NOTE

  

# 字典树Trie
字典树，又称为单词查找树，Tire数，是一种树形结构，它是一种哈希树的变种。
# 特点
根节点不包含字符，除根节点外的每一个子节点都包含一个字符
从根节点到某一节点。路径上经过的字符连接起来，就是该节点对应的字符串
每个节点的所有子节点包含的字符都不相同
# 应用场景
典型应用是用于统计，排序和保存大量的字符串(不仅限于字符串)，经常被搜索引擎系统用于文本词频统计。
# 优点
利用字符串的公共前缀来减少查询时间，最大限度的减少无谓的字符串比较，查询效率比哈希树高。
# 二、构建过程
　　1、字典树节点定义

class TrieNode // 字典树节点
    {
        private int num;// 有多少单词通过这个节点,即由根至该节点组成的字符串模式出现的次数
        private TrieNode[] son;// 所有的儿子节点
        private boolean isEnd;// 是不是最后一个节点
        private char val;// 节点的值

        TrieNode()
        {
            num = 1;
            son = new TrieNode[SIZE];
            isEnd = false;
        }
    }

　　2、字典树构造函数
    Trie() // 初始化字典树
    {
        root = new TrieNode();
    }
　　3、建立字典树

// 建立字典树
    public void insert(String str) // 在字典树中插入一个单词
    {
        if (str == null || str.length() == 0)
        {
            return;
        }
        TrieNode node = root;
        char[] letters = str.toCharArray();//将目标单词转换为字符数组
        for (int i = 0, len = str.length(); i < len; i++)
        {
            int pos = letters[i] - 'a';
            if (node.son[pos] == null)  //如果当前节点的儿子节点中没有该字符，则构建一个TrieNode并复值该字符
            {
                node.son[pos] = new TrieNode();
                node.son[pos].val = letters[i];
            } 
            else   //如果已经存在，则将由根至该儿子节点组成的字符串模式出现的次数+1
            {
                node.son[pos].num++;
            }
            node = node.son[pos];
        }
        node.isEnd = true;
    }

　　4、在字典树中查找是否完全匹配一个指定的字符串

    // 在字典树中查找一个完全匹配的单词.
    public boolean has(String str)
    {
        if(str==null||str.length()==0)
        {
            return false;
        }
        TrieNode node=root;
        char[]letters=str.toCharArray();
        for(int i=0,len=str.length(); i<len; i++)
        {
            int pos=letters[i]-'a';
            if(node.son[pos]!=null)
            {
                node=node.son[pos];
            }
            else
            {
                return false;
            }
        }
        //走到这一步，表明可能完全匹配，也可能部分匹配，如果最后一个字符节点为末端节点，则是完全匹配，否则是部分匹配
        return node.isEnd;
    }

　　5、前序遍历字典树
　　// 前序遍历字典树.
    public void preTraverse(TrieNode node)
    {
        if(node!=null)
        {
            System.out.print(node.val+"-");
            for(TrieNode child:node.son)
            {
                preTraverse(child);
            }
        }
    }
　　6、计算单词前缀的数量
　　// 计算单词前缀的数量
    public int countPrefix(String prefix)
    {
        if(prefix==null||prefix.length()==0)
        {
            return-1;
        }
        TrieNode node=root;
        char[]letters=prefix.toCharArray();
        for(int i=0,len=prefix.length(); i<len; i++)
        {
            int pos=letters[i]-'a';
            if(node.son[pos]==null)
            {
                return 0;
            }
            else
            {
                node=node.son[pos];
            }
        }
        return node.num;
    }
    
 # 并查集
 并查集是一种数据结构, 常用于描述集合,经常用于解决此类问题:某个元素是否属于某个集合,或者 某个元素 和 另一个元素是否同属于一个集合
 Java 模板
class UnionFind { 
	private int count = 0; 
	private int[] parent; 
	public UnionFind(int n) { 
		count = n; 
		parent = new int[n]; 
		for (int i = 0; i < n; i++) { 
			parent[i] = i;
		}
	} 
	public int find(int p) { 
		while (p != parent[p]) { 
			parent[p] = parent[parent[p]]; 
			p = parent[p]; 
		}
		return p; 
	}
	public void union(int p, int q) { 
		int rootP = find(p); 
		int rootQ = find(q); 
		if (rootP == rootQ) return; 
		parent[rootP] = rootQ; 
		count--;
	}
}
# 剪枝
优化搜索方式
# AVL和红黑树
avl 自平衡二叉查找树 
特点是查找效率高 增加、删除节点效率低，因为每次增加或者删除节点就要对树本身调整平衡状态
红黑树
特点是增加、删除节点效率以及查找效率都相对优秀的树形结构
性质1. 节点是红色或黑色。
性质2. 根节点是黑色。
性质3. 子节点都是黑色且为空
性质4 每个红色节点的两个子节点都是黑色。(从每个叶子到根的所有路径上不能有两个连续的红色节点)
性质5. 从任一节点到其每个叶子的所有路径都包含相同数目的黑色节点。
