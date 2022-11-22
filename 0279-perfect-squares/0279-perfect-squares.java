class Solution {
    public int numSquares(int n) {
        int[] squares = new int[101];
        for(int i = 1; i < 101; i++){
            squares[i] = i*i;
        }
        
        int[] memo = new int[n+1];
        Arrays.fill(memo, Integer.MAX_VALUE);
        memo[0] = 0;
        for(int i = 1; i < n+1; i++){
            for(int j = 1; j < 101; j++){
                if(i >= squares[j]){
                    memo[i] = Integer.min(memo[i], memo[i-squares[j]] + 1);
                }
            }
        }
        
        return memo[n];
    }
}