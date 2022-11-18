class Solution {
    public int getLucky(String s, int k) {
        int ans = 0;
        StringBuilder sb = new StringBuilder();
        for(char c: s.toCharArray()){
            sb.append((int)(c - 'a' + 1));
        }
        s = sb.toString();
        while(k --> 0){
            ans = 0;
            for(char c: s.toCharArray()){
                ans += (int)(c - '0');
            }
            s = String.valueOf(ans);
        }
        
        return ans;
    }
}