class Solution {
    public int firstUniqChar(String s) {
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        for(Character c: s.toCharArray()) {
            map.put(c, map.getOrDefault(c,0)+1);
        }

        for(Character c: s.toCharArray()) {
            if(map.get(c) == 1){
                return s.indexOf(c);
            }
        }

        return -1;
    }
}