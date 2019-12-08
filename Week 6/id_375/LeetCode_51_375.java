class Solution {
    public List<List<String>> solveNQueens(int n) {
        return nQueens(new LinkedList<>(), n);
    }
    
    private List<List<String>> nQueens(LinkedList<Integer> current, int n) {
        List<List<String>> ret = new ArrayList<>();
        if (current.size() == n) {
            ret.add(convert(current));
            return ret;
        }
        for (int i = 0; i < n; i++) {
            if (valid(current, i)) {
                current.add(i);
                ret.addAll(nQueens(current, n));
                current.removeLast();
            }
        }
        return ret;
    }
    
    private boolean valid(List<Integer> current, int next) {
        int s = current.size();
        for (int i = 0; i < current.size(); i++) {
            int position = current.get(i);
            if (position == next) {
                return false;
            }
            int x = position - next;
            int y = s - i;
            if (x == y || x + y == 0) {
                return false;
            }
        }
        return true;
    }
    
    private List<String> convert(List<Integer> from) {
        List<String> value = new ArrayList<>(from.size());
        for (int position : from) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < from.size(); i++) {
                sb.append(i == position ? 'Q' : '.');
            }
            value.add(sb.toString());
        }
        return value;
    }
    
}
