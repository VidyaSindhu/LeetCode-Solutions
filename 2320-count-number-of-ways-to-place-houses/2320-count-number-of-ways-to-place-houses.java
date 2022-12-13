class Solution {
    int MOD = 1_000_000_007;
    Integer[][] dp;
    public int countHousePlacements(int n) {
        dp = new Integer[n+1][2];
        long ans = helper(n, 0, 0);
        // long ans = dp[0][0];
        return (int)(((ans % MOD) * (ans % MOD)) % MOD);
    }
    
    long helper(int n, int prevHouse, int i){
        if(i >= n) return 1;
        
        long ans = 0;
        if(dp[i][prevHouse] != null) return dp[i][prevHouse];
        
        if(prevHouse == 1){
            ans = helper(n, prevHouse ^ 1, i+1) % MOD;;
        }
        else{
            ans = (helper(n, prevHouse, i+1) % MOD + helper(n, prevHouse ^ 1, i+1) % MOD) % MOD;
        }
        
        return dp[i][prevHouse] = (int)ans;
    }
}