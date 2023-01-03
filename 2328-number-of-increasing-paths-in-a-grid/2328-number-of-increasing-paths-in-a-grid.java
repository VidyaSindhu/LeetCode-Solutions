class Solution {
    int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    int MOD = 1_000_000_007;
    public int countPaths(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        
        long ans = 0l;
        Long[][] dp = new Long[m][n];
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                ans = (ans + helper(grid, i, j, dp)) % MOD;
            }
        }
        
        return (int)ans;
    }
    
    long helper(int[][] grid, int x, int y, Long dp[][]){
        
        if(dp[x][y] != null) return dp[x][y];
        
        long ans = 1l;
        for(int[] dir: dirs){
            int newX = x + dir[0];
            int newY = y + dir[1];
            
            if(newX < 0 || newY < 0 || newX >= grid.length || newY >= grid[0].length) continue;
            
            if(grid[newX][newY] < grid[x][y]){
                ans = (ans + helper(grid, newX, newY, dp)) % MOD;
            }
        }
        
        return dp[x][y] = ans;
    }
}