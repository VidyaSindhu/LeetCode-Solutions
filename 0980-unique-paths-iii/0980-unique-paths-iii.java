class Solution {
    int ans = 0;
    int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    public int uniquePathsIII(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int zeroSquares = 0;
        int start[] = new int[2];
        
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(grid[i][j] == 1){
                    start[0] = i;
                    start[1] = j;
                }
                else if(grid[i][j] == 0) {
                    zeroSquares++;
                }
            }
        }
        // System.out.println(zeroSquares);
        dfs(grid, zeroSquares+1, start[0], start[1]);
            
        return ans;
    }
    
    void dfs(int[][] grid, int zeroSquares, int x, int y){
        if(grid[x][y] == 2){
            if(zeroSquares == 0) ans++;
            return;
        }
        int tmp = grid[x][y];
        grid[x][y] = -1;
        for(int[] dir: dirs){
            int newX = x + dir[0];
            int newY = y + dir[1];
            
            if(newX < 0 || newY < 0 || newX >= grid.length || newY >= grid[0].length 
              || grid[newX][newY] == -1) continue;
            
            dfs(grid, zeroSquares-1, newX, newY);
        }
        grid[x][y] = tmp;
    }
}