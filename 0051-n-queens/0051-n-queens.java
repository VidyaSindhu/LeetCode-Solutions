class Solution {
    List<List<String>> res;
    String s;
    public List<List<String>> solveNQueens(int n) {
        res = new ArrayList();
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < n; i++) sb.append('.');
        s = sb.toString();
        
        helper(n, 0, new ArrayList(), new HashSet());
        return res;
    }
    
    void helper(int n, int row, List<String> list, Set<String> set){
        // System.out.println(set);
        if(row >= n){
            res.add(new ArrayList(list));
            return;
        }
        StringBuilder sb = new StringBuilder(s);
        
        for(int i = 0; i < n; i++){
            if(set.contains("col -> " + i) || set.contains("negDg -> " + (row-i)) 
               || set.contains("posDg -> " + (row+i))) continue;
            sb.setCharAt(i, 'Q');
            set.add("col -> " + i);
            set.add("negDg -> " + (row-i));
            set.add("posDg -> " + (row+i));
            list.add(sb.toString());
            
            helper(n, row+1, list, set);
            
            sb.setCharAt(i, '.');
            set.remove("col -> " + i);
            set.remove("negDg -> " + (row-i));
            set.remove("posDg -> " + (row+i));
            list.remove(list.size()-1);
        }
    }
}