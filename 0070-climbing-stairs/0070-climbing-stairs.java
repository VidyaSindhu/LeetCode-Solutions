class Solution {
    public int climbStairs(int n) {
        if(n == 1)
            return 1;
        int[] memo = new int[n+1];
        memo[0] = 0;
        // memo[1]
        memo[1] = 1;
        memo[2] = 2;
        for(int i = 3; i < n+1; i++){
            memo[i] = memo[i-2] + memo[i-1];
        }
        
        return memo[n];
    }
}