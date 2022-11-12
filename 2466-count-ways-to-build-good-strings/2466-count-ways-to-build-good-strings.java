class Solution {
    int MOD = 1_000_000_007;
    Integer[] dp;
    
    public int countGoodStrings(int low, int high, int zero, int one) {
        dp = new Integer[high + 1];
        return helper(low, high, zero, one, 0);
    }
    
    int helper(int low, int high, int zero, int one, int len){
        int ans = 0;
        if(len > high) return 0;
        if(dp[len] != null) return dp[len];
        
        if(len >= low && len <= high) ans = 1;
        
        ans += (helper(low, high, zero, one, len + zero) + helper(low, high, zero, one, len + one)) % MOD;
        return dp[len] = ans;
    }
    
    
}