class Solution {
    int MOD = 1000000007;
    public int numRollsToTarget(int n, int k, int target) {
        Integer[][] dp = new Integer[n+1][target+1];
        return helper(n, k, target, dp);
    }
    
    int helper(int n, int k, int target, Integer[][] dp){
        if(n == 1) {
            if(target <= 0) return 0;
            if(target <= k) return 1;
        }
        if(n <= 0) return 0;
        if(target <= 0) return 0;
        
        if(dp[n][target] != null) return dp[n][target];
        
        long ans = 0;
        for(int i = 1; i <= Integer.min(target, k); i++){
            if(target >= i){
                ans += helper(n-1, k, target-i, dp);
                ans %= MOD;
            }
            else break;
        }
        
        return dp[n][target] = (int)ans;
    }
}