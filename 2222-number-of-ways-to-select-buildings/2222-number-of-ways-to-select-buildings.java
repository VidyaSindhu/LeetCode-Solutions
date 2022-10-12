import java.util.*;
class Solution {
    public long numberOfWays(String s) {
        int n = s.length();
        long[][][] dp = new long[n+1][4][2];
        
        dp[0][0][0] = dp[0][0][1] = 1;
        
        for(int i = 1; i < n+1; i++){
            for(int j = 0; j < 4; j++){
                dp[i][j][0] += (s.charAt(i-1)=='0' && j>=1) ? dp[i-1][j-1][1] + dp[i-1][j][0] : dp[i-1][j][0];
                dp[i][j][1] += (s.charAt(i-1)=='1' && j>=1) ? dp[i-1][j-1][0] + dp[i-1][j][1] : dp[i-1][j][1];
            }
        }
        // System.out.println(Arrays.deepToString(dp)); 
        return dp[n][3][0] + dp[n][3][1];
    }
}