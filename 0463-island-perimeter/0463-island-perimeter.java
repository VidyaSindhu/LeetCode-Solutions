class Solution {
    public int islandPerimeter(int[][] grid) {
        int ans = 0;
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(grid[i][j] == 1){
                    ans = dfs(grid, i, j);
                    break;
                }
            }
        }
        
        return ans;
    }
    
    int dfs(int[][] grid, int x, int y){
        grid[x][y] = -1;
        
        int borders = 0;
        int ans = 0;
        if(x + 1 < grid.length){
            if(grid[x+1][y] == 1){
                ans += dfs(grid, x+1, y);
            }
            else if(grid[x+1][y] == 0){
                borders++;
            }
        }
        else{
            borders++;
        }
        
        if(x - 1 >= 0){
            if(grid[x-1][y] == 1){
                ans += dfs(grid, x-1, y);
            }
            else if(grid[x-1][y] == 0){
                borders++;
            }
        }
        else{
            borders++;
        }
        if(y + 1 < grid[0].length){
            if(grid[x][y+1] == 1){
                ans += dfs(grid, x, y+1);
            }
            else if(grid[x][y+1] == 0){
                borders++;
            }
        }
        else{
            borders++;
        }
        if(y - 1 >= 0){
            if(grid[x][y-1] == 1){
                ans += dfs(grid, x, y-1);
            }
            else if(grid[x][y-1] == 0){
                borders++;
            }
        }
        else{
            borders++;
        }
        
        return ans + borders;
    }
}