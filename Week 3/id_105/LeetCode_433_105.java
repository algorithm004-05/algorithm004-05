package id_105;

import java.util.*;

/**
 * 一条基因序列由一个带有8个字符的字符串表示，其中每个字符都属于 "A", "C", "G", "T"中的任意一个。
 *
 * 假设我们要调查一个基因序列的变化。一次基因变化意味着这个基因序列中的一个字符发生了变化。
 *
 * 例如，基因序列由"AACCGGTT" 变化至 "AACCGGTA" 即发生了一次基因变化。
 *
 * 与此同时，每一次基因变化的结果，都需要是一个合法的基因串，即该结果属于一个基因库。
 *
 * 现在给定3个参数 — start, end, bank，分别代表起始基因序列，目标基因序列及基因库，请找出能够使起始基因序列变化为目标基因序列所需的最少变化次数。如果无法实现目标变化，请返回 -1。
 *
 * 注意:
 *
 * 起始基因序列默认是合法的，但是它并不一定会出现在基因库中。
 * 所有的目标基因序列必须是合法的。
 * 假定起始基因序列与目标基因序列是不一样的。
 * 示例 1:
 *
 * start: "AACCGGTT"
 * end:   "AACCGGTA"
 * bank: ["AACCGGTA"]
 *
 * 返回值: 1
 * 示例 2:
 *
 * start: "AACCGGTT"
 * end:   "AAACGGTA"
 * bank: ["AACCGGTA", "AACCGCTA", "AAACGGTA"]
 *
 * 返回值: 2
 * 示例 3:
 *
 * start: "AAAAACCC"
 * end:   "AACCCCCC"
 * bank: ["AAAACCCC", "AAACCCCC", "AACCCCCC"]
 *
 * 返回值: 3
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/minimum-genetic-mutation
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LeetCode_433_105 {


    int min = Integer.MAX_VALUE;

    public int minMutation(String start, String end, String[] bank) {

        if (start.equals(end)) return 0;
        if (bank == null || bank.length == 0) return -1;

        min = Integer.MAX_VALUE;
        Map<String, Boolean> map = new HashMap<>();

        Set<String> set = new HashSet<>();
        for (int i = 0; i < bank.length; i++) {
            set.add(bank[i]);
        }
        convert(set, start, end, Integer.MAX_VALUE, 0, map);
        return min == Integer.MAX_VALUE ? -1 : min;
    }

    private void convert(Set<String> set, String start, String end, int maxLevel, int level, Map<String, Boolean> map) {
        if (start.equals(end)) {
            min = Math.min(maxLevel, level);
            return;
        }

        Iterator<String> iterator = set.iterator();
        while (iterator.hasNext()) {
            String tmpBank = iterator.next();
            int diff = 0;
            for (int i = 0; i < tmpBank.length(); i++) {
                if (start.charAt(i) != tmpBank.charAt(i)) {
                    diff++;
                    if (diff > 1) {
                        break;
                    }
                }
            }
            if (diff == 1 && !map.containsKey(tmpBank)) {
                map.put(tmpBank, true);
                convert(set, tmpBank, end, maxLevel, level + 1, map);
                map.remove(tmpBank);
            }
        }
    }

    public static void main(String[] args) {

        LeetCode_433_105 l = new LeetCode_433_105();
        System.out.println(l.minMutation("AACCGGTT", "AACCGGTA", new String[]{"AACCGGTA"}));
        System.out.println(l.minMutation("AACCGGTT", "AAACGGTA", new String[]{"AACCGGTA", "AACCGCTA", "AAACGGTA"}));
        System.out.println(l.minMutation("AAAAACCC", "AACCCCCC", new String[]{"AAAACCCC", "AAACCCCC", "AACCCCCC"}));
        System.out.println(l.minMutation("AACCTTGG", "AATTCCGG", new String[]{"AATTCCGG","AACCTGGG","AACCCCGG","AACCTACC"}));
    }
}
