class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        
        if (strs.length == 0) return null;
        
        Map<String, List<String>> map = new HashMap<String, List<String>>();
        
        int index = 0;
        
        for (int i=0; i<strs.length; i++) {
            
            char[] tmpStr = strs[i].toCharArray();
            
            Arrays.sort(tmpStr);
            
            String key = String.valueOf(tmpStr);
            
            if (!map.containsKey(key)) {
                
                map.put(key, new ArrayList<String>());
                
            }
            
            map.get(key).add(strs[i]);
        }
        
        return new ArrayList(map.values());   
    }
}

// 自己写
// class Solution {
//     public List<List<String>> groupAnagrams(String[] strs) {
        
//         Map<String, Integer> map = new HashMap<String, Integer>();
//         List<List<String>> res = new ArrayList<List<String>>();
        
//         int index = 0;
        
//         for (int i=0; i<strs.length; i++) {
            
//             char[] tmpStr = strs[i].toCharArray();
            
//             Arrays.sort(tmpStr);
            
//             if (map.containsKey(String.valueOf(tmpStr))) {
                
//                 index = map.get(String.valueOf(tmpStr));
                
//                 res.get(index).add(strs[i]);
                
//             } else {
                
//                 res.add(new ArrayList<String>());
                
//                 index = res.size()-1;
                
//                 res.get(index).add(strs[i]);
                
//                 map.put(String.valueOf(tmpStr), index);
//             }
//         }
        
//         return res;        
//     }
// }
