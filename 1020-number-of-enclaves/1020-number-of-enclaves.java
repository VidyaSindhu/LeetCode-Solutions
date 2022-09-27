class Solution {
    int color = 2;
    final int[][] dirs = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
    public int numEnclaves(int[][] grid) {
        
        Deque<int[]> queue = new ArrayDeque();
        
        int ans = 0;
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(grid[i][j] == 1){
                    if(i == 0 || i == grid.length-1 || j == 0 || j == grid[0].length-1){
                        queue.push(new int[]{i, j});
                        grid[i][j] = -1;
                    }
                    else{
                        ans++;
                    }
                }
                
            }
        }
        // System.out.println(ans);
        while(!queue.isEmpty()){
            int[] top = queue.poll();
            int x = top[0];
            int y = top[1];
            
//             if(grid[x][y] != 1) continue;
            
//             grid[x][y] = -1;
            
            for(int[] dir : dirs){
                int newX = x + dir[0];
                int newY = y + dir[1];
                
                if(newX < 0 || newX >= grid.length || 
                   newY < 0 || newY >= grid[0].length || grid[newX][newY] != 1) continue;
                grid[newX][newY] = -1;
                ans--;
                queue.push(new int[]{newX, newY});
            }
        }
        
//         int ans = 0;
//         for(int i = 0; i < grid.length; i++){
//             for(int j = 0; j < grid[0].length; j++){
//                 if(grid[i][j] != 0){
//                     if(set.contains(grid[i][j])){
//                         ans++;
//                     }
//                     total++;
//                 }
                
//             }
//         }
        
        return ans;
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