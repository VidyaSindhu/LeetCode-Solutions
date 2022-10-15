class Solution {
    int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    public int shortestPath(int[][] grid, int k) {
        int m = grid.length;
        int n = grid[0].length;
        
        Deque<int[]> queue = new ArrayDeque();
        boolean[][][] visited = new boolean[m][n][k+1];
        
        // x, y, steps, changes
        queue.offer(new int[]{0, 0, 0, k});
        
        visited[0][0][k] = true;
        while(!queue.isEmpty()){
            int x = queue.peek()[0];
            int y = queue.peek()[1];
            int steps = queue.peek()[2];
            int changes = queue.poll()[3];
            if(x == m-1 && y == n-1) return steps;
            
            steps++;                       
            
            for(int[] dir: dirs){
                int newX = x + dir[0];
                int newY = y + dir[1];
                
                if(newX < 0 || newY < 0 || newX >= m || newY >= n) continue;
                
                if(grid[newX][newY] == 1){
                    if(changes > 0 && !visited[newX][newY][changes-1]) {
                        queue.offer(new int[]{newX, newY, steps, changes-1});
                        visited[newX][newY][changes-1] = true;
                    }
                }
                else if(grid[newX][newY] == 0){
                    if(visited[newX][newY][changes]) continue;
                    queue.offer(new int[]{newX, newY, steps, changes});
                    visited[newX][newY][changes] = true;
                }
            }
        }
        
        return -1;
    }
}