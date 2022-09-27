class Solution {
    int color = 2;
    final int[][] dirs = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
    public int numEnclaves(int[][] grid) {
        Set<Integer> set = new HashSet();
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(grid[i][j] == 1){
                    dfs(grid, i, j, set);
                    color++;
                }
                
            }
        }
        
        int ans = 0;
        int total = 0;
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(grid[i][j] != 0){
                    if(set.contains(grid[i][j])){
                        ans++;
                    }
                    total++;
                }
                
            }
        }
        
        return total - ans;
    }
    
    void dfs(int[][] grid, int x, int y, Set<Integer> set){
        if(x == 0 || x == grid.length-1 || y == 0 || y == grid[0].length-1){
            set.add(color);
        }
        
        grid[x][y] = color;
        for(int[] dir : dirs){
            int newX = x + dir[0];
            int newY = y + dir[1];
            if(newX < 0 || newX >= grid.length || newY < 0 || newY >= grid[0].length || grid[newX][newY] != 1) continue;
            dfs(grid, newX, newY, set);
        }
        
    }
}