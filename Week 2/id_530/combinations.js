// 77. Combinations
// 给定两个整数n和k，返回1 ... n中k个数字的所有可能组合。
const combine = (n, k) => {
    if (k == 0) {
        return []
    }

    if (k == 1) {
        const ret = []
        for (let i = 1; i <= n; i++) {
            ret.push([i])
        }
        return ret
    }

    const sub = combine(n, k - 1);
    const res = [];
    for (const s of sub) {
        for (let i = s[s.length - 1]; i <= n; i++) {
            if (s.indexOf(i) === -1) {
                res.push([...s, i])
            }
        }
    }
    return res
};