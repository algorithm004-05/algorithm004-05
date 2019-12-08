func findCircleNum(M [][]int) int {
    //  使用并查集
    u := NewUFS(len(M))
    for i := 0; i < len(M); i++ {
        for j := i+1; j < len(M); j++ {
            if M[i][j] == 0 {
                continue
            }
            u.Union(i, j)
        }
    }
    //  查找朋友圈个数
    m := make(map[int]struct{})
    for i := 0; i < len(M); i++{
        m[u.Find(i)] = struct{}{}
    }
    return len(m)
}

type UFS struct {
	s []int
	sz []int
}

func NewUFS(n int) *UFS {
	s := make([]int, n)
	sz := make([]int, n)
	for i := 0; i < len(s); i++ {
		s[i] = i
		sz[i] = 1
	}
	return &UFS{s: s, sz: sz}
}

func (u *UFS)Find(n int) int {
	if n > len(u.s) || n < 0 {
		return -1
	}
	r, j := u.s[n], n
	for r != j {
		j = r
		r = u.s[j]
	}
	//  压缩路径
	p := 0
	for u.s[n] != n {
		p = u.s[n]
		u.s[n] = r
		n = p
	}
	return r
}

func (u *UFS)Union(i int, j int)  {
	p := u.Find(i)
	q := u.Find(j)
	if p == q {
		return
	}
	if u.sz[p] < u.sz[q] {
		u.s[p] = q
		u.sz[q] += u.sz[p]
	} else {
		u.s[q] = p
		u.sz[p] += u.sz[q]
	}
}
 