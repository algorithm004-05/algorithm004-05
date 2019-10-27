class Solution {
    
    Map<Character, String> values = new HashMap<>();
    
    public List<String> letterCombinations(String digits) {
        values.put('2', "abc");
        values.put('3', "def");
        values.put('4', "ghi");
        values.put('5', "jkl");
        values.put('6', "mno");
        values.put('7', "pqrs");
        values.put('8', "tuv");
        values.put('9', "wxyz");
        if (digits == null || digits.length() == 0) {
            return new ArrayList<>();
        }
        return myLetterCombinations(digits);
    }    
    
    private List<String> myLetterCombinations(String digits) {

        List<String> ret = new ArrayList<>();
        
        if (digits == null || digits.length() == 0) {
            ret.add("");
            return ret;
        }
        
        char c = digits.charAt(0);
        String sub = digits.substring(1);
        String value = values.get(c);
        for (String s : myLetterCombinations(sub)) {
            for (int i = 0; i < value.length(); i++) {
                ret.add(value.charAt(i) + s);
            }
        }
        return ret;
    }
}
