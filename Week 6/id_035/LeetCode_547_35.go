package day21

import "fmt"

//班上有 N 名学生。其中有些人是朋友，有些则不是。他们的友谊具有是传递性。如果已知 A 是 B 的朋友，B 是 C 的朋友，那么我们可以认为 A 也是 C 的朋友。所谓的朋友圈，是指所有朋友的集合。
//
// 给定一个 N * N 的矩阵 M，表示班级中学生之间的朋友关系。如果M[i][j] = 1，表示已知第 i 个和 j 个学生互为朋友关系，否则为不知道。你必须输出所有学生中的已知的朋友圈总数。
//
// 示例 1:
//
//
//输入:
//[[1,1,0],
// [1,1,0],
// [0,0,1]]
//输出: 2
//说明：已知学生0和学生1互为朋友，他们在一个朋友圈。
//第2个学生自己在一个朋友圈。所以返回2。
//
//
// 示例 2:
//
//
//输入:
//[[1,1,0],
// [1,1,1],
// [0,1,1]]
//输出: 1
//说明：已知学生0和学生1互为朋友，学生1和学生2互为朋友，所以学生0和学生2也是朋友，所以他们三个在一个朋友圈，返回1。
//
//
// 注意：
//
//
// N 在[1,200]的范围内。
// 对于所有学生，有M[i][i] = 1。
// 如果有M[i][j] = 1，则有M[j][i] = 1。
//
// Related Topics 深度优先搜索 并查集

type AndCheck struct {
	Parent []int // 每个并查集元素都有一个parent数组指向它自己
	Rank   []int // 维护每个元素在并查集树中的排名
}

// 初始化
func (this *AndCheck) Init(n int) {
	this.Parent = make([]int, n)
	this.Rank = make([]int, n)
	for i := 0; i < n; i++ {
		this.Parent[i] = i
		this.Rank[i] = 1
	}
}

// 查询find的根节点
/*
	不断查找ele的parent,直到parent[ele] = ele
*/
func (this *AndCheck) Find(ele int) int {
	return this.find(ele)
}
func (this *AndCheck) find(ele int) int {
	for ele != this.Parent[ele] {
		this.Parent[ele] = this.Parent[this.Parent[ele]]
		ele = this.Parent[ele]
	}
	return ele
}

// 合并
// 首先分别找到p, q的领头节点、如果相同则直接返回
// 否则将基本一个的parent置为另一个
// 最后将并查集中独立集合数量减1
func (this *AndCheck) Union(p, q int) {
	pRoot := this.find(p)
	qRoot := this.find(q)
	if pRoot == qRoot {
		return
	}
	if this.Rank[pRoot] > this.Rank[qRoot] {
		this.Parent[qRoot] = pRoot
	} else if this.Rank[pRoot] < this.Rank[qRoot] {
		this.Parent[pRoot] = qRoot
	} else {
		this.Parent[pRoot] = qRoot
		this.Rank[qRoot]++
	}
}

//leetcode submit region begin(Prohibit modification and deletion)
/*
	思路1:并查集
	有N个朋友、将每个朋友当成一个独立的集合
	然后遍历好友矩阵、对于M[i][j] = 1的i和j的集合进行合并
	最后查看有多少个独立的不重复的集合、就是对应的朋友圈数量
	首先需要实现一个并查集
*/
func findCircleNum(M [][]int) int {
	m := len(M)
	n := len(M[0])
	ac := &AndCheck{}
	ac.Init(n)
	for i := 0; i < m; i++ {
		for j := 0; j < n; j++ {
			if M[i][j] == 1 {
				ac.Union(i, j)
			}
		}
	}
	fmt.Println("ac parent:", ac.Parent)
	m_nodes := make(map[int]bool)
	// 遍历所有朋友、查看此时并查集中有多少个不同的独立集合
	for i := 0; i < n; i++ {
		m_nodes[ac.Find(i)] = true
	}
	return len(m_nodes)
}

//leetcode submit region end(Prohibit modification and deletion)
func main() {
	//data := [][]int{
	//	// 1, 2, 3, 4
	//	{1, 0, 0, 1},
	//	{0, 1, 1, 0},
	//	{0, 1, 1, 1},
	//	{1, 0, 1, 1}}
	//data := [][]int{
	//	{1, 1, 0},
	//	{1, 1, 0},
	//	{0, 0, 1},
	//}
	/*
		//11000
		//11000
		//00100
		//00011
		//
	*/
	data := [][]byte{
		{1, 1, 0, 0, 0},
		{1, 1, 0, 0, 0},
		{0, 0, 1, 0, 0},
		{0, 0, 0, 1, 1},
	}
	fmt.Println(NumIslands(data))
}
