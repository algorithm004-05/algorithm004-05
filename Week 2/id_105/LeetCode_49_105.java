package id_105;

import java.util.*;

public class LeetCode_49_105 {

    public List<List<String>> groupAnagrams(String[] strs) {

        Map<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String newString = new String(chars);
            List<String> list = map.get(newString);
            if (list == null) {
                list = new ArrayList<>();
                map.put(newString, list);
            }
            list.add(str);
        }

        List<List<String>> lists = new ArrayList<>();
        Iterator<Map.Entry<String, List<String>>> iterator = map.entrySet().iterator();

        while (iterator.hasNext()) {
            Map.Entry<String, List<String>> entry = iterator.next();
            lists.add(entry.getValue());
        }
        return lists;

    }
}
