class Solution {
    int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    public int nearestExit(char[][] maze, int[] entrance) {
        int m = maze.length;
        int n = maze[0].length;
        
        
        Deque<int[]> queue = new ArrayDeque();
        queue.offer(new int[]{entrance[0], entrance[1], 0});
        maze[entrance[0]][entrance[1]] = '+';
        
        while(!queue.isEmpty()){
            int[] top = queue.poll();
            int x = top[0];
            int y = top[1];
            int steps = top[2];            
            
            for(int[] dir: dirs){
                int newX = x + dir[0];
                int newY = y + dir[1];
                
                if(newX < 0 || newY < 0 || newX >= m || newY >= n || maze[newX][newY] == '+') continue;
                
                if(newX == 0 || newY == 0 || newX == m-1 || newY == n-1) return steps+1;
                
                queue.offer(new int[]{newX, newY, steps+1});
                maze[newX][newY] = '+';
            }
        }
        
        return -1;
        
        
        
    }
}