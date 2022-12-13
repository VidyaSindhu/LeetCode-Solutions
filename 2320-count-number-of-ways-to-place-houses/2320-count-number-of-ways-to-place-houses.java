class Solution {
    int MOD = 1_000_000_007;
    public int countHousePlacements(int n) {
        int prevHousePlaced = 0, prevHouseNotPlaced = 1;
        int tmp1 = 0, tmp2 = 0;
        for(int i = 1; i <= n; i++){
            for(int j = 0; j <= 1; j++){
                if(j == 0){
                    tmp1 = (prevHousePlaced % MOD + prevHouseNotPlaced % MOD) % MOD;
                }
                else{
                    tmp2 = prevHouseNotPlaced;
                }
            }
            prevHousePlaced = tmp2;
            prevHouseNotPlaced = tmp1;
        }
        long ans = prevHousePlaced + prevHouseNotPlaced;
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