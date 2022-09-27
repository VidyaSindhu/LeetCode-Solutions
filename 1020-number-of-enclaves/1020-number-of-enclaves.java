class Solution {
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

        while(!queue.isEmpty()){
            int[] top = queue.poll();
            int x = top[0];
            int y = top[1];
            
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
        return ans;
    }
}