class Solution {
    Integer[][] dp;
    public int minSideJumps(int[] obstacles) {
        int n = obstacles.length;
        dp = new Integer[n+1][4];
        return helper(obstacles, 2, 0);
    }
    
    int helper(int[] obstacles, int lane, int i){
        if(i >= obstacles.length) return 0;
        
        if(dp[i][lane] != null) return dp[i][lane];
        int ans = Integer.MAX_VALUE;
        if(i < obstacles.length-1 && obstacles[i+1] == lane){
            for(int j = 1; j <= 3; j++){
                if(obstacles[i+1] != j && obstacles[i] != j){
                    ans = Integer.min(ans, helper(obstacles, j, i + 1) + 1);
                }
            }
        }
        else{
            ans = helper(obstacles, lane, i + 1);
        }
        
        return dp[i][lane] = ans;
    }
}