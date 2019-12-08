package Leetcode_49_470;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        if (strs.length == 0) {
            return new ArrayList();
        }

        Map<String, List> hm = new HashMap<String, List>();
        char[] tmp;
        for (String str :
                strs) {
            tmp = str.toCharArray();
            Arrays.sort(tmp);
            String tmpStr = String.valueOf(tmp);
            if (!hm.containsKey(tmpStr)) {
                hm.put(tmpStr, new ArrayList());
            }
            hm.get(tmpStr).add(str);

        }

        return new ArrayList(hm.values());
    }
}