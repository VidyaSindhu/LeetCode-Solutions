class Solution {
    int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    public int swimInWater(int[][] grid) {
        int n = grid.length;
        int low = grid[0][0], high = n*n - 1;
        while(low <= high){
            int mid = low + (high - low)/2;
            if(isPossible(grid, mid)){
                high = mid - 1;
            }
            else{
                low = mid + 1;
            }
        }
            
        return low;
    }
    
    boolean isPossible(int[][] grid, int elevation){
        int n = grid.length;
        Deque<Integer> queue = new ArrayDeque();
        boolean[][] visited = new boolean[n][n];
        
        visited[0][0] = true;
        queue.offer(0);
        while(!queue.isEmpty()){
            int top = queue.poll();
            int x = top/n;
            int y = top - x * n;
            
            if(x == n-1 && y == n-1) return true;
            
            for(int[] dir: dirs){
                int newX = x + dir[0];
                int newY = y + dir[1];
                
                if(newX < 0 || newX >= n || newY < 0 || newY >= n || visited[newX][newY]) continue;
                
                if(elevation >= grid[newX][newY]){
                    visited[newX][newY] = true;
                    queue.offer(newX * n + newY);
                }
            }
        }
        
        return false;
    }
}