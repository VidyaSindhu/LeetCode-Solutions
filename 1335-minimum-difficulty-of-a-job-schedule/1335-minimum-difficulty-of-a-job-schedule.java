class Solution {
    
    public int minDifficulty(int[] jobDifficulty, int d) {
        Integer[][] dp = new Integer[jobDifficulty.length+1][d+1];
        int ans = helper(jobDifficulty, 0, d, dp);
        return ans >= Integer.MAX_VALUE/2 ? -1 : ans;
    }
    
    int helper(int[] jobDifficulty, int pos, int d, Integer[][] dp){
        if(d <= 0) {
            if(pos >= jobDifficulty.length) return 0;
            return Integer.MAX_VALUE/2;
        }
        
        if(pos >= jobDifficulty.length) return Integer.MAX_VALUE/2;
        
        if(dp[pos][d] != null) return dp[pos][d];
        
        int ans = Integer.MAX_VALUE;
        int maxDifficulty = jobDifficulty[pos];
        for(int i = pos; i < jobDifficulty.length; i++){
            maxDifficulty = Integer.max(maxDifficulty, jobDifficulty[i]);
            ans = Integer.min(ans, maxDifficulty + helper(jobDifficulty, i+1, d-1, dp));
        }
        
        return dp[pos][d] = ans;
    }
}