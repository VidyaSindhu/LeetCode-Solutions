class Solution {
    int[] dp = new int[101];
    public int numDecodings(String s) {
        Arrays.fill(dp, -1);
        return numDecodings(s, 0);
    }
    int numDecodings(String s, int pos){
        if(pos == s.length()) return 1;
        if(pos > s.length()) return 0;
        
        if(dp[pos] != -1) return dp[pos];
        int ans = 0;
        if(s.charAt(pos) == '0'){
            ans = 0;
        }
        else if(s.charAt(pos) == '1'){
            ans += numDecodings(s, pos+1);
            ans += numDecodings(s, pos + 2);
        }
        else if(s.charAt(pos) == '2'){
            ans += numDecodings(s, pos + 1);
            if(pos < s.length() - 1 && s.charAt(pos+1) < '7'){
                ans += numDecodings(s, pos+2);
            }
        }
        else{
            ans += numDecodings(s, pos+1);
        }
            
        return dp[pos] = ans;
    }
}