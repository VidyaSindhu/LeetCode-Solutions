class Solution {
    int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    public int shortestPath(int[][] grid, int k) {
        int m = grid.length;
        int n = grid[0].length;
        
        boolean[][][] visited = new boolean[m][n][k+1];
        Deque<int[]> queue = new ArrayDeque();
        
        queue.offer(new int[]{0, 0, 0, k});
        
        visited[0][0][k] = true;
        
        while(!queue.isEmpty()){
            int[] top = queue.poll();
            int steps = top[2];
            if(top[0] == m-1 && top[1] == n-1) return steps;
            
            steps++;
            int changes = top[3];
            
            for(int[] dir: dirs){
                int newX = top[0] + dir[0];
                int newY = top[1] + dir[1];
                
                if(newX < 0 || newY < 0 || newX >= m || newY >= n) continue;
                
                if(grid[newX][newY] == 1){
                    if(changes > 0 && !visited[newX][newY][changes-1]){
                        queue.offer(new int[]{newX, newY, steps, changes-1});
                        visited[newX][newY][changes-1] = true;
                    }
                }
                else if(!visited[newX][newY][changes]){
                    queue.offer(new int[]{newX, newY, steps, changes});
                    visited[newX][newY][changes] = true;
                    
                }
            }
        }
        
        return -1;
    }
}