class Solution {
    public int numSquares(int n) {
        int[] squares = new int[100];
        for(int i = 1; i < 101; i++){
            squares[i-1] = i*i;
        }
        
        int memo[][] = new int[100+1][n+1];
        
        for(int i = 0; i < n+1; i++){
            memo[0][i] = Integer.MAX_VALUE;
            memo[1][i] = i;
        }
        
        for(int i = 0; i < 101; i++){
            memo[i][0] = 0;
        }
        
        for(int i = 1; i < 101; i++){
            for(int j = 1; j < n+1; j++){
                if(squares[i-1] <= j){
                    memo[i][j] = Math.min(memo[i-1][j], memo[i][j-squares[i-1]] + 1);
                }
                else{
                    memo[i][j] = memo[i-1][j];
                }
            }
        }
        
        return memo[100][n];
    }
}