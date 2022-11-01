class Solution {
    public int[] findBall(int[][] grid) {
        int n = grid[0].length;
        int[] res = new int[n];
        
        for(int j = 0; j < n; j++){
            res[j] = dfs(grid, 0, j);
        }
        
        return res;
    }
    
    int dfs(int[][] grid, int x, int y){
        if(x == grid.length) return y;
        
        if(grid[x][y] == 1){
            if(y < grid[0].length-1 && grid[x][y+1] == 1) return dfs(grid, x+1, y+1);
        }
        else if(grid[x][y] == -1){
            if(y > 0 && grid[x][y-1] == -1) return dfs(grid, x+1, y-1);
        }
        
        
        return -1;
    }
}