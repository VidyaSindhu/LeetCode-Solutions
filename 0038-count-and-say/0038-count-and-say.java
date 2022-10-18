class Solution {
    public String countAndSay(int n) {
        return helper(n).toString();
    }
    
    StringBuilder helper(int n){
        if(n == 1) return new StringBuilder("1");
        
        StringBuilder s = helper(n-1);
        // System.out.println(s);
        StringBuilder res = new StringBuilder();
        int count = -1;
        char lastChar = '0';
        for(char c : s.toString().toCharArray()){
            if(lastChar != c){
                if(count > 0){
                    res.append(count);
                    res.append(lastChar);
                }
                count = 1;
                lastChar = c;
            }
            else{
                count++;
            }
        }
        if(count > 0){
            res.append(count);
            res.append(lastChar);
        }
        
        return res;
    }
}