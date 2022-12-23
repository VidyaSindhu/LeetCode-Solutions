class Solution {
    Integer[][] dp;
    public int maxProfit(int[] prices) {
        dp = new Integer[prices.length+1][2];
        return helper(prices, 0, 0);
    }
    
    int helper(int[] prices, int state, int pos){
        if(pos >= prices.length) return 0;
        
        if(dp[pos][state] != null) return dp[pos][state];
        int ans = helper(prices, state, pos+1);
        
        if(state == 0){
            ans = Integer.max(ans, helper(prices, state ^ 1, pos + 1) - prices[pos]);
        }
        else{
            ans = Integer.max(ans, helper(prices, state ^ 1, pos + 2) + prices[pos]);
        }
        
        return dp[pos][state] = ans;
    }
}