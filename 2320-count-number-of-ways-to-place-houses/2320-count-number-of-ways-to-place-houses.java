class Solution {
    int MOD = 1_000_000_007;
    int[][] dp;
    public int countHousePlacements(int n) {
        dp = new int[n+1][2];
        dp[0][0] = 1;
        for(int i = 1; i <= n; i++){
            for(int j = 0; j <= 1; j++){
                if(j == 0){
                    dp[i][j] = ((dp[i-1][j^1] % MOD) + dp[i-1][j] % MOD) % MOD;
                }
                else{
                    dp[i][j] = dp[i-1][j^1];
                }
            }
        }
        long ans = dp[n][0] + dp[n][1];
        return (int)(((ans % MOD) * (ans % MOD)) % MOD);
    }
    
//     long helper(int n, int prevHouse, int i){
//         if(i >= n) return 1;
        
//         long ans = 0;
//         if(dp[i][prevHouse] != null) return dp[i][prevHouse];
        
//         if(prevHouse == 1){
//             ans = helper(n, prevHouse ^ 1, i+1) % MOD;;
//         }
//         else{
//             ans = (helper(n, prevHouse, i+1) % MOD + helper(n, prevHouse ^ 1, i+1) % MOD) % MOD;
//         }
        
//         return dp[i][prevHouse] = (int)ans;
//     }
}