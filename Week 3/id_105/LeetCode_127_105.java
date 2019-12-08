package id_105;

import java.util.*;

public class LeetCode_127_105 {

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        List<List<String>> lists = new ArrayList<List<String>>();
        if (!wordList.contains(endWord)) {
            return 0;
        }

        Queue<String> queue = new LinkedList<>();
        queue.add(beginWord);
        wordList.remove(beginWord);

        int res = 0;
        while (!queue.isEmpty()) {
            res++;
            int length = queue.size();
            for (int i = 0; i < length; i++) {
                String cur = queue.remove();
                Iterator<String> iterator = wordList.iterator();
                while (iterator.hasNext()) {
                    String next = iterator.next();

                    int dif = 0;
                    for (int j = 0; j < cur.length(); j++) {
                        if (cur.charAt(j) == next.charAt(j)) {
                            continue;
                        }
                        dif++;
                    }

                    if (dif == 1) {
                        iterator.remove();
                        if (next.equals(endWord)) {
                            return res+1;
                        } else {
                            queue.add(next);
                        }
                    }
                }
            }
        }
        return 0;
    }
}
