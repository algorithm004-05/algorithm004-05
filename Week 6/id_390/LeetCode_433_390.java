//一条基因序列由一个带有8个字符的字符串表示，其中每个字符都属于 "A", "C", "G", "T"中的任意一个。 
//
// 假设我们要调查一个基因序列的变化。一次基因变化意味着这个基因序列中的一个字符发生了变化。 
//
// 例如，基因序列由"AACCGGTT" 变化至 "AACCGGTA" 即发生了一次基因变化。 
//
// 与此同时，每一次基因变化的结果，都需要是一个合法的基因串，即该结果属于一个基因库。 
//
// 现在给定3个参数 — start, end, bank，分别代表起始基因序列，目标基因序列及基因库，请找出能够使起始基因序列变化为目标基因序列所需的最少变化次数。如果无法实现目标变化，请返回 -1。 
//
// 注意: 
//
// 
// 起始基因序列默认是合法的，但是它并不一定会出现在基因库中。 
// 所有的目标基因序列必须是合法的。 
// 假定起始基因序列与目标基因序列是不一样的。 
// 
//
// 示例 1: 
//
// 
//start: "AACCGGTT"
//end:   "AACCGGTA"
//bank: ["AACCGGTA"]
//
//返回值: 1
// 
//
// 示例 2: 
//
// 
//start: "AACCGGTT"
//end:   "AAACGGTA"
//bank: ["AACCGGTA", "AACCGCTA", "AAACGGTA"]
//
//返回值: 2
// 
//
// 示例 3: 
//
// 
//start: "AAAAACCC"
//end:   "AACCCCCC"
//bank: ["AAAACCCC", "AAACCCCC", "AACCCCCC"]
//
//返回值: 3
// 
//



//leetcode submit region begin(Prohibit modification and deletion)
// 2. 双向广度优先搜索
class Solution {
    public int minMutation(String start, String end, String[] bank) {
        Set<String> set = new HashSet<String>(Arrays.asList(bank));
        if (!set.contains(end)) {
            return -1;
        }
        char[] chars = new char[]{'A', 'C', 'G', 'T'};
        Set<String> p = new HashSet<String>();
        p.add(start);
        Set<String> n = new HashSet<String>();
        n.add(end);
        Set<String> t = new HashSet<String>();
        int count = 0;
        while (p.size() > 0 && n.size() > 0) {
            count++;
            if (p.size() > n.size()) {
                Set<String> temp = new HashSet<String>();
                temp = p;
                p = n;
                n = temp;
            }
            for (String item : p) {
                char[] gen = item.toCharArray();
                for (int i = 0; i < gen.length; i++) {
                    char oldChar = gen[i];
                    for (int j = 0; j < 4; j++) {
                        gen[i] = chars[j];
                        String str = new String(gen);
                        if (n.contains(str)) {
                            return count;
                        } else if (set.contains(str)) {
                            t.add(str);
                            set.remove(str);
                        }
                    }
                    gen[i] = oldChar;
                }
            }
            p = new HashSet<String>(t);
            t.clear();
        }
        return -1;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
